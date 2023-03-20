package com.askidaevimproject.Ask.da.evim.olsun.webApi.controllers;

import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.ApplyService;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllApplyResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/applies")
public class ApplyController {


    private ApplyService applyService;


    @GetMapping("")
    public List<GetAllApplyResponse> getAllApply(){
        return applyService.getAllApply();
    }
}
