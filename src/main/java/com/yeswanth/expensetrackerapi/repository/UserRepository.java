package com.yeswanth.expensetrackerapi.repository;

import com.yeswanth.expensetrackerapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
        Boolean existsByEmail(String email);

        Optional<User> findByEmail(String email);
}
