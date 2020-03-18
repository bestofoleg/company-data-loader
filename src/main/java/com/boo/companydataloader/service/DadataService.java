package com.boo.companydataloader.service;

import com.kuliginstepan.dadata.client.DadataClient;
import com.kuliginstepan.dadata.client.domain.Suggestion;
import com.kuliginstepan.dadata.client.domain.organization.Organization;
import com.kuliginstepan.dadata.client.domain.organization.OrganizationRequestBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class DadataService {
    @Autowired
    private DadataClient dadataClient;

    public Flux<Suggestion<Organization>> getOrganizationByInn(String inn) {
        return dadataClient
                .suggestOrganization(
                        OrganizationRequestBuilder
                                .create(inn)
                                .build()
                );
    }
}
