package br.com.cod2d.consumer.domain.dto.gs1;

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
public class ProductGs1QueueDTO {

	private UUID uuid;
	private Date creationDate;
	private String gtin;
	private UUID uuidEmpresa;

}
