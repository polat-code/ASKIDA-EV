package com.askidaevimproject.Ask.da.evim.olsun.controller;

import com.askidaevimproject.Ask.da.evim.olsun.exception.AdvertNotFoundException;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Advert;
import com.askidaevimproject.Ask.da.evim.olsun.service.AdvertService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/advert")

public class AdvertController {

    private AdvertService advertService;


    public AdvertController(AdvertService advertService) {
        this.advertService = advertService;
    }
    public AdvertController(){

    }

    @GetMapping("/")
    public List<Advert> getAllAdvert(){
        return advertService.getAllAdvert();
    }

    @PostMapping("/")
    public Advert addAdvert(@RequestBody Advert advert) throws Exception {

        return advertService.addAdvert(advert);
    }


    @DeleteMapping("/deleteAdvert/{advert_id}")
    public void deleteAdvert(@PathVariable Long advert_id) throws AdvertNotFoundException {
        advertService.deleteAdvert(advert_id);
    }
    @PutMapping("/updateAdvert/{advert_id}")
    public Advert updateAdvert(@RequestBody Advert advert,@PathVariable(name = "advert_id") Long advert_id) throws AdvertNotFoundException {
        return advertService.updateAdvert(advert,advert_id);
    }


}
