package io.github.llnancy.huaying.web.advice;

import io.github.llnancy.mojian.web.advice.DefaultGlobalExceptionHandler;
import io.github.llnancy.mojian.web.advice.handler.ExceptionHandlerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 花楹 全局异常处理器
 *
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2022/4/7
 */
@RestControllerAdvice
public class HyExceptionHandler extends DefaultGlobalExceptionHandler {

    public HyExceptionHandler(ExceptionHandlerFactory factory) {
        super(factory);
    }
}
