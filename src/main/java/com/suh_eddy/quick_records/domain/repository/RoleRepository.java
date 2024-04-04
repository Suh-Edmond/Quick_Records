package com.suh_eddy.quick_records.domain.repository;

import com.suh_eddy.quick_records.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
}
