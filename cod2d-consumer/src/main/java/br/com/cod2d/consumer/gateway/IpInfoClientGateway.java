package br.com.cod2d.consumer.gateway;

import io.ipinfo.api.model.IPResponse;

public interface IpInfoClientGateway {

     IPResponse findAddress(String host);
}
