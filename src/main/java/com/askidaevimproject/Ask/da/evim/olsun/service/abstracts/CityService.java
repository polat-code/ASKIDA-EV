package com.askidaevimproject.Ask.da.evim.olsun.service.abstracts;

import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateCityRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateCityRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllCityResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityService {
    List<GetAllCityResponse> getAllCity();
    void addCity(CreateCityRequest cityRequest);
    void deleteCityById(Long city_id);
    void updateCity(UpdateCityRequest updateCityRequest);
}
