package br.com.cod2d.redirect.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products", uniqueConstraints = {
	@UniqueConstraint(name = "Unique_ean_organization",
	columnNames = { "uuid", "gtinEan", "sku"})
})
@DynamicInsert
@DynamicUpdate
public class Product {

	@Id
	@Column(length = 16)
	private UUID uuid;
	private Date creationDate;
	private Date updateDate;
	private String sku;
	private String description;
	private String gtinEan;
	@Column(name = "processed", length = 1)
	private String processed;
	private Date processedDate;
	private String processedError;
	private Boolean enabled;

	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "organization_id", nullable = false,
			foreignKey = @ForeignKey(name = "organization_id_product_fk"))
	private Organization organization;

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

//	@PrePersist
//	public void prePersist() {
//		this.uuid = UUID.randomUUID();
//	}

}
