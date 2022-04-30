package edu.miu.validationAndexception.repository;

import edu.miu.validationAndexception.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepo extends CrudRepository<User, UUID> {
}
