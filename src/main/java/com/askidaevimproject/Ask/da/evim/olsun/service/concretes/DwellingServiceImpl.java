package com.askidaevimproject.Ask.da.evim.olsun.service.concretes;

import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.mappers.abstracts.ModelMapperService;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Dwelling;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.*;
import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.DwellingService;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateDwellingRequest;
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
    private CityRepository cityRepository;
    private DistrictRepository districtRepository;
    private NeighborhoodRepository neighborhoodRepository;
    private FuelRepository fuelRepository;


    @Override
    public List<GetAllDwellingResponse> getAllDwelling() {
        return null;
    }

    @Override
    public void addDistrict(CreateDwellingRequest createDwellingRequest) {

        Dwelling dwelling = this.modelMapperService.forRequest().map(createDwellingRequest,Dwelling.class);
        if(
                cityRepository.existsById(dwelling.getCity().getCityId())
                && districtRepository.existsById(dwelling.getDistrict().getDistrict_id())
                && neighborhoodRepository.existsById(dwelling.getNeighborhood().getNeighborhood_id())
                && fuelRepository.existsById(dwelling.getFuel().getFuel_id())
        )
            this.dwellingRepository.save(dwelling);

    }


}
