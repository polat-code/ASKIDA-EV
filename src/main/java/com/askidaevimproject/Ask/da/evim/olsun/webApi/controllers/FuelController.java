package com.askidaevimproject.Ask.da.evim.olsun.webApi.controllers;
import com.askidaevimproject.Ask.da.evim.olsun.exception.FuelIsAlreadyExıstException;
import com.askidaevimproject.Ask.da.evim.olsun.exception.FuelIsNotFoundException;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Fuel;
import com.askidaevimproject.Ask.da.evim.olsun.service.concretes.FuelService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fuel")
public class FuelController {

    private FuelService fuelService;

    public FuelController(FuelService fuelService) {
        this.fuelService = fuelService;
    }
    public FuelController(){}

    @GetMapping("/")
    public List<Fuel> getAllFuels(){
        return fuelService.getAllFuels();

    }
    @PostMapping("/")
    public Fuel addFuel(@RequestBody Fuel fuel) throws FuelIsAlreadyExıstException {
        return fuelService.addFuel(fuel);
    }
    @DeleteMapping
    public void deleteFuel(@PathVariable Long fuel_id) throws FuelIsNotFoundException {
        fuelService.deleteFuel(fuel_id);
    }

}
