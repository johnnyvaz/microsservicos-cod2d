package br.com.cod2d.api;

import br.com.cod2d.api.config.ConfigInfo;
import lombok.Generated;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Generated
@EnableCaching
@SpringBootApplication
@EnableFeignClients
@ComponentScan("br.com.cod2d.api")
public class Application {
	public static void main(final String[] args) {
		MDC.put("hostname", ConfigInfo.config().getHostName());
		final Environment env = SpringApplication.run(Application.class, "")
				.getEnvironment();

		ConfigInfo.config().setAppName(env.getProperty("spring.application.name"));
		ConfigInfo.config().setPort(env.getProperty("server.port"));
		ConfigInfo.config().setBaseUrl(env.getProperty("server.servlet.contextPath"));
		ConfigInfo.config().setVersion(env.getProperty("info.build.version"));
		ConfigInfo.config().setEnv(env.getProperty("spring.profiles.active"));

		final List<String> serviceAdressList = new ArrayList<>();

		try {
			for (final NetworkInterface ni :
					Collections.list(NetworkInterface.getNetworkInterfaces())) {
				for (final InetAddress address : Collections.list(ni.getInetAddresses())) {
					if ((address instanceof Inet4Address) && !address.isLoopbackAddress()) {
						serviceAdressList.add(address.toString());
						log.info("http:/{}:{}/api/swagger-ui.html",
								address,
								ConfigInfo.config().getPort());
					}
				}
			}
		} catch (final SocketException e) {
			log.error(e.getMessage());
		}

	}
}
