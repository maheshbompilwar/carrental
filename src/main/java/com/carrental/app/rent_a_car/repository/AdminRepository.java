package com.carrental.app.rent_a_car.repository;

import com.carrental.app.rent_a_car.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Long> {
    AdminEntity findAdminEntityById(long id);
    AdminEntity findAdminEntityByUserName(String username);
}
