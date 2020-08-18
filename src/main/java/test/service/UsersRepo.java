package test.service;

import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import test.model.User;

public interface UsersRepo extends CrudRepository<User, Integer> {
}
