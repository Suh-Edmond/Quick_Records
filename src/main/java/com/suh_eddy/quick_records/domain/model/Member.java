package com.suh_eddy.quick_records.domain.model;

import com.suh_eddy.quick_records.domain.constant.Gender;
import com.suh_eddy.quick_records.domain.constant.Status;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "members")
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "email_verified_at")
    private LocalDateTime emailVerifiedAt;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "address")
    private String address;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "picture")
    private String picture;

    @ManyToOne()
    @JoinColumn(name = "organisation_id", referencedColumnName = "id", nullable = false)
    private Organisation organisation;

    @OneToMany(mappedBy = "member")
    private List<MemberRegistration> memberRegistrations = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Saving> savings = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Contribution> contributions = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberInvitation> memberInvitations = new ArrayList<>();
}

