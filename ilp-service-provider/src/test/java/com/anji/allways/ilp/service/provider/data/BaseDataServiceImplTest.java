package com.anji.allways.ilp.service.provider.data;

import com.alibaba.fastjson.JSONObject;
import com.anji.allways.ilp.service.api.data.BaseDataService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.junit.Assert.*;

/**
 * Created by heylear on 15/11/7.
 */
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class BaseDataServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    BaseDataService baseDataService;

    @Test
    public void testGetPayBankList() throws Exception {
        logger.debug(JSONObject.toJSONString(baseDataService.getPayBankList()));
    }

    @Test
    public void testGetRegionList() throws Exception {
        logger.debug(JSONObject.toJSONString(baseDataService.getRegionList()));
    }

    @Test
    public void testGetDictCodeList() throws Exception {
        logger.debug(JSONObject.toJSONString(baseDataService.getDictCodeList()));
    }
}