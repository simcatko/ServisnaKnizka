package com.sima.servicebook.repository;


import com.sima.servicebook.model.Client;
import com.sima.servicebook.model.Record;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RecordRepository extends CrudRepository<Record, Long> {
    @Query("SELECT r FROM Record r WHERE r.carId = ?1")
    List<Record> findByCar(Long carId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Record u WHERE u.carId = ?1")
    void deleteByCarId(Long carId);
}
