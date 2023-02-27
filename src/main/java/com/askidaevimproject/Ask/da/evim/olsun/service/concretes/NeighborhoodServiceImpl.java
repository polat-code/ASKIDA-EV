package com.askidaevimproject.Ask.da.evim.olsun.service.concretes;

import com.askidaevimproject.Ask.da.evim.olsun.core.mappers.abstracts.ModelMapperService;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Neighborhood;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.NeighborhoodRepository;
import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.NeighborhoodService;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateNeighborhoodRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllNeighBorHoodResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByNeighborHoodZipCodeResponse;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class NeighborhoodServiceImpl implements NeighborhoodService {

    private NeighborhoodRepository neighborhoodRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllNeighBorHoodResponse> getAllNeighBorHood() {
        List<Neighborhood> neighborhoods = this.neighborhoodRepository.findAll();

        return neighborhoods.
                stream().
                map
                        (neighborhood
                                ->
                                this.modelMapperService.forResponse().
                                        map(neighborhood,GetAllNeighBorHoodResponse.class)).toList();
    }

    @Override
    public GetByNeighborHoodZipCodeResponse getByZipcode(String zip_code) {

        Neighborhood neighborhood = this.neighborhoodRepository.findByZipCode(zip_code);

        return this.modelMapperService.forResponse().map(neighborhood,GetByNeighborHoodZipCodeResponse.class);

    }

    @Override
    public void addNeighborhood(CreateNeighborhoodRequest createNeighborhoodRequest) {
        Neighborhood neighborhood = this.modelMapperService.forRequest().map(createNeighborhoodRequest,Neighborhood.class);
        this.neighborhoodRepository.save(neighborhood);
    }


}
