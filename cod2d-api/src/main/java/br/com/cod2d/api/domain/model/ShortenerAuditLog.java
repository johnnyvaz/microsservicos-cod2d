package br.com.cod2d.redirect.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shortener_audit_log")
@DynamicInsert
@DynamicUpdate
public class ShortenerAuditLog {

	@Id
	@Column(length = 16)
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
	private String ip;
	private String hostname;
	private String city;
	private String region;
	private String country;
	private String loc;
	private String org;
	private String postal;
	private String timezone;


	@PrePersist
	public void prePersist() {
		this.uuid = UUID.randomUUID();
	}
}
