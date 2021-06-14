package com.airfrance.testfirassahli.repository;

import com.airfrance.testfirassahli.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository to manage calls between our application and database
 *
 * @author firas.sahli
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
