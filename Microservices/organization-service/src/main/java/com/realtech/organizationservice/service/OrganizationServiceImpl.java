package com.realtech.organizationservice.service;

import com.realtech.organizationservice.entity.Organization;
import com.realtech.organizationservice.repository.OrganizationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService{

    private OrganizationRepository  organizationRepository;
    @Override
    public Organization saveOrganization(Organization organization) {
        Organization savedOrganization=organizationRepository.save(organization);
        return savedOrganization;
    }

    @Override
    public Organization getOrganizationByCode(String organizationCode) {
       Organization savedOrganization= organizationRepository.findByOrganizationCode(organizationCode);
        return savedOrganization;
    }
}
