package com.edu.ulab.app.mapper;

import com.edu.ulab.app.dto.UserDto;
import com.edu.ulab.app.entity.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-19T20:09:16+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.4.1 (Amazon.com Inc.)"
)
@Component
public class UserDtoEntityMapperImpl implements UserDtoEntityMapper {

    @Override
    public UserDto userEntityToUserDto(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( userEntity.getId() );
        userDto.setFullName( userEntity.getFullName() );
        userDto.setTitle( userEntity.getTitle() );
        userDto.setAge( userEntity.getAge() );

        return userDto;
    }

    @Override
    public UserEntity userDtoToUserEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userDto.getId() );
        userEntity.setFullName( userDto.getFullName() );
        userEntity.setTitle( userDto.getTitle() );
        userEntity.setAge( userDto.getAge() );

        return userEntity;
    }
}
