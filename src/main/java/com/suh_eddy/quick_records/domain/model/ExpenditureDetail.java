package com.suh_eddy.quick_records.domain.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "expenditure_details")
public class ExpenditureDetail extends BaseEntity{
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "amount_spent", nullable = false)
    private Double amountSpent;

    @Lob
    @Column(name = "comment")
    private String comment;

    @ManyToOne()
    @JoinColumn(name = "expenditure_activity_id", referencedColumnName = "id", nullable = false)
    private ExpenditureActivity expenditureActivity;

}
