package com.edesafio.quasar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edesafio.quasar.entity.SatelliteEntity;

public interface SatelliteRepository extends JpaRepository<SatelliteEntity, Long> {

}
