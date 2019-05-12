package com.sima.servicebook.repository;

import com.sima.servicebook.model.Service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends CrudRepository<Service, Long> {
    @Query("SELECT u FROM Service u WHERE u.ownerId = ?1")
    List<Service> findByOwner(Long userId);
}
