package br.com.cod2d.redirect.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "organizations")
@DynamicInsert
@DynamicUpdate
public class Organization {

    @Id
    @Column(length = 16)
    private UUID uuid;
    private Date creationDate;
    private Date updateDate;
    private String name;
    @Column(unique = true)
    private String shortName;
    @Column(unique = true)
    private String cnpj;
    @Column(unique = true)
    private String fantasia;
    private String linkSite;
    private String linkSac;
    private String linkLogotipo;

    @OneToOne
    @ToString.Exclude
    @JoinColumn(name = "limites_id", nullable = false,
    foreignKey = @ForeignKey(name = "limites_id_organization_fk"))
    private QuantidadeLimites limites;


    @PrePersist
    public void prePersist() {
        this.uuid = UUID.randomUUID();
    }

    public Long getLimite() {
        return this.limites.getQtdeProdutos();
    }

}
