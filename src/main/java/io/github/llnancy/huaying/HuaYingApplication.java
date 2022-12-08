package io.github.llnancy.huaying;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 花楹 启动器
 *
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2022/4/1
 */
@SpringBootApplication
public class HuaYingApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(HuaYingApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
