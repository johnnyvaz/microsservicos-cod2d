package br.com.cod2d.consumer.domain.model.gtinbase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gs1_trade_item_weight")
@DynamicInsert
@DynamicUpdate
public class TradeItemWeight {

    @Id
    private Long id;
    // grossWeight
    private String value;
    private String measurementUnitCode;
    private String originalValue;

    @OneToOne
    @JoinColumn(name = "trade_item_weight_id")
    private ProductGS1 productGS1;

}
