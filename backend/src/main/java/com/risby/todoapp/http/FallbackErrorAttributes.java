package com.risby.todoapp.http;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

// src: https://www.baeldung.com/exception-handling-for-rest-with-spring#spring-boot
// Customizes Spring Boot's default "Whitelabel error page" to remove potentially app sensitive info
@Component
public class FallbackErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String,Object> errorAttributes =  super.getErrorAttributes(webRequest, options);
        errorAttributes.remove("message");
        errorAttributes.remove("path");
        return errorAttributes;
    }
}
