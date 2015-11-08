package com.anji.allways.ilp.common.exception;

import com.anji.allways.ilp.common.constant.SystemStatus;

/**
 * Created by heylear on 15/11/7.
 */
public class SystemRuntimeException extends RuntimeException {

    SystemStatus systemStatus = SystemStatus.SYS_RUNTIME_EXCEP;

    public SystemRuntimeException() {
    }

    public SystemRuntimeException(SystemStatus systemStatus){
        super(systemStatus.getMessage());
        this.systemStatus = systemStatus;
    }

    public SystemStatus getSystemStatus() {
        return systemStatus;
    }
}
