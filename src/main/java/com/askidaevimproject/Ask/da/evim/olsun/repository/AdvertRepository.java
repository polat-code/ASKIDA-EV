package com.askidaevimproject.Ask.da.evim.olsun.repository;

import com.askidaevimproject.Ask.da.evim.olsun.model.Advert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertRepository extends JpaRepository<Advert,Long> {


}
