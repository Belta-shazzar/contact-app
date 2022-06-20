package com.shazzar.contactapp.repository;

import com.shazzar.contactapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.mobileNumber = :number")
    User findByMobileNumber(@Param("number") String number);
}
