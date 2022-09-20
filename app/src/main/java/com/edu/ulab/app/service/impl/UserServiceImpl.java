package com.edu.ulab.app.service.impl;

import com.edu.ulab.app.dto.UserDto;
import com.edu.ulab.app.entity.UserEntity;
import com.edu.ulab.app.mapper.UserDtoEntityMapperImpl;
import com.edu.ulab.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.edu.ulab.app.storage.Storage.*;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private static long idUser = 0L;

    private final UserDtoEntityMapperImpl userDtoEntityMapper;

    public UserServiceImpl(UserDtoEntityMapperImpl userDtoEntityMapper) {
        this.userDtoEntityMapper = userDtoEntityMapper;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
            idUser++;        // сгенерировать идентификатор
            UserEntity userEntity; // создать пользователя
            userDto.setId(idUser); // вернуть сохраненного пользователя со всеми необходимыми полями id
            userEntity = userDtoEntityMapper.userDtoToUserEntity(userDto);
            addUserEntity(userEntity);
            return userDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        updateUserEntity(userDto);
        return userDto;
    }

    @Override
    public UserDto getUserById(Long id) {
        if (id != null && id>=0) {return null;}
        UserEntity userEntity = getUser(id);
        return userDtoEntityMapper.userEntityToUserDto(userEntity);
    }

    @Override
    public void deleteUserById(Long id) {
        if(id != null && id>=0) {
            deleteUser(id);
        }
    }
}
