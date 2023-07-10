package io.github.llnancy.huaying.service;

import io.github.llnancy.huaying.config.Constants;
import io.github.llnancy.mojian.base.exception.MjBaseBizException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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

    public String random(String category) {
        return doRandom(category, size -> ThreadLocalRandom.current().nextInt(size));
    }

    public String today(String category) {
        return doRandom(category, size -> Math.toIntExact(ChronoUnit.DAYS.between(LocalDate.parse(Constants.INIT_DATE), LocalDate.now()) % size));
    }

    public String doRandom(String category, Function<Integer, Integer> function) {
        if (Constants.DOMAINS.equals(category) || ResourcesServer.isEmpty()) {
            throw new MjBaseBizException(Constants.RESOURCES_NOT_EXISTED);
        }
        List<String> resources = ResourcesServer.get(category);
        if (CollectionUtils.isEmpty(resources)) {
            throw new MjBaseBizException(Constants.RESOURCES_NOT_EXISTED);
        }
        int randomInt = function.apply(resources.size());
        return resources.get(randomInt);
    }

    public void flush() {
        ResourcesServer.loadResource();
    }
}
