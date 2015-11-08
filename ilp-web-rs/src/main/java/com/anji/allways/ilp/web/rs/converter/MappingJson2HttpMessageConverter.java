package com.anji.allways.ilp.web.rs.converter;

import com.alibaba.fastjson.JSONObject;
import com.anji.allways.ilp.common.beans.RestResponse;
import com.anji.allways.ilp.common.constant.SystemStatus;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.GenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

/**
 * Created by heylear on 15/11/6.
 */
public class MappingJson2HttpMessageConverter extends AbstractHttpMessageConverter<Object>
        implements GenericHttpMessageConverter<Object> {

    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    public MappingJson2HttpMessageConverter() {
        super(new MediaType("application", "json", DEFAULT_CHARSET));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        String inputBody = StreamUtils.copyToString(inputMessage.getBody(), DEFAULT_CHARSET);
        return JSONObject.parseObject(inputBody, clazz);
    }

    @Override
    protected void writeInternal(Object object, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        if (object instanceof SystemStatus) {
            object = new RestResponse((SystemStatus)object);
        }
        StreamUtils.copy(JSONObject.toJSONString(object), DEFAULT_CHARSET, outputMessage.getBody());
    }

    public boolean canRead(Type type, Class<?> contextClass, MediaType mediaType) {
        return true;
    }

    public Object read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return this.readInternal((Class) type, inputMessage);
    }
}

