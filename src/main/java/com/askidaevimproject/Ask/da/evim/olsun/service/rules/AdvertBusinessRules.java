package com.askidaevimproject.Ask.da.evim.olsun.service.rules;

import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.AdvertRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AdvertBusinessRules {

    private AdvertRepository advertRepository;
}
