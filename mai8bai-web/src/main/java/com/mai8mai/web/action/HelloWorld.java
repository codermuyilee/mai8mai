package com.mai8mai.web.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;

// 父包

@Results( { @Result(name = "success", location = "/msg.jsp"),
        @Result(name = "error", location = "/error.jsp") })
@ExceptionMappings( { @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") })
public class HelloWorld extends ActionSupport {
    public final static String MESSAGE = "Struts2 is up and running ..1.";

    private String message;


    /**
     * @return the message
     */
    @Action(value = "hello",results = {@Result(name="success",location = "/HelloWorld.jsp")})
    public String hello() {
        message=MESSAGE;
        return "success";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}