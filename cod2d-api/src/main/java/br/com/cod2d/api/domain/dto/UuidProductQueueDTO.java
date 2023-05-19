package br.com.cod2d.api.domain.dto;

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
public class UuidProductQueueDTO {

	private UUID uuid;
	private Date creationDate;
	private String gtin;
	private String profileId;
	private String gs1DigitalLink;
	private String linkReduzido;
	private String urlRedirect;

}
