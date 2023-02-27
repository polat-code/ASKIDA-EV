package com.askidaevimproject.Ask.da.evim.olsun.webApi.controllers;

import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.NeighborhoodService;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateNeighborhoodRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllNeighBorHoodResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByNeighborHoodZipCodeResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/neighborhood")
@AllArgsConstructor
public class NeighborhoodController {

    private NeighborhoodService neighborhoodService;


    @GetMapping("")
    public List<GetAllNeighBorHoodResponse> getAllNeighBorHood(){
        return neighborhoodService.getAllNeighBorHood();
    }

    @GetMapping("/{zip_code}")
    public GetByNeighborHoodZipCodeResponse getByZipcode(String zip_code){
        return neighborhoodService.getByZipcode(zip_code);

    }

    @PostMapping("")
    public void addNeighborhood(@RequestBody CreateNeighborhoodRequest createNeighborhoodRequest){
        this.neighborhoodService.addNeighborhood(createNeighborhoodRequest);
    }









}
