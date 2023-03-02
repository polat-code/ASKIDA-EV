package com.askidaevimproject.Ask.da.evim.olsun.service.concretes;
import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.mappers.abstracts.ModelMapperService;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.City;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.CityRepository;
import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.CityService;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateCityRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateCityRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllCityResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByCityNameResponse;
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

    @Override
    public void addCity(CreateCityRequest cityRequest) {
        City city = this.modelMapperService.forRequest().map(cityRequest,City.class);
        this.cityRepository.save(city);
    }

    @Override
    public void deleteCityById(Long city_id) {

        if(this.cityRepository.existsById(city_id)){
            this.cityRepository.deleteById(city_id);
        }
    }


    @Override
    public void updateCity(UpdateCityRequest updateCityRequest) {

        City city = this.modelMapperService.forRequest().map(updateCityRequest,City.class);
        /*
        * City_id is primary key , so city _ id cannot be the same.Therefore,
        * we do not need to check data is already.Otherwise, we have to check whether city or not.
        *
        * */
        this.cityRepository.save(city);



    }

    @Override
    public GetByCityNameResponse getByCityName(String cityName) {
        City city = this.cityRepository.findByCityName(cityName);
        return this.modelMapperService.forResponse().map(city,GetByCityNameResponse.class);
    }


}
