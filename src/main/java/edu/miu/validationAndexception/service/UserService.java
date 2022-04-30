package edu.miu.validationAndexception.service;

import edu.miu.validationAndexception.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {

    public UserDto save(UserDto u);
    public List<UserDto> getAll();
    public UserDto getById(UUID id);
    public void update(UserDto u);
    public UserDto delete(UUID id);

}
