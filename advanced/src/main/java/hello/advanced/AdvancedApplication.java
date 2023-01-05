package hello.advanced;

import hello.advanced.callback.logtrace.LogTrace;
import hello.advanced.callback.logtrace.ThreadLocalTrace;
import hello.advanced.config.*;
import hello.advanced.config.postprocessor.BeanPostProcessorConfig;
import hello.advanced.proxy.v1_proxy.InterfaceProxyConfig;
import hello.advanced.proxy.v2_dynamicproxy.DynamicProxyBasicConfig;
import hello.advanced.proxy.v2_dynamicproxy.DynamicProxyFilterConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import(AppV1Config.class)
//@Import({AppV1Config.class, AppV2Config.class})
//@Import(InterfaceProxyConfig.class)
//@Import(ConcreteProxyConfig.class)
//@Import(DynamicProxyBasicConfig.class)
//@Import(DynamicProxyBasicConfig.class)
//@Import(ProxyFactoryConfigV1.class)
//@Import(ProxyFactoryConfigV2.class)
@Import(BeanPostProcessorConfig.class)
@SpringBootApplication(scanBasePackages = "hello.advanced.proxy")
public class AdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedApplication.class, args);
	}

	@Bean
	public LogTrace logTrace() {
		return new ThreadLocalTrace();
	}

}
