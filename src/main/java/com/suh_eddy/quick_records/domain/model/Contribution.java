package com.suh_eddy.quick_records.domain.model;

import com.suh_eddy.quick_records.domain.constant.PaymentStatus;
import com.suh_eddy.quick_records.domain.constant.TransactionStatus;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "contributions")
public class Contribution extends BaseEntity{
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "amount_deposited", nullable = false)
    private Double amountDeposited;

    @Column(name = "transaction_code", nullable = false)
    private String transactionCode;

    @Column(name = "payment_status",nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @Column(name = "transaction_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;

    @Column(name = "month_name")
    private String  monthName;

    @Column(name = "quarter_name")
    private String quarterName;

    @Lob
    @Column(name = "comment")
    private String comment;

    @ManyToOne()
    @JoinColumn(name = "member_id", referencedColumnName = "id", nullable = false)
    private Member member;

    @ManyToOne()
    @JoinColumn(name = "session_id", referencedColumnName = "id", nullable = false)
    private Session session;

    @ManyToOne()
    @JoinColumn(name = "payment_activity_id", referencedColumnName = "id", nullable = false)
    private PaymentActivity paymentActivity;
}
