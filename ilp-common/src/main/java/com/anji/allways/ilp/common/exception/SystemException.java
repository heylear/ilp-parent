package com.anji.allways.ilp.common.exception;

import com.anji.allways.ilp.common.constant.SystemStatus;

/**
 * Created by heylear on 15/11/7.
 */
public class SystemException extends Exception {
    SystemStatus systemStatus = SystemStatus.SYS_EXCEP;

    public SystemException() {
    }

    public SystemException(SystemStatus systemStatus){
        super(systemStatus.getMessage());
        this.systemStatus = systemStatus;
    }

    public SystemStatus getSystemStatus() {
        return systemStatus;
    }
}
