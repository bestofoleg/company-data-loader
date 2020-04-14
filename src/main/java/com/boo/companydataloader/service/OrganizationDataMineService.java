package com.boo.companydataloader.service;

import com.boo.companydataloader.dto.OrganizationData;
import com.boo.companydataloader.processor.AddOrganizationAddressToDBProcessor;
import com.boo.companydataloader.processor.AddOrganizationToDBIfNotExistsProcessor;
import com.boo.companydataloader.processor.SetOrganizationNameProcessor;
import com.kuliginstepan.dadata.client.domain.organization.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationDataMineService {
    @Autowired
    private AddOrganizationToDBIfNotExistsProcessor addOrganizationToDBIfNotExistsProcessor;

    @Autowired
    private SetOrganizationNameProcessor setOrganizationNameProcessor;

    @Autowired
    private AddOrganizationAddressToDBProcessor addOrganizationAddressToDBProcessor;

    public OrganizationData search(String inn) {
        OrganizationData organizationData = new OrganizationData(inn);
        Organization organization = null;
        organization = addOrganizationToDBIfNotExistsProcessor.doAction(organizationData, organization);
        organization = setOrganizationNameProcessor.doAction(organizationData, organization);
        organization = addOrganizationAddressToDBProcessor.doAction(organizationData, organization);
        return organizationData;
    }
}
