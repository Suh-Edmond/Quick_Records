package com.suh_eddy.quick_records.domain.model;

import com.suh_eddy.quick_records.domain.constant.Status;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "sessions")
public class Session extends BaseEntity{
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "year", nullable = false)
    private String year;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "session")
    private List<MemberRegistration> memberRegistrations = new ArrayList<>();

    @OneToMany(mappedBy = "session")
    private List<PaymentActivity> paymentActivities = new ArrayList<>();

    @OneToMany(mappedBy = "session")
    private List<ExpenditureActivity> expenditureActivities = new ArrayList<>();

    @OneToMany(mappedBy = "session")
    private List<Saving> savings = new ArrayList<>();

    @OneToMany(mappedBy = "session")
    private List<Contribution> contributions = new ArrayList<>();
}
