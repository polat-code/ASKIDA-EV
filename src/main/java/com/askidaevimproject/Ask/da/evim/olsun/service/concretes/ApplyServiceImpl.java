package com.askidaevimproject.Ask.da.evim.olsun.service.concretes;

import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.mappers.abstracts.ModelMapperService;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Apply;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.ApplyRepository;
import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.ApplyService;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllApplyResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ApplyServiceImpl implements ApplyService {

    private ApplyRepository applyRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllApplyResponse> getAllApply() {

        List<Apply> applyList = this.applyRepository.findAll();

        return applyList.stream().map(apply ->
                this.modelMapperService.forResponse().
                        map(apply,GetAllApplyResponse.class)).
                toList();
    }

}
