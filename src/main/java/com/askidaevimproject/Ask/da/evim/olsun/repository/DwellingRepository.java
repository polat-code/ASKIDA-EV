package com.askidaevimproject.Ask.da.evim.olsun.repository;

import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Dwelling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DwellingRepository extends JpaRepository<Dwelling,Long> {

}
