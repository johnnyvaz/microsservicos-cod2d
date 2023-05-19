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
@Table(name = "gs1_trade_item_measurements")
@DynamicInsert
@DynamicUpdate
public class TradeItemMeasurements {

    @Id
    private Long id;
    // netContent
    private String measurementUnitCode;
    private String value;
    private String originalValue;

}
