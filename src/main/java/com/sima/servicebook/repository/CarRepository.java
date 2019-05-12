package com.sima.servicebook.repository;


import com.sima.servicebook.model.Car;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
    @Query("SELECT u FROM Car u WHERE u.clientId = ?1")
    List<Car> findByClient(Long clientId);

    @Query("SELECT c.clientId FROM Car c WHERE c.id = ?1")
    Long getClientId(Long carId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Car u WHERE u.clientId = ?1")
    void deleteByClientId(Long clientId);
}
