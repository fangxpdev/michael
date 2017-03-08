package com.fangxp.servlet;

import com.fangxp.annotation.Controller;
import com.fangxp.annotation.Qualifier;
import com.fangxp.annotation.RequestMapping;
import com.fangxp.annotation.Service;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

/**
 * Created by michael on 2017/3/8.
 */
@WebServlet
public class DispatcherServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);


    private List<String> fileNames = new ArrayList<String>();

    private Map<String, Object> instanceMap = new HashMap<String, Object>();

    private Map<String, Object> handerMaping = new HashMap<>();


    @Override
    public void init() throws ServletException {
        //扫描基包
        doScanBasePackage("com.fangxp");
        //找到实例
        try {
            //实例化
            filterAndInstance();
            //依赖注入
            springIOC();
            handerMaping();
        } catch (Exception e) {

        }

    }

    private void handerMaping() {
        if (MapUtils.isEmpty(instanceMap)) {
            return;
        }
        for (Map.Entry<String, Object> entry : instanceMap.entrySet()) {
            Class clz = entry.getValue().getClass();
            if (clz.isAnnotationPresent(Controller.class)) {
                String baseUrl = entry.getValue().getClass().getAnnotation(Controller.class).value();
                if (StringUtils.isEmpty(baseUrl)) {
                    baseUrl = StringUtils.uncapitalize(clz.getName());
                }
                Method[] methods = clz.getMethods();
                if (methods == null || methods.length == 0) {
                    continue;
                }
                for (Method method : methods) {
                    String url = method.getAnnotation(RequestMapping.class).value();
                    handerMaping.put(buildURL(baseUrl, url), method);
                }
            }
        }
    }

    private String buildURL(String baseUrl, String url) {
        baseUrl = baseUrl.startsWith("/") ? baseUrl : StringUtils.join("/",baseUrl);
        url = url.startsWith("/") ? url : StringUtils.join( "/",url);
        return baseUrl + url;
    }

    private void springIOC() throws IllegalAccessException {
        if (MapUtils.isEmpty(instanceMap)) {
            return;
        }
        for (Map.Entry<String, Object> entry : instanceMap.entrySet()) {
            Field[] fields = entry.getValue().getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Qualifier.class)) {
                    Qualifier qualifier = field.getAnnotation(Qualifier.class);
                    String key = qualifier.value();
                    if (StringUtils.isEmpty(key)) {
                        key = StringUtils.uncapitalize(field.getType().getName());
                    }
                    field.setAccessible(true);
                    field.set(entry.getValue(), instanceMap.get(key));
                }
            }
        }
    }

    private void filterAndInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (fileNames == null || fileNames.size() <= 0) {
            return;
        }
        for (String fileName : fileNames) {
            String tempFileName = fileName.replace(".class", "");
            Class clz = Class.forName(tempFileName);
            if (clz.isAnnotationPresent(Controller.class)) {
                Object instance = clz.newInstance();
                Controller controller = (Controller) clz.getAnnotation(Controller.class);
                String key = controller.value();
                if (StringUtils.isEmpty(key)) {
                    key = StringUtils.uncapitalize(trimPackage(fileName));
                }
                instanceMap.put(key, instance);
            } else if (clz.isAnnotationPresent(Service.class)) {
                Object instance = clz.newInstance();
                Service service = (Service) clz.getAnnotation(Service.class);
                String key = service.value();
                if (StringUtils.isEmpty(key)) {
                    key = StringUtils.uncapitalize(trimPackage(tempFileName));
                }
                instanceMap.put(key, instance);
            } else {
                continue;
            }
        }
    }

    private static String trimPackage(String fileName) {
        String[] fileNames = fileName.split(".");
        return fileNames[fileNames.length - 1];
    }

    private void doScanBasePackage(String basePackage) {
        URL url = this.getClass().getResource("/" + basePackage.replace(".", "/"));
        String filePath = url.getFile();
        File file = new File(filePath);
        File[] files = file.listFiles();
        if (files != null && files.length > 0) {
            for (File file1 : files) {
                if (file1.isDirectory()) {
                    doScanBasePackage(basePackage + "." + file1.getName());
                } else if (file1.isFile()) {
                    logger.info("扫描到文件：" + file1.getName());
                    fileNames.add(basePackage + "." + file1.getName());
                }
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("doPost");
        String servletPath = req.getServletPath();
        req.getContextPath();
        req.getRequestURI();
        req.getRequestURL();
        Method method = (Method)handerMaping.get(servletPath);
        if (method == null) {
            PrintWriter print = resp.getWriter();
            resp.setCharacterEncoding("utf-8");
            print.print("无对应方法");
            print.flush();
            print.close();
            return;
        }
        Object owner = instanceMap.get(servletPath.split("/")[1]);
        try {
            method.invoke(owner,new Object[]{req,resp});
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }


}
