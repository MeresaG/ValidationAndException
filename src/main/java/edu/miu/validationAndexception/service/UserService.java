package edu.miu.validationAndexception.service;

import edu.miu.validationAndexception.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {

    public void save(UserDto u);
    public List<UserDto> getAll();
    public UserDto getById(UUID id);
    public void update(UserDto u);
    public void delete(UUID id);

}
