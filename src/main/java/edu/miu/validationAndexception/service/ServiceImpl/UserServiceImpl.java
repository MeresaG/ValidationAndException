package edu.miu.validationAndexception.service.ServiceImpl;

import edu.miu.validationAndexception.dto.UserDto;
import edu.miu.validationAndexception.entity.User;
import edu.miu.validationAndexception.repository.UserRepo;
import edu.miu.validationAndexception.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto save(UserDto u) {
        User user = modelMapper.map(u, User.class);
        userRepo.save(user);
        return u;
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
    public UserDto delete(UUID id) {
        UserDto u = getById(id);
        userRepo.deleteById(id);
        return u;
    }
}
