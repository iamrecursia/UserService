package com.kozitskiy.userservice.repository;

import com.kozitskiy.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT u FROM User u WHERE u.email = :email", nativeQuery = true)
    Optional<User> findByEmailNative(@Param("email") String email);
}
