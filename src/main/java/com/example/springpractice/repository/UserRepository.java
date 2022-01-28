package com.example.springpractice.repository;

import com.example.springpractice.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
    Page<User> findAll(Pageable pageable);

    @Query("select u from User u where u.roleCode = ?1")
    ArrayList<User> findByRoleCode(String roleCode);

    @Modifying
    @Query("update User o set o.username = :username where o.id = :id")
    void update(@Param("id") Integer id, @Param("username") String username);
}
