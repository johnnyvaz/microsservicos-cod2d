package br.com.cod2d.api.domain.model;

import br.com.cod2d.api.domain.enums.ShortLinkType;
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
@Table(name = "shortener", uniqueConstraints =
		{@UniqueConstraint(columnNames = {"shortLink"})})
@DynamicInsert
@DynamicUpdate
public class ShortenerTag {

	@Id
	@Column(length = 16)
	private UUID uuid;
	private Date creationDate;
	private Date updateDate;
	private ShortLinkType type;
	private String shortLink;
	private String gtin;
	private String gs1DigitalLink;
	private String redirectLink;


	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "profile_id", nullable = false,
		foreignKey = @ForeignKey(name = "profile_id_link_fk"))
	private Profile profile;

	public UUID getProfile() {
		return this.profile.getId();
	}

//	@PrePersist
//	public void prePersist() {
//		this.uuid = UUID.randomUUID();
//	}
}
