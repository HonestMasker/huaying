package com.sunchaser.shushan.huaying.service;

import cn.hutool.core.io.FileUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.sunchaser.mojian.base.exception.MjException;
import com.sunchaser.shushan.huaying.config.Constants;
import com.sunchaser.shushan.huaying.config.property.HyProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.sunchaser.shushan.huaying.config.Constants.NETWORK_ERROR;

/**
 * 资源服务端
 *
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2022/4/1
 */
@Component
@Slf4j
public class ResourcesServer implements InitializingBean {
    private static final Map<String, List<String>> RESOURCES_MAP = Maps.newHashMap();

    @Autowired
    private HyProperties hyProperties;

    @Override
    public void afterPropertiesSet() throws Exception {
        loadResource();
    }

    public void loadResource() {
        try {
            RESOURCES_MAP.clear();
            File resourcesDir = ResourceUtils.getFile(hyProperties.getResourcesPath());
            List<File> loopFiles = FileUtil.loopFiles(resourcesDir);
            if (CollectionUtils.isEmpty(loopFiles)) {
                return;
            }
            loopFiles.stream()
                    .filter(file -> file.getName().endsWith(Constants.TXT))
                    .forEach(file -> RESOURCES_MAP.put(FileUtil.mainName(file), Lists.newArrayList(FileUtil.readUtf8Lines(file, Sets.newHashSet()))));
        } catch (IOException e) {
            log.error("LoadResourcesService#static loadResource error", e);
            throw new MjException(NETWORK_ERROR);
        }
    }

    public static boolean isEmpty() {
        return RESOURCES_MAP.isEmpty();
    }

    public static List<String> get(String key) {
        return RESOURCES_MAP.get(key);
    }

}
