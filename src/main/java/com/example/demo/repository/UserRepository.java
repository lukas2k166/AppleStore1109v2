package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
        extends JpaRepository<User, Long>  {

    User findByUsername(String username);

//    @Transactional
//    @Modifying
//    @Query("UPDATE AppUser a " +
//            "SET a.enabled = TRUE WHERE a.username = ?1")
//    int enableAppUser(String username);
}
