package com.askidaevimproject.Ask.da.evim.olsun.service.concretes;

import com.askidaevimproject.Ask.da.evim.olsun.core.mappers.abstracts.ModelMapperService;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.DwellingRepository;
import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.DwellingService;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllDwellingResponse;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class DwellingServiceImpl implements DwellingService {

    private  DwellingRepository dwellingRepository;
    private ModelMapperService modelMapperService;


    @Override
    public List<GetAllDwellingResponse> getAllDwelling() {
        return null;
    }
}
