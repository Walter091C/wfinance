package com.wj.wfinance.infra.persistence.mapper;

import com.wj.wfinance.domain.entity.User;
import com.wj.wfinance.infra.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserEntitiyMapper {

    User toDomain(UserEntity userEntity);

    UserEntity toEntity(User user);
}
