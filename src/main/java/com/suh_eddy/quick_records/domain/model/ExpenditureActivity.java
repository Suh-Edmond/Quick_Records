package com.suh_eddy.quick_records.domain.model;

import com.suh_eddy.quick_records.domain.constant.PaymentStatus;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "expenditure_activities")
public class ExpenditureActivity extends BaseEntity{
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "estimated_amount", nullable = false)
    private Double estimatedAmount;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "payment_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @Lob
    @Column(name = "description")
    private String description;

    @ManyToOne()
    @JoinColumn(name = "expenditure_category_id", referencedColumnName = "id", nullable = false)
    private ExpenditureCategory expenditureCategory;

    @ManyToOne()
    @JoinColumn(name = "session_id", referencedColumnName = "id", nullable = false)
    private Session session;

    @OneToOne()
    @JoinColumn(name = "payment_activity_id", referencedColumnName = "id", nullable = false)
    private PaymentActivity paymentActivity;

    @OneToMany(mappedBy = "expenditureActivity")
    private List<ExpenditureDetail> expenditureDetails = new ArrayList<>();

}
