package com.askidaevimproject.Ask.da.evim.olsun.service.concretes;

import com.askidaevimproject.Ask.da.evim.olsun.core.mappers.abstracts.ModelMapperService;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.City;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.CityRepository;
import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.CityService;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllCityResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllCityResponse> getAllCity() {
        List<City> cities = this.cityRepository.findAll();

        return cities.
                stream().
                map(city -> this.modelMapperService.forResponse().map(city,GetAllCityResponse.class)).toList();
    }

}
