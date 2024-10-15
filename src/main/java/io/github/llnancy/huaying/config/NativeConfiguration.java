package io.github.llnancy.huaying.config;

import lombok.SneakyThrows;
import org.springframework.aot.hint.ExecutableMode;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;

/**
 * aot native configuration
 *
 * @author llnancy admin@lilu.org.cn
 * @since JDK17 2023/7/10
 */
@Configuration(proxyBeanMethods = false)
@ImportRuntimeHints(NativeConfiguration.HyRuntimeHintsRegistrar.class)
public class NativeConfiguration {

    static class HyRuntimeHintsRegistrar implements RuntimeHintsRegistrar {

        @SneakyThrows
        @Override
        public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
            hints.reflection()
                    .registerConstructor(org.hibernate.validator.internal.util.logging.Log_$logger.class.getConstructor(org.jboss.logging.Logger.class), ExecutableMode.INVOKE)
                    .registerField(org.hibernate.validator.internal.util.logging.Messages_$bundle.class.getField("INSTANCE"));
        }
    }
}
