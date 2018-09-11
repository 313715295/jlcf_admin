package com.admin.commons.exceptions;

import com.admin.commons.base.Result;
import com.admin.commons.enums.ResponseEnum;
import com.admin.commons.utils.IpTools;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * 全局异常处理,现在采用的是system模块下的GlobalExceptionHandle
 */
//@RestControllerAdvice
@Slf4j
public class GlobalExceptionAndCheckHealthHandler {


//    @ExceptionHandler(Exception.class)
    public Result recordGlobal(HttpServletRequest request, Exception e) {
        log.error("IP={} 方法={} 全局异常", IpTools.gainRealIp(request), request.getRequestURI(), e);
        return Result.serverError();
    }

//    @ExceptionHandler(SQLException.class)
    public Result dbHandler(HttpServletRequest request, SQLException e) {
        log.error("IP={} 执行方法={} sql 异常", IpTools.gainRealIp(request), request.getRequestURI(), e);
        return Result.serverError();
    }

    /**
     * 权限异常
     */
//    @ExceptionHandler(UnauthorizedException.class)
    public Result resolveException(HttpServletRequest request) {
        log.warn("IP={} 执行方法={} 没有权限", IpTools.gainRealIp(request), request.getRequestURI());
        return Result.fail(ResponseEnum.PERMISSION_ERROR,false);
    }

}
