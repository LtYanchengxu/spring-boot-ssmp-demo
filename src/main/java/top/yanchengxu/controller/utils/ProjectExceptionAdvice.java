package top.yanchengxu.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler
    public Result doException(Exception ex) {
        ex.printStackTrace();
        return new Result(false, null, "系统错误，请稍后重试");
    }
}
