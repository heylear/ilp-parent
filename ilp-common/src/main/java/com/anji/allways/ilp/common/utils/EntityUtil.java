package com.anji.allways.ilp.common.utils;

import com.anji.allways.ilp.common.exception.SystemRuntimeException;
import org.springframework.beans.BeanUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by heylear on 15/11/7.
 */
public class EntityUtil extends BeanUtils {
    public static <T, K> List<T> copy(List<K> sourceList, Class<T> cls) {

        List<T> destList = new LinkedList<>();

        try {
            for (K k : sourceList) {
                T t = cls.newInstance();
                copyProperties(k, t);
                destList.add(t);
            }
        } catch (Exception e) {
            throw new SystemRuntimeException();
        }

        return destList;
    }
}
