package com.askidaevimproject.Ask.da.evim.olsun.service.concretes;

import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.mappers.abstracts.ModelMapperService;
import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.exceptions.FuelIsNotFoundException;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Fuel;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.FuelRepository;
import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.FuelService;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateFuelRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateFuelRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllFuelResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByFuelIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FuelServiceImpl implements FuelService {

    private  FuelRepository fuelRepository;

    private ModelMapperService modelMapperService;


    public List<GetAllFuelResponse> getAllFuels(){

        List<Fuel> fuels = this.fuelRepository.findAll();

        return fuels.
                stream()
                .map(fuel ->
                        this.modelMapperService.
                                forResponse().
                                map(fuel,GetAllFuelResponse.class)).toList();



    }

    @Override
    public GetByFuelIdResponse getByFuelIdResponse(Long fuel_id) throws FuelIsNotFoundException {
        Fuel fuel = this.fuelRepository.findById(fuel_id).orElseThrow(()->new FuelIsNotFoundException("fuel is not found"));
        return this.modelMapperService.forResponse().map(fuel,GetByFuelIdResponse.class);
    }

    @Override
    public void updateFuel(UpdateFuelRequest updateFuelRequest)
    {

        Fuel fuel = this.modelMapperService.forResponse().map(updateFuelRequest,Fuel.class);
        this.fuelRepository.save(fuel);
    }

    @Override
    public void addFuel(CreateFuelRequest createFuelRequest) {
        Fuel fuel = this.modelMapperService.forRequest().map(createFuelRequest,Fuel.class);

        this.fuelRepository.save(fuel);
    }


    public void deleteFuel(Long fuel_id) {


        this.fuelRepository.deleteById(fuel_id);
    }
}
