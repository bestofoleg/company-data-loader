package com.boo.companydataloader.processor;

import com.boo.companydataloader.dto.OrganizationData;
import com.boo.companydataloader.service.DadataService;
import com.kuliginstepan.dadata.client.domain.Suggestion;
import com.kuliginstepan.dadata.client.domain.organization.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class SetOrganizationNameProcessor implements IProcessor {
    @Autowired
    private DadataService dadataService;

    @Override
    public void doAction(OrganizationData data) {
      Flux<Suggestion<Organization>> organization =
                dadataService.getOrganizationByInn(data.getInn());
        data.setName(organization.blockFirst().getData().getName().getFullWithOpf());
    }
}
