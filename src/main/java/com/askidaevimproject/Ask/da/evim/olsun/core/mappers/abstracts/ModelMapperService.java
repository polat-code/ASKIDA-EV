package com.askidaevimproject.Ask.da.evim.olsun.core.mappers.abstracts;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {

    ModelMapper forRequest();
    ModelMapper forResponse();

}
