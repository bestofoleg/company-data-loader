package com.boo.companydataloader.service;

import com.boo.companydataloader.dto.OrganizationData;
import com.boo.companydataloader.ontology.system.repository.IOntologyRepository;
import com.boo.companydataloader.util.EntitiesConstants;
import com.kuliginstepan.dadata.client.domain.Suggestion;
import com.kuliginstepan.dadata.client.domain.organization.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.io.UnsupportedEncodingException;

@Service
public class CompanyService {
    @Autowired
    private OrganizationDataMineService organizationDataMineService;

    @Autowired
    private IOntologyRepository ontologyRepository;

    @Autowired
    private DadataService dadataService;

    public Organization addCompany(String inn) {
        Flux<Suggestion<Organization>> organizationData = dadataService.getOrganizationByInn(inn);
        Organization organization = organizationData.blockFirst().getData();
        ontologyRepository.addIndividual(
                EntitiesConstants.INN_CLASS_NAME,
                organization.getInn()
        );
        ontologyRepository.saveOntology();
        return organization;
    }
}
