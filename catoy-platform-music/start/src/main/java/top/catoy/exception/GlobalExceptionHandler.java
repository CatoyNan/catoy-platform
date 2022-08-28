package top.catoy.exception;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.catoy.dto.data.ErrorCode;

import java.util.stream.Collectors;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BizException.class)
    @ResponseStatus(HttpStatus.OK)
    public MultiResponse businessExceptionHandler(BizException e) {
        log.error("发生业务异常", e);
        return MultiResponse.buildFailure(e.getErrCode(), e.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    public MultiResponse methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        log.error("发生无效参数异常", e);
        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        return MultiResponse.buildFailure(ErrorCode.PARAMETER_VALIDATION_ERROR.getCode(), message);
    }
}