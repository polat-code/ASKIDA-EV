package com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts;

import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;




public interface CityRepository extends JpaRepository<City,Long> {


    City findByCityName(String cityName);
}
