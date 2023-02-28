package com.askidaevimproject.Ask.da.evim.olsun.service.requests;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Dwelling;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Member;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAdvertRequest {

    @Column(name = "advert_title")
    private String advertTitle;

    @Column(name="dwelling_id")
    @JoinColumn(name = "dwelling_id")
    private Dwelling dwelling;

    @Column(name="member_id")
    @JoinColumn(name="member_id")
    private Member member;

}
