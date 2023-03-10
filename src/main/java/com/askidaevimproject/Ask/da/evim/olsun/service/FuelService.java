package com.askidaevimproject.Ask.da.evim.olsun.service;

import com.askidaevimproject.Ask.da.evim.olsun.exception.FuelIsAlreadyExıstException;
import com.askidaevimproject.Ask.da.evim.olsun.exception.FuelIsNotFoundException;
import com.askidaevimproject.Ask.da.evim.olsun.model.Fuel;
import com.askidaevimproject.Ask.da.evim.olsun.repository.FuelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class FuelService {

    private  FuelRepository fuelRepository;

    public FuelService(){}

    public FuelService(FuelRepository fuelRepository) {
        this.fuelRepository = fuelRepository;
    }

    public List<Fuel> getAllFuels(){

        return fuelRepository.findAll();

    }
    public Fuel addFuel(Fuel fuel) throws FuelIsAlreadyExıstException {

        if(fuelRepository.existsById(fuel.getFuel_id())){
            throw new FuelIsAlreadyExıstException("The fuel is already added in database");
        }
        return fuelRepository.save(fuel);

    }

    public void deleteFuel(Long fuel_id) throws FuelIsNotFoundException {
        /**
         * Silinen Id'ye ait dwelling'te ki fuel_id'yi NULL'A çevir.
         *
         * */

        if(fuelRepository.existsById(fuel_id)){
            fuelRepository.deleteById(fuel_id);
        }else{
            throw new FuelIsNotFoundException("Fuel id is not found ");
        }

    }
}
