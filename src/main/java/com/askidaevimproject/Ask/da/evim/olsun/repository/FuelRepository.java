package com.askidaevimproject.Ask.da.evim.olsun.repository;

import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelRepository extends JpaRepository<Fuel,Long> {

}
