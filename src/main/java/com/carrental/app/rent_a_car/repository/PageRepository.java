package com.carrental.app.rent_a_car.repository;

import com.carrental.app.rent_a_car.entity.PageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository extends JpaRepository<PageEntity, Long> {
    PageEntity findPageEntityById(long id);
}
