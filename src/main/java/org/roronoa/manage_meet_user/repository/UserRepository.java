package org.roronoa.manage_meet_user.repository;

import org.roronoa.manage_meet_user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String username);


}