package com.userFintech.User.Fintech.Managment.Service;

import com.userFintech.User.Fintech.Managment.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.userFintech.User.Fintech.Managment.Model.User;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(User user){
        user.setBalance(500000); // Set Initial Balance to 0
        return userRepository.save(user);
    }

    public Optional<User> getUserById(String userId){
        return userRepository.findById(userId);
    }

    public User updateUserBalance(User user, double amount){
        user.setBalance(user.getBalance() + amount);
        return userRepository.save(user);
    }
}
