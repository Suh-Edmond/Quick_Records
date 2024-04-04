package com.suh_eddy.quick_records.domain.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "roles")
public class Role  extends BaseEntity{
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "term", nullable = false)
    private int term = 1;

    @Column(name = "number_of_members")
    private int numberOfMembers;

    @OneToMany(mappedBy = "role")
    private List<Permission> permissions = new ArrayList<>();
}
