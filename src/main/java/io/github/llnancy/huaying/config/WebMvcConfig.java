package io.github.llnancy.huaying.config;

import io.github.llnancy.huaying.config.property.HyProperties;
import io.github.llnancy.huaying.web.interceptor.DomainInterceptor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web Mvc配置
 *
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2022/4/2
 */
@Configuration
@Slf4j
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final DomainInterceptor domainInterceptor;

    private final HyProperties hyProperties;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String baseApiPath = hyProperties.getApiBasePath();
        String randomPathPattern = baseApiPath + "/random/**";
        String todayPathPattern = baseApiPath + "/today/**";
        String flushPath = baseApiPath + "/flush";
        LOGGER.info("[WebMvcConfig#addInterceptors] add PathPatterns: {}, {}, {}", randomPathPattern, todayPathPattern, flushPath);
        registry.addInterceptor(domainInterceptor)
                .addPathPatterns(
                        randomPathPattern,
                        todayPathPattern,
                        flushPath
                );
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("*")
                .allowedHeaders("shushan", "huaying")
                .allowCredentials(Boolean.TRUE)
                .exposedHeaders(HttpHeaders.SET_COOKIE) // 允许带上cookie
                .maxAge(3600L); // maxAge(3600)表明在3600秒内，不需要再发送预检验请求，可以缓存该结果
    }
}
