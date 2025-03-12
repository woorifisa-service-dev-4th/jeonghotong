package com.saengsaeng.jeonghotong.common.config;


import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.StandardEnvironment;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class EnvironmentConfig {

	@Bean
	public StandardEnvironment configureEnvironment(StandardEnvironment environment) {
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
		MutablePropertySources propertySources = environment.getPropertySources();
		Map<String, Object> dotenvProperties = new HashMap<>();

		dotenv.entries().forEach(entry -> dotenvProperties.put(entry.getKey(), entry.getValue()));

		propertySources.addFirst(new MapPropertySource("dotenvProperties", dotenvProperties));
		return environment;
	}
}
