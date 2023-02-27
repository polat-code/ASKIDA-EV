package com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts;

import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Advert;
import org.springframework.data.jpa.repository.JpaRepository;



public interface AdvertRepository extends JpaRepository<Advert,Long> {


    Advert findByAdvertTitle(String advert_title);
}
