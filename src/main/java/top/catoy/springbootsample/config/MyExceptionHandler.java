package top.catoy.springbootsample.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.catoy.springbootsample.exception.ServiceException;
import top.catoy.springbootsample.model.BaseResponse;


@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = ServiceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResponse<String> exceptionHandler(Exception e) {
        System.out.println("未知异常！原因是:" + e);
        return BaseResponse.ok(e.getMessage());
    }
}