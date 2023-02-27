package com.askidaevimproject.Ask.da.evim.olsun.service.responses;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByAdvertTitle {

    @Column(name="advert_title")
    private String advertTitle;
}
