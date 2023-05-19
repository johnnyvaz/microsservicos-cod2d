//package br.com.cod2d.api.gateway.impl.listener;
//
//import br.com.cod2d.api.domain.exception.NotifyExceptionEventDTO;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.ApplicationListener;
//import org.springframework.stereotype.Component;
//
//import static br.com.cod2d.api.domain.enums.MessageLevelEnum.ERROR;
//
//
//@Component
//@RequiredArgsConstructor
//public class NotifyExceptionListener implements ApplicationListener<NotifyExceptionEventDTO> {
//
//    private static final String TITLE = "OCORREU UM ERRO INESPERADO";
//
//
//    @Override
//    public void onApplicationEvent(final NotifyExceptionEventDTO notifyExceptionEventDTO) {
//        notify(notifyExceptionEventDTO);
//    }
//
//    private void notify(final NotifyExceptionEventDTO notifyExceptionEventDTO) {
//        notifier.slackNotifier(TITLE, notifyExceptionEventDTO
//                .getException()
//                .getMessage(), ERROR);
//    }
//}
