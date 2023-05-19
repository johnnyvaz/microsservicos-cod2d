package br.com.cod2d.api.config;

import br.com.cod2d.api.config.slack.SlackServiceNotifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class SlackConfig {

	@Value("${info.build.version}")
	private String appVersion;

	@Value("${slack.webhook}")
	private String slackWebhook;

	@Value("${info.build.name}")
	private String appName;

	@Value("${spring.profiles.active}")
	private String environment;

	private SlackServiceNotifier slackServiceNotifier;

	@Bean
	public SlackServiceNotifier getSlackServiceNotifier() {

		final var footer = " v. ".concat(appVersion)
				.concat(" host ")
				.concat(ConfigInfo.config().getHostName());

		if (Objects.isNull(slackServiceNotifier))
			return new SlackServiceNotifier(slackWebhook, appName, environment, footer);

		return slackServiceNotifier;
	}

}
