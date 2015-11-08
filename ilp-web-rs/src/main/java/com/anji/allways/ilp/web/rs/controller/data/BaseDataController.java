package com.anji.allways.ilp.web.rs.controller.data;

import com.anji.allways.ilp.common.Response;
import com.anji.allways.ilp.common.beans.RestResponse;
import com.anji.allways.ilp.common.exception.SystemException;
import com.anji.allways.ilp.common.exception.SystemRuntimeException;
import com.anji.allways.ilp.service.api.data.BaseDataService;
import com.anji.allways.ilp.web.rs.controller.DefaultController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by heylear on 15/11/7.
 */
@RestController
@RequestMapping("/data")
public class BaseDataController extends DefaultController {

    @Autowired
    BaseDataService baseDataService;

    @RequestMapping(value = "/banks",method = RequestMethod.GET)
    public Response getBanks() {
        return new RestResponse(baseDataService.getPayBankList());
    }

    @RequestMapping(value = "/regions",method = RequestMethod.GET)
    public Response getRegions() throws Exception{
        return new RestResponse(baseDataService.getRegionList());
    }

    @RequestMapping(value = "/dictionaries",method = RequestMethod.GET)
    public Response getDictionaries() {
        return new RestResponse(baseDataService.getDictCodeList());
    }
}
