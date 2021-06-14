package com.airfrance.testfirassahli.repository;

import com.airfrance.testfirassahli.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
