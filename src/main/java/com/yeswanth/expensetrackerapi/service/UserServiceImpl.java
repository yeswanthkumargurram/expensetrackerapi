package com.yeswanth.expensetrackerapi.service;

import com.yeswanth.expensetrackerapi.Exceptions.ItemAlreadyExistingException;
import com.yeswanth.expensetrackerapi.Exceptions.ResourceNotFoundException;
import com.yeswanth.expensetrackerapi.models.User;
import com.yeswanth.expensetrackerapi.models.UserModel;
import com.yeswanth.expensetrackerapi.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder bcryptEncoder;
    @Override
    public User createUser(UserModel user) {
        if(userRepository.existsByEmail(user.getEmail())){
            throw new ItemAlreadyExistingException("User is already registered with email:"+user.getEmail());
        }
        User newUser = new User();
        BeanUtils.copyProperties(user, newUser);
        newUser.setPassword(bcryptEncoder.encode(newUser.getPassword()));
        return userRepository.save(newUser);
    }

    @Override
    public User read(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for the id:"+id));
    }

    @Override
    public User update(UserModel user, Long id) {
        User oldUser = read(id);
        oldUser.setName(user.getName() != null ? user.getName() : oldUser.getName());
        oldUser.setEmail(user.getEmail() !=null ? user.getEmail() : oldUser.getEmail());
        oldUser.setAge(user.getAge() != null ? user.getAge() : oldUser.getAge());
        oldUser.setPassword(user.getPassword()!=null ? bcryptEncoder.encode(user.getPassword()) : oldUser.getPassword());
        return userRepository.save(oldUser);
    }

    @Override
    public void delete(Long id) {
        User user = read(id);
        userRepository.delete(user);

    }
}
