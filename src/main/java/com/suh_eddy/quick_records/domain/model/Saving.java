package com.suh_eddy.quick_records.domain.model;

import com.suh_eddy.quick_records.domain.constant.PaymentStatus;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "savings")
public class Saving extends BaseEntity{
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "amount_deposited", nullable = false)
    private Double amountDeposited;

    @Column(name = "amount_used", nullable = false)
    private Double amountUsed;

    @Column(name = "payment_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @Column(name = "transaction_code", unique = true, nullable = false)
    private String transactionCode;

    @ManyToOne()
    @JoinColumn(name = "member_id", referencedColumnName = "id", nullable = false)
    private Member member;

    @ManyToOne()
    @JoinColumn(name = "session_id", referencedColumnName = "id", nullable = false)
    private Session session;
}
