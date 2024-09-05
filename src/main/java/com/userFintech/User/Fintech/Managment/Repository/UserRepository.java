package com.userFintech.User.Fintech.Managment.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.userFintech.User.Fintech.Managment.Model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
