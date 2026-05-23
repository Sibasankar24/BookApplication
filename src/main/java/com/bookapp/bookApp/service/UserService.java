package com.bookapp.bookApp.service;
import com.bookapp.bookApp.Repository.UserRepository;
import com.bookapp.bookApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    public void saveUser(User user){
        userRepository.save(user);
    }
    public List<User> findAllUser(){
        return userRepository.findAll();
    }
    public Optional<User> findUserById(ObjectId id){
        return userRepository.findById(id);
    }
    public void deleteUserById(ObjectId id){
        userRepository.deleteById(id);
    }
    public User findUserByUserName(String user){
        return userRepository.findByUserName(user);
    }

}
