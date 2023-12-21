package com.yeswanth.expensetrackerapi.repository;

import com.yeswanth.expensetrackerapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
        Boolean existsByEmail(String email);
}
