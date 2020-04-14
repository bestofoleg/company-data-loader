package com.boo.companydataloader.service;

import com.boo.companydataloader.dto.OrganizationData;
import com.boo.companydataloader.processor.IProcessor;
import com.kuliginstepan.dadata.client.domain.organization.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationDataMineService {
    @Autowired
    private List<IProcessor> processorsQueue;

    public OrganizationData search(String inn) {
        OrganizationData organizationData = new OrganizationData(inn);
        Organization organization = null;
        for (IProcessor processor : processorsQueue) {
            organization = processor.doAction(organizationData, organization);
        }
        return organizationData;
    }
}
