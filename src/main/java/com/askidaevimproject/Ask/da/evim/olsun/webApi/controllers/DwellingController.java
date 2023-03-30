package com.askidaevimproject.Ask.da.evim.olsun.webApi.controllers;


import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.DwellingService;

import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateDwellingRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/dwellings")
@AllArgsConstructor
public class DwellingController {

    private DwellingService dwellingService;

    @GetMapping("")
    public List<GetAllDwellingResponse> getAllDwelling(){
        return dwellingService.getAllDwelling();

    }

    @PostMapping("")
    public void addDistrict(@RequestBody @Valid CreateDwellingRequest createDwellingRequest){
        this.dwellingService.addDistrict(createDwellingRequest);
    }











}
