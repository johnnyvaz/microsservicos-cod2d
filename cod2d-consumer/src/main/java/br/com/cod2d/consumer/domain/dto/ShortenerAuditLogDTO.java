package br.com.cod2d.consumer.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShortenerAuditLogDTO {

	private UUID uuid;
	private Date creationDate;
	private String host;
	private String userAgent;
	private String accept;
	private String acceptLanguage;
	private String acceptEncoding;
	private String connection;
	private String upgradeInsecureRequests;
	private String shortLink;

}
