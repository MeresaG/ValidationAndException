package edu.miu.validationAndexception.service.ServiceImpl;

import edu.miu.validationAndexception.dto.UserDto;
import edu.miu.validationAndexception.entity.User;
import edu.miu.validationAndexception.repository.UserRepo;
import edu.miu.validationAndexception.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(UserDto u) {
        User user = modelMapper.map(u, User.class);
        userRepo.save(user);
    }

    @Override
    public List<UserDto> getAll() {
        List<UserDto> users = new ArrayList<>();
        userRepo.findAll().forEach(
                user -> users.add(modelMapper.map(user, UserDto.class))
        );
        return users;
    }

    @Override
    public UserDto getById(UUID id) {
        return modelMapper.map(userRepo.findById(id).get(), UserDto.class);
    }

    @Override
    public void update(UserDto u) {
        
    }

    @Override
    public void delete(UUID id) {

    }
}
