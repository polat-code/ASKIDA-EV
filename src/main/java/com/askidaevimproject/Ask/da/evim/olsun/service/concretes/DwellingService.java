package com.askidaevimproject.Ask.da.evim.olsun.service.concretes;

import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.DwellingRepository;
import org.springframework.stereotype.Service;

@Service

public class DwellingService {

    private  DwellingRepository dwellingRepository;

    public DwellingService(){}
    public DwellingService(DwellingRepository dwellingRepository) {
        this.dwellingRepository = dwellingRepository;
    }


}
