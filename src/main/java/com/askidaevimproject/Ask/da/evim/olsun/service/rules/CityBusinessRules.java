package com.askidaevimproject.Ask.da.evim.olsun.service.rules;

import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.exceptions.CityNameNotFoundException;
import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.exceptions.MemberNameNotFoundException;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CityBusinessRules {

    private CityRepository cityRepository;

    public void checkIfCityNameExists(String cityName) throws CityNameNotFoundException {
        if((this.cityRepository.existsByCityName(cityName))){
            throw new CityNameNotFoundException("The city name is  matched  city please check entered city name ");
        }
    }
}
