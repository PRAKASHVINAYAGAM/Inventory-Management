package com.demo.InventoryManagementProject.Repository;


import org.springframework.stereotype.Repository;
import com.demo.InventoryManagementProject.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}