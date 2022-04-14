package com.sunchaser.shushan.huaying.config.property;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 配置项
 *
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2022/4/2
 */
@Configuration
@ConfigurationProperties(prefix = "huaying")
@Getter
@Setter
public class HyProperties {

    /**
     * 是否允许header中无referer的请求进行访问
     */
    private Boolean noReferer;

    /**
     * API基础路径
     */
    private String apiBasePath = StringUtils.EMPTY;

    /**
     * 资源文件所在路径
     */
    private String resourcesPath;

    /**
     * 网站信息
     */
    private WebSiteInfo webSiteInfo = new WebSiteInfo();

    @Data
    public static class WebSiteInfo {
        private String appId;

        private String name;

        private String desc;

        private String url;
    }

}
