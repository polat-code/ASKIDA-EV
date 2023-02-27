package com.askidaevimproject.Ask.da.evim.olsun.webApi.controllers;


import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.DwellingService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dwelling")
@AllArgsConstructor
public class DwellingController {

    private DwellingService dwellingService;



    @GetMapping("")
    public List<GetAll>






}
