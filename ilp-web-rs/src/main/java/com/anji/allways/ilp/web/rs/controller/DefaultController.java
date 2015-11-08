package com.anji.allways.ilp.web.rs.controller;

import com.anji.allways.ilp.common.Response;
import com.anji.allways.ilp.common.constant.SystemStatus;
import com.anji.allways.ilp.common.exception.SystemException;
import com.anji.allways.ilp.common.exception.SystemRuntimeException;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by heylear on 15/11/7.
 */
public class DefaultController {

    protected Logger logger = Logger.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    public Response exceptionHandler(Exception ex) {
        logger.error(ex.getMessage(), ex);
        return SystemStatus.HTTP_ERROR;
    }

    @ExceptionHandler(SystemException.class)
    public Response exceptionHandler(SystemException ex) {
        return ex.getSystemStatus();
    }

    @ExceptionHandler(SystemRuntimeException.class)
    public Response exceptionHandler(SystemRuntimeException ex) {
        return ex.getSystemStatus();
    }
}
