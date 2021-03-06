package edu.miu.validationAndexception.repository;

import edu.miu.validationAndexception.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepo extends CrudRepository<UserEntity, UUID> {
}
