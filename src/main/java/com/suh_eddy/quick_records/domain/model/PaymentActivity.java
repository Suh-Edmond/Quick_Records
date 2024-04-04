package com.suh_eddy.quick_records.domain.model;

import com.suh_eddy.quick_records.domain.constant.PaymentActivityFrequency;
import com.suh_eddy.quick_records.domain.constant.PaymentActivityType;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "payment_activities")
public class PaymentActivity extends BaseEntity{
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "is_compulsory", nullable = false)
    private Boolean isCompulsory;

    @Column(name = "payment_activity_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentActivityType paymentActivityType;

    @Column(name = "frequency", nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentActivityFrequency frequency;

    @Column(name = "deadline")
    private LocalDateTime deadline;

    @Lob
    @Column(name = "payment_activity_reference")
    private String paymentActivityReference;

    @Lob
    @Column(name = "description")
    private String description;

    @ManyToOne()
    @JoinColumn(name = "session_id", referencedColumnName = "id", nullable = false)
    private Session session;

    @ManyToOne()
    @JoinColumn(name = "payment_category_id", referencedColumnName = "id", nullable = false)
    private PaymentCategory paymentCategory;

    @OneToOne(mappedBy = "paymentActivity")
    private ExpenditureActivity expenditureActivity;

    @OneToMany(mappedBy = "paymentActivity")
    private List<Income> incomes = new ArrayList<>();

    @OneToMany(mappedBy = "paymentActivity")
    private List<Contribution> contributions = new ArrayList<>();
}
