package com.realtech.organizationservice.service;


import com.realtech.organizationservice.entity.Organization;
import org.aspectj.weaver.ast.Or;

public interface OrganizationService {
    Organization saveOrganization(Organization organization);
    Organization getOrganizationByCode(String organizationCode);
}
