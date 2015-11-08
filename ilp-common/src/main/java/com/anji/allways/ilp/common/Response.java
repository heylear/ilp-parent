package com.anji.allways.ilp.common;

import java.io.Serializable;

/**
 * Created by heylear on 15/11/7.
 */
public interface Response extends Serializable {
    int getStatus();
    String getMessage();
}
