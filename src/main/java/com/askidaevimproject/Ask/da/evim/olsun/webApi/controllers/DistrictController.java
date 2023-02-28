package com.askidaevimproject.Ask.da.evim.olsun.webApi.controllers;

import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.DistrictService;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateDistrictRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllDistrictResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/district")
@AllArgsConstructor
public class DistrictController {

    private DistrictService districtService;


    @GetMapping("")
    public List<GetAllDistrictResponse> getAllDistrict(){

        return districtService.getAllDistrict();

    }

    @PostMapping("")
    public void addDistrict(@RequestBody CreateDistrictRequest createDistrictRequest){
        districtService.addDistrict(createDistrictRequest);
    }





}
