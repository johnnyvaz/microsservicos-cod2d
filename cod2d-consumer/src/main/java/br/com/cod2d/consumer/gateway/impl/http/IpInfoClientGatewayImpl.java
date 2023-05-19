package br.com.cod2d.consumer.gateway.impl.http;

import br.com.cod2d.consumer.gateway.IpInfoClientGateway;
import io.ipinfo.api.IPinfo;
import io.ipinfo.api.errors.RateLimitedException;
import io.ipinfo.api.model.IPResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class IpInfoClientGatewayImpl implements IpInfoClientGateway {

  @Value("${app.ipinfo.token}")
  private String token;

  public IPResponse findAddress(final String host) {

    final IPinfo ipInfo = new IPinfo.Builder()
            .setToken(token)
            .build();
    try {

      final var response = ipInfo.lookupIP("186.249.33.154"); // host);
      log.info("[IpInfoClientGatewayImpl] - Response IpInfo: {}", response);
      return response;

    } catch (final RateLimitedException e) {
      log.error("Error calling IpInfo to Host: {}", host);
      throw new RuntimeException(e);
    } //todo: colocar outro catch aqui
  }

}
