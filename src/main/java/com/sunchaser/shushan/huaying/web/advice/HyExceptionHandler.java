package com.sunchaser.shushan.huaying.web.advice;

import com.sunchaser.mojian.base.entity.response.SingleResponse;
import com.sunchaser.mojian.web.advice.MjGlobalExceptionHandler;
import com.sunchaser.shushan.huaying.config.property.HyProperties;
import com.sunchaser.shushan.huaying.config.property.HyProperties.WebSiteInfo;
import org.springframework.beans.factory.annotation.Autowired;
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
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HyExceptionHandler extends MjGlobalExceptionHandler {

    @Autowired
    private HyProperties hyProperties;

    @Override
    public SingleResponse<WebSiteInfo> handle4xxClientError(Exception ex) {
        return SingleResponse.success(super.handle4xxClientError(ex), hyProperties.getWebSiteInfo());
    }

    @Override
    public SingleResponse<WebSiteInfo> handle5xxServerError(Exception ex) {
        return SingleResponse.success(super.handle5xxServerError(ex), hyProperties.getWebSiteInfo());
    }
}
