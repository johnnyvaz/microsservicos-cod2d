package br.com.cod2d.consumer.domain.model;

import br.com.cod2d.consumer.domain.enums.ShortLinkType;
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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shortener")
@DynamicInsert
@DynamicUpdate
public class Shortener {

	@Id
	@Column(length = 16)
	private UUID uuid;
	private Date creationDate;
	private Date updateDate;
	private ShortLinkType type;
	private String shortLink;
	private String redirectLink;

	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "profile_id", nullable = false,
			foreignKey = @ForeignKey(name = "profile_id_link_fk"))
	private Profile profile;

	public UUID getProfile() {
		return this.profile.getId();
	}


	@PrePersist
	public void prePersist() {
		this.uuid = UUID.randomUUID();
	}
}
