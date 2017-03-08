package com.fangxp.controller;

import com.fangxp.annotation.Controller;
import com.fangxp.annotation.Qualifier;
import com.fangxp.annotation.RequestMapping;
import com.fangxp.service.MichealService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by michael on 2017/3/8.
 */
@Controller("micheal")
public class MichealController {

    private static final Logger logger = LoggerFactory.getLogger(MichealController.class);

    @Qualifier("michealService")
    private MichealService michealService;

    @RequestMapping("insert")
    public String insert(HttpServletRequest request, HttpServletResponse response) {
        logger.info("MichealController:执行insert方法");
        michealService.insert();
        return null;
    }

    @RequestMapping("update")
    public String update(HttpServletRequest request, HttpServletResponse response){
        logger.info("MichealController:执行update方法");
        return null;
    }

    @RequestMapping("select")
    public String select(HttpServletRequest request, HttpServletResponse response){
        logger.info("MichealController:select");
        return null;
    }

    @RequestMapping("delete")
    public String delete(HttpServletRequest request, HttpServletResponse response){
        logger.info("MichealController:delete");
        return null;
    }


}
