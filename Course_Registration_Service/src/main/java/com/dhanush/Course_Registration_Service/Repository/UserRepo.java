package com.dhanush.Course_Registration_Service.Repository;

import com.dhanush.Course_Registration_Service.Entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends JpaRepository<UserEntity,Long>{
    UserEntity findUserBymailid(String mailid);
}
