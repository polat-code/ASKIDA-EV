package com.askidaevimproject.Ask.da.evim.olsun.webApi.controllers;

import com.askidaevimproject.Ask.da.evim.olsun.exception.AdvertNotFoundException;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Advert;
import com.askidaevimproject.Ask.da.evim.olsun.service.concretes.AdvertService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/advert")
@AllArgsConstructor
public class AdvertController {

    private AdvertService advertService;



    @GetMapping("")
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
