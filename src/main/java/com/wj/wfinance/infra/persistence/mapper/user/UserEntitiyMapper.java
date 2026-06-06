package com.wj.wfinance.infra.persistence.mapper.user;

import com.wj.wfinance.domain.entity.User;
import com.wj.wfinance.infra.persistence.entity.user.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntitiyMapper {

    User toDomain(UserEntity userEntity);

    UserEntity toEntity(User user);
}
