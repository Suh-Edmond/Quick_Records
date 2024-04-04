package com.suh_eddy.quick_records.domain.model;

import com.suh_eddy.quick_records.domain.constant.RegistrationFrequency;
import com.suh_eddy.quick_records.domain.constant.Status;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "registration_fees")
public class RegistrationFee extends BaseEntity{
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "registration_frequency", nullable = false)
    @Enumerated(EnumType.STRING)
    private RegistrationFrequency registrationFrequency;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "registrationFee")
    private List<MemberRegistration> memberRegistrations = new ArrayList<>();
}
