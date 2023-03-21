package com.askidaevimproject.Ask.da.evim.olsun.webApi.controllers;

import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.ContactService;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateContactRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllContactResponse;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private ContactService contactService;


    @GetMapping("")
    public List<GetAllContactResponse> getAllContact(){
        return this.contactService.getAllContact();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)

    public void addContact(@RequestBody @Valid CreateContactRequest createContactRequest){
        this.contactService.addContact(createContactRequest);
    }



}
