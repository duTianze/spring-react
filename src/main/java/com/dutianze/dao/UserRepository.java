package com.dutianze.dao;

import com.dutianze.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dutianze
 */
public interface UserRepository extends JpaRepository<User, String> {
}
