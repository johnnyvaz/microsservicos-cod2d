package br.com.cod2d.api.config.slack;

import br.com.cod2d.api.domain.enums.MessageLevelEnum;
import net.gpedro.integrations.slack.SlackApi;
import net.gpedro.integrations.slack.SlackAttachment;
import net.gpedro.integrations.slack.SlackField;
import net.gpedro.integrations.slack.SlackMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SlackServiceNotifier {

    private static final Logger LOG = LoggerFactory.getLogger(SlackServiceNotifier.class);

    private String webhook;

    private String appName;

    private String profile;

    private String footer;


    public SlackServiceNotifier() {

    }

    public SlackServiceNotifier(final String webhook) {
        this.webhook = webhook;
    }

    public SlackServiceNotifier(final String webhook, final String appName) {
        this.webhook = webhook;
        this.footer = appName;
    }

    public SlackServiceNotifier(final String webhook, final String appName, final String profile) {
        this.webhook = webhook;
        this.appName = appName;
        this.profile = profile;
    }

    public SlackServiceNotifier(final String webhook, final String appName,
                                final String profile, final String footer) {
        this.webhook = webhook;
        this.appName = appName;
        this.profile = profile;
        this.footer = footer;
    }

    public void slackNotifier(
            final String title,
            final String message,
            final MessageLevelEnum level) {

        if ((this.webhook == null) || this.webhook.isEmpty() || this.webhook.isBlank()) {
            LOG.error("webhook is required");
        }

        final SlackMessage slackMessage = new SlackMessage();

        final List<SlackField> fields = new ArrayList<>();
        fields.add(new SlackField().setTitle(level.name()).setValue(message));

        final SlackAttachment attachment = new SlackAttachment().setFields(fields).setColor(level.getColor())
                .setFallback("API").setFooter(this.footer);

        slackMessage.setAttachments(Collections.singletonList(attachment))
                .setUsername("[ " + this.profile + " ] " + this.appName)
                .setText(title);

        SlackServiceNotifier.invokeSlackApi(slackMessage, this.webhook);
    }


    public void slackNotifierApi(
            final String verb,
            final String path,
            final String title,
            final String message,
            final MessageLevelEnum level) {

        if ((this.webhook == null) || this.webhook.isEmpty() || this.webhook.isBlank()) {
            LOG.error("webhook is required");
        }

        final SlackMessage slackMessage = new SlackMessage();

        final List<SlackField> fields = new ArrayList<>();
        fields.add(new SlackField().setTitle("Method").setValue(verb));
        fields.add(new SlackField().setTitle("Path").setValue(path).setShorten(true));
        fields.add(new SlackField().setTitle(level.name()).setValue(title));

        final SlackAttachment attachment = new SlackAttachment().setFields(fields).setColor(level.getColor())
                .setFallback("API").setFooter(this.footer);

        slackMessage.setAttachments(Collections.singletonList(attachment))
                .setUsername("[ " + this.profile + " ] " + this.appName)
                .setText(message);

        SlackServiceNotifier.invokeSlackApi(slackMessage, this.webhook);
    }


    private static boolean invokeSlackApi(final SlackMessage message, final String webhook) {

        boolean error = false;

        SlackApi api = null;

        try {
            api = new SlackApi(webhook);

            api.call(message);
            error = true;
        } catch (final Exception e) {
            LOG.error("Slack Integration error: " + e.getMessage());
        }

        return error;
    }

}
