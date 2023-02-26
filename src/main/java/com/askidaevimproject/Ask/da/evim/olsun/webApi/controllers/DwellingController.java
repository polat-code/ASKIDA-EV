package com.askidaevimproject.Ask.da.evim.olsun.webApi.controllers;

import com.askidaevimproject.Ask.da.evim.olsun.service.concretes.DwellingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dwelling")

public class DwellingController {

    private DwellingService dwellingService;

    public DwellingController(DwellingService dwellingService) {
        this.dwellingService = dwellingService;
    }
    public DwellingController(){}
}
