package com.anji.allways.ilp.web.rs.controller.data;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by heylear on 15/11/7.
 */
@WebAppConfiguration
@ContextConfiguration({"classpath:spring/applicationContext.xml", "classpath:web/spring-restful.xml"})
public class BaseDataControllerTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    WebApplicationContext context;

    /*@Autowired
    private FilterChainProxy springSecurityFilterChain;*/

    protected MockMvc mvc;

    @InjectMocks
    BaseDataController baseDataController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }


    @Test
    public void testGetRegionList() throws Exception {
        mvc.perform(get("/data/regions").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testGetBankList() throws Exception {
        mvc.perform(get("/data/banks").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testGetDictCodeList() throws Exception {
        mvc.perform(get("/data/dictionaries").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }
}