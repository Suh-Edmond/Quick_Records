package com.suh_eddy.quick_records.domain.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "members_registration")
public class MemberRegistration extends BaseEntity{
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "month_name")
    private String monthName;

    @Column(name = "quarter_name")
    private String quarterName;

    @ManyToOne()
    @JoinColumn(name = "member_id", referencedColumnName = "id", nullable = false)
    private Member member;

    @ManyToOne()
    @JoinColumn(name = "session_id", referencedColumnName = "id", nullable = false)
    private Session session;

    @ManyToOne()
    @JoinColumn(name = "registration_fee_id", referencedColumnName = "id", nullable = false)
    private RegistrationFee registrationFee;
}
