package com.anji.allways.ilp.common.beans;

import com.anji.allways.ilp.common.Response;
import com.anji.allways.ilp.common.constant.SystemStatus;

/**
 * Created by heylear on 15/11/7.
 */
public class RestResponse implements Response {

    int status = SystemStatus.HTTP_OK.getStatus();

    String message = SystemStatus.HTTP_OK.getMessage();

    Object data;

    public RestResponse() {

    }

    public RestResponse(SystemStatus systemStatus) {
        this.status = systemStatus.getStatus();
        this.message = systemStatus.getMessage();
    }

    public RestResponse(Object data) {
        this.data = data;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }
}
