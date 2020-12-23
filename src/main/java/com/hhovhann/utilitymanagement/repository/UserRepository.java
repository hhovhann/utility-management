package com.hhovhann.utilitymanagement.repository;

import com.hhovhann.utilitymanagement.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User, Long> {
}
