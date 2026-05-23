package com.bookapp.bookApp.controller;

import com.bookapp.bookApp.Repository.UserRepository;
import com.bookapp.bookApp.entity.User;
import com.bookapp.bookApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> allUser=userService.findAllUser();
        if(allUser!=null){
            return ResponseEntity.ok(allUser);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/adduser")
    public ResponseEntity<User> AddUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/id/{myid}")
    public ResponseEntity<String> getUserByID(@PathVariable(name = "myid") ObjectId id) {
        Optional<User> userByID = userService.findUserById(id);
        if(userByID.isPresent()) {
            return ResponseEntity.ok(userByID.toString());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with id " + id + " not found");
    }

  /*  @PutMapping("/moduser/{id}")
    public ResponseEntity<String> updateUser(@PathVariable ObjectId id,@RequestBody User newUser) {
        Optional<User> user=userService.findUserById(id);
        if(user.isPresent()) {
            Optional.ofNullable(newUser.getPassword())
                    .ifPresent(password -> user.setPassword(password));
            Optional.ofNullable(newUser.getPassword()).ifPresent(user::);

            Optional.ofNullable(newUserData.getPassword()).ifPresent(existingUser::setPassword);
            userService.saveUser(user);
            return ResponseEntity.accepted().body("USER with ID " + id + " is Updated"+user.toString());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID " + " is not present");
        // return ResponseEntity.ok("Book Entry with id " + id + " updated");
    }*/
  @PutMapping("/moduser/{username}")
  public ResponseEntity<String> updateUser(@RequestBody User newUser, @PathVariable String username) {
      User userInDb=userService.findUserByUserName(username);
      if(userInDb!=null){
          userInDb.setUserName(newUser.getUserName());
          userInDb.setPassword(newUser.getPassword());
          userService.saveUser(userInDb);
          return ResponseEntity.accepted().body("USER with ID " + userInDb + " is Updated"+userInDb.toString());
      }
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with UserName " +userInDb+" is not present");
  }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable ObjectId id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok("USER with id " + id + " is deleted");
    }
}
