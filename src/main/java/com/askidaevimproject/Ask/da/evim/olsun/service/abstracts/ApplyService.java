package com.askidaevimproject.Ask.da.evim.olsun.service.abstracts;

import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllApplyResponse;

import java.util.List;

public interface ApplyService {

    List<GetAllApplyResponse> getAllApply();

    //void addApply(CreateApplyRequest createApplyRequest);

}
