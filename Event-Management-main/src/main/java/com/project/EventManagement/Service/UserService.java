package com.project.EventManagement.Service;

import com.project.EventManagement.Model.User;
import com.project.EventManagement.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    private PasswordEncoder passwordEncoder;

    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
    public User getUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public boolean isValidUser(String username, String password) {
        User user = userRepo.findByUsername(username);
        if (user != null) {
            return passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }

    public String addUsers(List<User> s){
        userRepo.saveAll(s);
        return "List of Users are added !!!";
    }

    public Iterable<User> getAllUsers(){
        return userRepo.findAll();
    }

    public Optional<User> getUserById(Integer id){
        return userRepo.findById(id);
    }

//    public  String updateUserDepartment(Integer id, Department department){
//        Optional<User> s = userRepo.findById(id);
//
//        if(s.isEmpty()){
//            return "User Id not found !!!";
//        }
//
//        User stu = s.get();
//        stu.setUserDepartment(department);
//        userRepo.save(stu);
//        return "User's Department is Updated !!!";
//    }

    public String removeUserById(Integer id){

        User stu = userRepo.findById(id).orElse(null);

        if(stu==null){
            return "User's Id not found";
        }

        userRepo.delete(stu);

        return "User is Removed";
    }

}
