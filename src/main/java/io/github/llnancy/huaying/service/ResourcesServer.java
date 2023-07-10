package io.github.llnancy.huaying.service;

import cn.hutool.core.io.FileUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import io.github.llnancy.huaying.config.Constants;
import io.github.llnancy.huaying.config.property.HyProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * 资源服务端
 *
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2022/4/1
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class ResourcesServer implements InitializingBean {

    private static final Map<String, List<String>> RESOURCES_MAP = Maps.newHashMap();

    private static File resourcesDir;

    private final HyProperties hyProperties;

    @Override
    public void afterPropertiesSet() throws Exception {
        resourcesDir = ResourceUtils.getFile(hyProperties.getResourcesPath());
        loadResource();
    }

    public static void loadResource() {
        RESOURCES_MAP.clear();
        List<File> loopFiles = FileUtil.loopFiles(resourcesDir);
        if (CollectionUtils.isEmpty(loopFiles)) {
            return;
        }
        loopFiles.stream()
                .filter(file -> file.getName().endsWith(Constants.TXT))
                .forEach(file -> RESOURCES_MAP.put(FileUtil.mainName(file), Lists.newArrayList(FileUtil.readUtf8Lines(file, Sets.newHashSet()))));
    }

    public static boolean isEmpty() {
        return RESOURCES_MAP.isEmpty();
    }

    public static List<String> get(String key) {
        return RESOURCES_MAP.get(key);
    }
}
