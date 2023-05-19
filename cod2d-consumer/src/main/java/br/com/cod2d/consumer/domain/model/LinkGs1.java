package br.com.cod2d.consumer.domain.model;

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
import java.util.Date;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "linkGs1")
@DynamicInsert
@DynamicUpdate
public class LinkGs1 {

	@Id
	@Column(length = 16)
	private UUID uuid;
	private Date creationDate;
	private Date updateDate;
	private String linkName;
	private String fieldEan01;
	private String fieldSku22;
	private String urlGs1;
	private String stringRedirectFrom; // string para colocar no arquivo _redirects
	private String urlSiteProduto;
	private String urlRedirect;
	private String stringRedirectTo; // string para colocar no arquivo _redirects
	private Boolean redirect;
	private String pathOrg;
	private Boolean enabled;
	private Boolean linkDefault;
	private String svgQrCode;

	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false,
	foreignKey = @ForeignKey(name = "product_id_link_fk"))
	private Product product;

}
