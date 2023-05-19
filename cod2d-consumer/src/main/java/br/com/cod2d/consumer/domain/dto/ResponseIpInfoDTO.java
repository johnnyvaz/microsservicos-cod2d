package br.com.cod2d.consumer.domain.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseIpInfoDTO {
    public String ip;
    public String hostname;
    public String city;
    public String region;
    public String country;
    public String loc;
    public String org;
    public String postal;
    public String timezone;
}
