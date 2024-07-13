package code;

// Copyright (c) 2024, NoCodeNoLife-cloud. All rights reserved.
// Author: NoCodeNoLife-cloud
// stay hungry，stay foolish
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@Slf4j
// @EnableEurekaServer
@EnableDiscoveryClient
// @EnableFeignClients
// @EnableDubbo
@SpringBootApplication
public class SpringBootApplicationLauncher {
	/**
	 * Entry point of the application.
	 *
	 * @param args The command line arguments.
	 */
	@SneakyThrows
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplicationLauncher.class, args);
	}

	/**
	 * This method creates and returns an ApplicationRunner bean.
	 * The ApplicationRunner bean is used to execute code when the application starts.
	 *
	 * @return an ApplicationRunner bean
	 */
	@Bean
	public ApplicationRunner applicationRunner(@Autowired RestTemplate restTemplate) {
		return args -> {
			for (int i = 0; i < 4; i++) {
				System.out.println(restTemplate.getForEntity("http://loadbalancer-provider/say", String.class));
			}
		};
	}
}