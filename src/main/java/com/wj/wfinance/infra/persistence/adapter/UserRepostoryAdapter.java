package com.wj.wfinance.infra.persistence.adapter;

import com.wj.wfinance.domain.entity.User;
import com.wj.wfinance.domain.repository.UserRepository;
import com.wj.wfinance.infra.persistence.mapper.UserEntitiyMapper;
import com.wj.wfinance.infra.persistence.repository.UserJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepostoryAdapter implements UserRepository {

    private final UserJpaRepository jpaRepository;
    private final UserEntitiyMapper mapper;

    public UserRepostoryAdapter(UserJpaRepository userJpaRepository, UserEntitiyMapper mapper) {
        this.jpaRepository = userJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public void save(User user) {
        jpaRepository.save(mapper.toEntity(user));
    }
}
