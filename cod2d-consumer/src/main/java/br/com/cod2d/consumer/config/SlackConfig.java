package br.com.cod2d.consumer.config;

import br.com.cod2d.consumer.config.slack.SlackServiceNotifierConfig;
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

    private SlackServiceNotifierConfig slackServiceNotifierConfig;

    @Bean
    public SlackServiceNotifierConfig getSlackServiceNotifier() {

        final var footer = " v. ".concat(appVersion)
                .concat(" host ")
                .concat(InfoConfig.config().getHostName());

        if (Objects.isNull(slackServiceNotifierConfig))
            return new SlackServiceNotifierConfig(slackWebhook, appName, environment, footer);

        return slackServiceNotifierConfig;
    }


}
