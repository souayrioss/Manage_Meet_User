package org.roronoa.manage_meet_user.repository;

import org.roronoa.manage_meet_user.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}