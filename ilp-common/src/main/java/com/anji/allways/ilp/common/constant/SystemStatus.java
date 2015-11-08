package com.anji.allways.ilp.common.constant;

import com.anji.allways.ilp.common.Response;

/**
 * Created by heylear on 15/11/7.
 */
public enum SystemStatus implements Response {

    /**
     * http status
     */
    HTTP_OK(200, "Successful!"),
    HTTP_NOT_FOUND(404, "Not found!"),
    HTTP_NOT_SUPPORT(405, "Not support method!"),
    HTTP_NO_PERMISSION(403, "No permission!"),
    HTTP_ERROR(500, "An error occurred!"),

    /**
     * system exception
     */
    SYS_EXCEP(10001, "系统异常"),
    SYS_RUNTIME_EXCEP(10002, "系统运行时异常");



    int status;

    String message;

    SystemStatus(int status, String message) {
        this.status = status;
        this.message = message;
    }

    @Override
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
