package com.askidaevimproject.Ask.da.evim.olsun.webApi.controllers;


import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.DwellingService;

import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateDwellingRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllDwellingResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dwelling")
@AllArgsConstructor
public class DwellingController {

    private DwellingService dwellingService;

    @GetMapping("")
    public List<GetAllDwellingResponse> getAllDwelling(){
        return dwellingService.getAllDwelling();

    }

    @PostMapping("")
    public void addDistrict(@RequestBody CreateDwellingRequest createDwellingRequest){
        this.dwellingService.addDistrict(createDwellingRequest);
    }











}
