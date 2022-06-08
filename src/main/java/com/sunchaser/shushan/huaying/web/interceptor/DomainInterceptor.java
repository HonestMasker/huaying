package com.sunchaser.shushan.huaying.web.interceptor;

import com.sunchaser.mojian.base.exception.MjException;
import com.sunchaser.shushan.huaying.config.property.HyProperties;
import com.sunchaser.shushan.huaying.service.ResourcesServer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.sunchaser.shushan.huaying.config.Constants.DOMAINS;
import static com.sunchaser.shushan.huaying.config.Constants.NO_AUTH;
import static org.springframework.http.HttpHeaders.REFERER;

/**
 * 域名拦截器
 *
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2022/4/2
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class DomainInterceptor implements HandlerInterceptor {

    private final HyProperties hyProperties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String referer = request.getHeader(REFERER);
        LOGGER.info("[DomainInterceptor#preHandle] referer={}", referer);
        if (StringUtils.isBlank(referer)) {
            if (!hyProperties.getNoReferer()) {// 防盗链
                throw new MjException(NO_AUTH);
            }
            return true;
        }
        List<String> domainList = ResourcesServer.get(DOMAINS);
        if (CollectionUtils.isEmpty(domainList)) {
            return true;
        }
        for (String domain : domainList) {
            if (referer.contains(domain)) {
                return true;
            }
        }
        throw new MjException(NO_AUTH);
    }
}
