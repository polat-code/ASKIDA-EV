package com.askidaevimproject.Ask.da.evim.olsun.service;

import com.askidaevimproject.Ask.da.evim.olsun.repository.DwellingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class DwellingService {

    private final DwellingRepository dwellingRepository;

    public DwellingService(DwellingRepository dwellingRepository) {
        this.dwellingRepository = dwellingRepository;
    }


}
