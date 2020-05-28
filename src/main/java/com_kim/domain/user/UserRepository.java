package com_kim.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Role> {
    Optional<User> findByEmail(String email); //emailで同録されているかを判断
}
