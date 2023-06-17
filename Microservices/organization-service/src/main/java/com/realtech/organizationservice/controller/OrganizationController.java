package com.realtech.organizationservice.controller;

import com.realtech.organizationservice.entity.Organization;
import com.realtech.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/organizations")
public class OrganizationController {
    private OrganizationService organizationService;

    @PostMapping
    public ResponseEntity<Organization> saveOrganization(@RequestBody Organization organization){
        Organization savedOrganization=organizationService.saveOrganization(organization);
        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }

    @GetMapping("{organizationCode}")
    public ResponseEntity<Organization> getOrganization(@PathVariable String organizationCode){
        Organization savedOrganization=organizationService.getOrganizationByCode(organizationCode);
        return new ResponseEntity<>(savedOrganization,HttpStatus.OK);
    }
}
