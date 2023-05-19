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
@Table(name = "gs1_referenced_file_informations")
@DynamicInsert
@DynamicUpdate
public class ReferencedFileInformations {

    @Id
    private Long id;
    private String uniformResourceIdentifier;
    private String contentDescription;
    private String fileName;
    private String referencedFileTypeCode;
    private String featuredFile;

    @OneToOne
    @JoinColumn(name = "reference_file_id")
    private ProductGS1 productGS1;
}
