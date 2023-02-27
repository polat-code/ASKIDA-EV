package com.askidaevimproject.Ask.da.evim.olsun.webApi.controllers;

import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.NeighborhoodService;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllNeighBorHoodResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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









}
