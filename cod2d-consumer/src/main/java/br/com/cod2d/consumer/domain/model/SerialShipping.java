package br.com.cod2d.consumer.domain.model;

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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "serial_shipping")
@DynamicInsert
@DynamicUpdate
public class SerialShipping {

    @Id
    @Column(length = 16)
    private UUID uuid;
    private Date creationDate;
    private Date updateDate;
    @Column(unique = true)
    private String danfe;
    private String invoice;
    private String invoiceDate;
    private String carrier;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false,
            foreignKey = @ForeignKey(name = "shipping_id_org_fk"))
    private Organization organization;

    @PrePersist
    public void prePersist() {
        this.uuid = UUID.randomUUID();
    }



}
