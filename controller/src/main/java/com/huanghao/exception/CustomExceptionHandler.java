package com.huanghao.exception;

import com.huanghao.Result;
import com.huanghao.enums.ErrorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @author HuangHao
 * @date 2021/8/10 0:11
 */
@RestControllerAdvice
public class CustomExceptionHandler {

    private static Logger LOGGER = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result validationBodyException(MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            errors.forEach(p -> {
                FieldError fieldError = (FieldError) p;
                LOGGER.warn("Data check failure : object={}, field={}, errorMessage={}", fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage());
            });
            return Result.error(ErrorEnum.PARAM_ERROR,
                    result.getFieldError() == null ? "请求参数有误" : result.getFieldError().getDefaultMessage());
        }
        //其他错误
        return Result.error(ErrorEnum.COMMON_ERROR);
    }


    @ExceptionHandler(HttpMessageConversionException.class)
    public Result parameterTypeException(HttpMessageConversionException exception) {
        LOGGER.warn("parameterTypeException {}", exception.getCause().getLocalizedMessage());
        return Result.error(ErrorEnum.PARAM_ERROR, "请求参数类型有误");
    }

    @ExceptionHandler(DotaException.class)
    public Result commonException(DotaException exception) {
        LOGGER.error("commonException {}", exception);
        return Result.error(exception.getErrorEnum(), exception.getMessage());
    }
}
