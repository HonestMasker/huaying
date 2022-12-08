package io.github.llnancy.huaying.web.advice;

import io.github.llnancy.huaying.config.property.HyProperties;
import io.github.llnancy.huaying.config.property.HyProperties.WebSiteInfo;
import com.sunchaser.shushan.mojian.base.entity.response.SingleResponse;
import com.sunchaser.shushan.mojian.web.advice.MjGlobalExceptionHandler;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class HyExceptionHandler extends MjGlobalExceptionHandler {

    private final HyProperties hyProperties;

    @Override
    public SingleResponse<WebSiteInfo> handle4xxClientError(Exception ex) {
        return SingleResponse.success(super.handle4xxClientError(ex), hyProperties.getWebSiteInfo());
    }

    @Override
    public SingleResponse<WebSiteInfo> handle5xxServerError(Exception ex) {
        return SingleResponse.success(super.handle5xxServerError(ex), hyProperties.getWebSiteInfo());
    }
}
