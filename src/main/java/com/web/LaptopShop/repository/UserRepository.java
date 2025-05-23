package com.web.LaptopShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.LaptopShop.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);

    User findById(long id);

    void deleteById(long id);

    List<User> findAll();

    boolean existsByEmail(String email);

    User findByEmail(String email);
}
