package com.askidaevimproject.Ask.da.evim.olsun.service.rules;

import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.exceptions.FuelIsAlreadyExıstException;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.FuelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FuelBusinessRules {

    private FuelRepository fuelRepository;


    public void checkIfFuelTypeExists(String fuelType){
        if(this.fuelRepository.existsByFuelType(fuelType)){
            throw new FuelIsAlreadyExıstException("The fuel type is using in the database");
        }
    }


}
