package com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts;

import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.District;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictRepository extends JpaRepository<District,Long> {

    District findByDistrictName(String district_name);
}
