package br.com.cod2d.consumer.domain.dto.product;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class ProductFirebase {

	private UUID uuid;
	private Date creationDate;
	private Date updateDate;
	private String sku;
	private String description;
	private String gtinEan;
	private Boolean enabled;
	private Long internalCode;
	private String unidade;
	private String ncm;
	private Long pesoLiq;
	private Long pesoBruto;
	private String observacao;
	private String fullDescription;
	private Long length; //comprimento
	private Long width; //largura
	private Long height; //altura
	private String brand; //marca
	private String produtoURLVideo;
	private String tagTitle;
	private String metaTagDescription;
	private String metaTagKeywords;
}
