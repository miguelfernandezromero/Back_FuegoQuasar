package com.edesafio.quasar.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.edesafio.quasar.entity.SatellitesRqEntity;

public interface SatellitesRqRepository extends JpaRepository<SatellitesRqEntity, Long> {
	
	SatellitesRqEntity findByName(String name);

}
