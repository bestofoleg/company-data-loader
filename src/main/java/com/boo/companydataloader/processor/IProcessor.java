package com.boo.companydataloader.processor;

import com.boo.companydataloader.dto.OrganizationData;
import com.kuliginstepan.dadata.client.domain.organization.Organization;

public interface IProcessor {
    Organization doAction(OrganizationData data, Organization organization);
}
