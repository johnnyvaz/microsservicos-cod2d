package br.com.cod2d.consumer.domain.model.gtinbase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NetWeight")
@DynamicInsert
@DynamicUpdate
public class NetWeight {
    @Id
    private Long id;
    private String value;
    private String measurementUnitCode;
}
