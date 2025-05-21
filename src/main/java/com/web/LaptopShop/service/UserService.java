package com.web.LaptopShop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.LaptopShop.domain.Role;
import com.web.LaptopShop.domain.User;
import com.web.LaptopShop.repository.RoleRepository;
import com.web.LaptopShop.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<User> listUser() {
        return this.userRepository.findAll();
    }

    public User handleSaveUser(User user) {
        return this.userRepository.save(user);
    }

    public User detailUser(long id) {
        return this.userRepository.findById(id);
    }

    public void deleteUser(long id) {
        this.userRepository.deleteById(id);
    }

    public Role getRoleByName(String name) {
        return this.roleRepository.findByName(name);
    }

    public boolean checkEmail(String email) {
        return this.userRepository.existsByEmail(email);
    }

    public boolean checkPassword(String password1, String password2) {
        return password1.equals(password2);
    }

    public User getUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }
}
