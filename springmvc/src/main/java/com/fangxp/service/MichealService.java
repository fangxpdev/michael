package com.fangxp.service;

import com.fangxp.annotation.Service;
import com.fangxp.controller.MichealController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by michael on 2017/3/8.
 */
@Service("michealService")
public class MichealService {

    private static final Logger logger = LoggerFactory.getLogger(MichealController.class);

    public void insert() {
        logger.info("MichealService:执行insert方法");
    }


}
