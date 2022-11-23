package com.zph.common;

import com.zph.Utils.R;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.BindException;
import java.util.Objects;

@Component
@RestControllerAdvice
public class GlobleExceptionhandle {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R<String> exceptionHandle(MethodArgumentNotValidException ex) {
        ex.printStackTrace();
        return R.error(Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage());
    }

    @ExceptionHandler(value = RuntimeException.class)
    public R<String> runtimeHandle(RuntimeException ex) {
        ex.printStackTrace();
        return R.error("runtimeException");
    }
}
