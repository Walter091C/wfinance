package com.wj.wfinance.infra.persistence.repository.user;

import com.wj.wfinance.infra.persistence.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserDetails> findUserByEmail(String email);
}
