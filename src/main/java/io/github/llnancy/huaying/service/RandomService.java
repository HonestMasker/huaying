package io.github.llnancy.huaying.service;

import com.google.common.collect.Lists;
import io.github.llnancy.huaying.config.Constants;
import io.github.llnancy.mojian.base.exception.MoJianBaseBizException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

/**
 * 随机资源服务层
 *
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2022/4/2
 */
@Service
@RequiredArgsConstructor
public class RandomService {

    public List<String> random(String category, Integer count) {
        return doRandom(category, count, size -> ThreadLocalRandom.current().nextInt(size));
    }

    public List<String> today(String category, Integer count) {
        return doRandom(category, count, size -> Math.toIntExact(ChronoUnit.DAYS.between(LocalDate.parse(Constants.INIT_DATE), LocalDate.now()) % size));
    }

    public List<String> doRandom(String category, Integer count, Function<Integer, Integer> function) {
        if (Constants.DOMAINS.equals(category) || ResourcesServer.isEmpty()) {
            throw new MoJianBaseBizException(Constants.RESOURCES_NOT_EXISTED);
        }
        List<String> resources = ResourcesServer.get(category);
        if (CollectionUtils.isEmpty(resources)) {
            throw new MoJianBaseBizException(Constants.RESOURCES_NOT_EXISTED);
        }
        int size = resources.size();
        List<String> result;
        if (count == 1) {
            int randomInt = function.apply(size);
            result = Lists.newArrayList(resources.get(randomInt));
        } else if (count < size) {
            Collections.shuffle(resources);
            result = resources.subList(0, count);
        } else {
            result = resources;
        }
        return result;
    }

    public void flush() {
        ResourcesServer.loadResource();
    }
}
