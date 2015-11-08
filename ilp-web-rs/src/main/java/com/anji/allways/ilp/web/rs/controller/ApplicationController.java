package com.anji.allways.ilp.web.rs.controller;

import com.anji.allways.ilp.common.Response;
import com.anji.allways.ilp.common.constant.SystemStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by heylear on 15/11/7.
 */
@RestController
public class ApplicationController extends DefaultController {

    @RequestMapping("/ping")
    public Response ping(){
        return SystemStatus.HTTP_OK;
    }

    @RequestMapping("/403")
    public Response error403(){
        return SystemStatus.HTTP_NO_PERMISSION;
    }

    @RequestMapping("/404")
    public Response error404(){
        return SystemStatus.HTTP_NOT_FOUND;
    }

    @RequestMapping("/405")
    public Response error405(){
        return SystemStatus.HTTP_NOT_SUPPORT;
    }

    @RequestMapping("/500")
    public Response error500(){
        return SystemStatus.HTTP_ERROR;
    }
}
