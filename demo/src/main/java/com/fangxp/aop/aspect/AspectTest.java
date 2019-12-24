package com.fangxp.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * Created by michael on 2017/3/16.
 */
@Aspect
@Configuration
public class AspectTest {

    private static final Logger logger = LoggerFactory.getLogger(AspectTest.class);

    @Pointcut("execution(* com.fangxp.aop.service.TestService.*(..))")
    private void anyMethod(){}//定义一个切入点


//    @Before("anyMethod() && args(name)")
    public void doAccessCheck(String name){
        logger.debug(name);
        logger.debug("@Before=====");
    }

//    @AfterReturning("anyMethod()")
    public void doAfter(){
        logger.debug("@AfterReturning====");
    }

//    @After("anyMethod()")
    public void after(){
        logger.debug("@After====");
    }

//    @AfterThrowing("anyMethod()")
    public void doAfterThrow(){
        logger.debug("@AfterThrowing====");
    }

    @Around("anyMethod()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable{
        logger.debug("@Around start======");
        Object object = pjp.proceed();//执行该方法
        logger.debug("@Around end=====");
        return object;
    }


}
