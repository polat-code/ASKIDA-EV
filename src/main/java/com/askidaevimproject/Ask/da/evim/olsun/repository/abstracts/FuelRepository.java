package com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts;

import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;



public interface FuelRepository extends JpaRepository<Fuel,Long> {

    boolean existsByFuelType(String fuelType);
}
