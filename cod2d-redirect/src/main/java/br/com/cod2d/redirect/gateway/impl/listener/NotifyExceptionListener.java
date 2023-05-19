package br.com.cod2d.redirect.gateway.impl.listener;

import br.com.cod2d.redirect.config.slack.SlackServiceNotifier;
import br.com.cod2d.redirect.domain.exception.NotifyExceptionEventDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import static br.com.cod2d.redirect.config.slack.MessageLevelEnum.ERROR;


@Component
@RequiredArgsConstructor
public class NotifyExceptionListener implements ApplicationListener<NotifyExceptionEventDTO> {

    private static final String TITLE = "OCORREU UM ERRO INESPERADO";

    private final SlackServiceNotifier notifier;

    @Override
    public void onApplicationEvent(final NotifyExceptionEventDTO notifyExceptionEventDTO) {
        notify(notifyExceptionEventDTO);
    }

    private void notify(final NotifyExceptionEventDTO notifyExceptionEventDTO) {
        notifier.slackNotifier(TITLE, notifyExceptionEventDTO
                .getException()
                .getMessage(), ERROR);
    }
}
