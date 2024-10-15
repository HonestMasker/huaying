package io.github.llnancy.huaying.web.controller;

import io.github.llnancy.huaying.service.RandomService;
import io.github.llnancy.huaying.web.advice.HyExceptionHandler;
import io.github.llnancy.mojian.base.entity.response.IResponse;
import io.github.llnancy.mojian.base.entity.response.SingleResponse;
import io.github.llnancy.mojian.base.util.JsonUtils;
import io.github.llnancy.mojian.web.advice.DefaultGlobalExceptionHandler;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static io.github.llnancy.huaying.config.Constants.JSON_VALUE;

/**
 * 随机资源 API 控制层
 *
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2022/4/5
 */
@Controller
@RequestMapping("${huaying.api-base-path}")
@RequiredArgsConstructor
public class HyController {

    private final RandomService randomService;

    /**
     * 手动刷新资源
     */
    @GetMapping("/flush")
    @ResponseBody
    public IResponse flush() {
        randomService.flush();
        return IResponse.ofSuccess();
    }

    /**
     * 随机资源
     *
     * @param request  request
     * @param response response
     * @param category 资源分类
     * @param rt       响应数据类型
     * @throws Exception will be handled by {@link HyExceptionHandler}
     * @see DefaultGlobalExceptionHandler
     */
    @GetMapping("/random/{category}")
    public void random(HttpServletRequest request,
                       HttpServletResponse response,
                       @PathVariable String category,
                       @RequestParam(required = false, defaultValue = "1") Integer count,
                       @RequestParam(value = "type", required = false, defaultValue = JSON_VALUE) ResponseType rt) throws Exception {
        rt.doDispatcher(request, response, randomService.random(category, count));
    }

    /**
     * 今日资源
     *
     * @param request  request
     * @param response response
     * @param category 资源分类
     * @param rt       响应数据类型
     * @throws Exception will be handled by {@link HyExceptionHandler}
     * @see DefaultGlobalExceptionHandler
     */
    @GetMapping("/today/{category}")
    public void today(HttpServletRequest request,
                      HttpServletResponse response,
                      @PathVariable String category,
                      @RequestParam(required = false, defaultValue = "1") Integer count,
                      @RequestParam(value = "type", required = false, defaultValue = JSON_VALUE) ResponseType rt) throws Exception {
        rt.doDispatcher(request, response, randomService.today(category, count));
    }

    /**
     * response 响应格式类型枚举
     */
    @AllArgsConstructor
    public enum ResponseType {

        /**
         * 仅返回资源 URL
         */
        URL {
            @Override
            public void doDispatcher(HttpServletRequest request, HttpServletResponse response, List<String> randomSources) throws Exception {
                response.setContentType(MediaType.TEXT_HTML_VALUE);
                response.getWriter().print(randomSources.size() == 1 ? randomSources.get(0) : randomSources);
            }
        },

        /**
         * json 格式
         */
        JSON {
            @Override
            public void doDispatcher(HttpServletRequest request, HttpServletResponse response, List<String> randomSources) throws Exception {
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                response.setCharacterEncoding(StandardCharsets.UTF_8.name());
                response.getWriter().print(JsonUtils.toJsonString(SingleResponse.success(randomSources.size() == 1 ? randomSources.get(0) : randomSources)));
            }
        },

        /**
         * 重定向到资源源地址
         */
        REDIRECT {
            @Override
            public void doDispatcher(HttpServletRequest request, HttpServletResponse response, List<String> randomSources) throws Exception {
                response.sendRedirect(randomSources.get(0));
            }
        };

        public abstract void doDispatcher(HttpServletRequest request, HttpServletResponse response, List<String> randomSources) throws Exception;
    }
}
