package com.askidaevimproject.Ask.da.evim.olsun.webApi.controllers;


import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.CityService;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateCityRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateCityRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllCityResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByCityNameResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@AllArgsConstructor
@RestController
@RequestMapping("/api/cities")
public class CityController {

    private CityService cityService;


    @GetMapping("")
    List<GetAllCityResponse> getAllCity(){
        return cityService.getAllCity();
    }
    @PostMapping("")
    @ResponseStatus(CREATED)
    public void addCity(@RequestBody CreateCityRequest cityRequest){
        cityService.addCity(cityRequest);
    }
    @DeleteMapping("/{city_id}")
    public void deleteCity(@PathVariable Long city_id){
        cityService.deleteCityById(city_id);
    }

    @GetMapping("/{cityName}")
    public GetByCityNameResponse getByCityNameResponse(@PathVariable String cityName){
        return cityService.getByCityName(cityName);
    }
    @PutMapping("")
    public void updateCity(@RequestBody UpdateCityRequest updateCityRequest){
        this.cityService.updateCity(updateCityRequest);
    }

}
