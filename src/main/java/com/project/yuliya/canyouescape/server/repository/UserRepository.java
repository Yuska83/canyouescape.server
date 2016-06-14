package com.project.yuliya.canyouescape.server.repository;

import com.project.yuliya.canyouescape.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {
}
