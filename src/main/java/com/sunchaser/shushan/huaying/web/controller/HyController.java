package com.sunchaser.shushan.huaying.web.controller;

import com.google.common.collect.Maps;
import com.sunchaser.mojian.base.entity.response.IResponse;
import com.sunchaser.mojian.base.entity.response.SingleResponse;
import com.sunchaser.mojian.base.util.JsonUtils;
import com.sunchaser.mojian.base.util.Optionals;
import com.sunchaser.shushan.huaying.service.RandomService;
import com.sunchaser.shushan.huaying.service.ResourcesServer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static com.sunchaser.shushan.huaying.config.Constants.*;

/**
 * 随机资源API控制层
 *
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2022/4/5
 */
@Controller
@RequestMapping("${huaying.api-base-path}")
public class HyController {

    @Autowired
    private RandomService randomService;
    @Autowired
    private ResourcesServer resourcesServer;

    /**
     * 手动刷新资源
     */
    @GetMapping("/flush")
    @ResponseBody
    public IResponse flush() {
        resourcesServer.loadResource();
        return IResponse.ofSuccess();
    }

    /**
     * 随机资源
     *
     * @param request  request
     * @param response response
     * @param category 资源分类
     * @param type     响应数据类型
     * @throws Exception will be handled by com.sunchaser.shushan.huaying.web.advice.HyExceptionHandler
     * @see com.sunchaser.shushan.huaying.web.advice.HyExceptionHandler
     * @see com.sunchaser.mojian.web.advice.MjGlobalExceptionHandler
     */
    @GetMapping("/random/{category}")
    public void random(HttpServletRequest request,
                       HttpServletResponse response,
                       @PathVariable String category,
                       @RequestParam(required = false, defaultValue = JSON_VALUE) String type) throws Exception {
        ResponseTypeEnum.match(type).doDispatcher(request, response, randomService.random(category));
    }

    /**
     * 今日资源
     *
     * @param request  request
     * @param response response
     * @param category 资源分类
     * @param type     响应数据类型
     * @throws Exception will be handled by com.sunchaser.shushan.huaying.web.advice.HyExceptionHandler
     * @see com.sunchaser.shushan.huaying.web.advice.HyExceptionHandler
     * @see com.sunchaser.mojian.web.advice.MjGlobalExceptionHandler
     */
    @GetMapping("/today/{category}")
    public void today(HttpServletRequest request,
                      HttpServletResponse response,
                      @PathVariable String category,
                      @RequestParam(required = false, defaultValue = JSON_VALUE) String type) throws Exception {
        ResponseTypeEnum.match(type).doDispatcher(request, response, randomService.today(category));
    }

    /**
     * response响应格式类型枚举
     */
    @AllArgsConstructor
    enum ResponseTypeEnum {

        /**
         * 仅返回资源URL
         */
        URL(URL_VALUE) {
            @Override
            public void doDispatcher(HttpServletRequest request, HttpServletResponse response, String randomSource) throws Exception {
                response.setContentType(MediaType.TEXT_HTML_VALUE);
                response.getWriter().print(randomSource);
            }
        },

        /**
         * json格式
         */
        JSON(JSON_VALUE) {
            @Override
            public void doDispatcher(HttpServletRequest request, HttpServletResponse response, String randomSource) throws Exception {
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                response.setCharacterEncoding(StandardCharsets.UTF_8.name());
                response.getWriter().print(JsonUtils.toJsonString(SingleResponse.success(randomSource)));
            }
        },

        /**
         * 重定向到资源源地址
         */
        REDIRECT(REDIRECT_VALUE) {
            @Override
            public void doDispatcher(HttpServletRequest request, HttpServletResponse response, String randomSource) throws Exception {
                response.sendRedirect(randomSource);
            }
        };
        private final String type;
        private static final Map<String, ResponseTypeEnum> enumMap = Maps.newHashMap();

        static {
            for (ResponseTypeEnum typeEnum : ResponseTypeEnum.values()) {
                enumMap.put(typeEnum.type, typeEnum);
            }
        }

        public static ResponseTypeEnum match(String type) {
            return Optionals.of(enumMap.get(type), JSON);
        }

        public abstract void doDispatcher(HttpServletRequest request, HttpServletResponse response, String randomSource) throws Exception;
    }
}
