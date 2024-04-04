package com.suh_eddy.quick_records.domain.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "expenditure_categories")
public class ExpenditureCategory {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", unique = true)
    private String code;

    @Lob
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "expenditureCategory")
    private List<ExpenditureActivity> expenditureActivities = new ArrayList<>();
}
