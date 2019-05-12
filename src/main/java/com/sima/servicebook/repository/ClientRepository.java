package com.sima.servicebook.repository;

import com.sima.servicebook.model.Client;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    @Query("SELECT u FROM Client u WHERE u.serviceId = ?1")
    List<Client> findByService(Long serviceId);

    @Query("SELECT c.serviceId FROM Client c WHERE c.id = ?1")
    Long getServiceId(Long clientId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Client u WHERE u.serviceId = ?1")
    void deleteByServiceId(Long serviceId);
}
