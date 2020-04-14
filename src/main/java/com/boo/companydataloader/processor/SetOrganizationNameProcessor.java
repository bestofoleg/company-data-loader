package com.boo.companydataloader.processor;

import com.boo.companydataloader.dto.OrganizationData;
import com.boo.companydataloader.ontology.system.repository.IOntologyRepository;
import com.boo.companydataloader.service.DadataService;
import com.boo.companydataloader.service.RussianCharsetsCorrectorService;
import com.boo.companydataloader.util.EntitiesConstants;
import com.kuliginstepan.dadata.client.domain.organization.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SetOrganizationNameProcessor implements IProcessor {
    @Autowired
    private DadataService dadataService;

    @Autowired
    private IOntologyRepository ontologyRepository;

    @Autowired
    private RussianCharsetsCorrectorService correctorService;

    @Override
    public Organization doAction(OrganizationData data, Organization organization) {
        if (data.isNeedToBeSave()) {
            String companyName =
                    correctorService.correct(organization.getName().getFullName());
            ontologyRepository.addIndividual(
                    EntitiesConstants.COMPANY_NAME_CLASS_NAME,
                    companyName
            );
            ontologyRepository.saveOntology();
            ontologyRepository.addOntProperty(
                    EntitiesConstants.HAS_COMPANY_NAME_PROPERTY_NAME,
                    organization.getInn(),
                    companyName
            );
            ontologyRepository.saveOntology();
            data.setName(companyName);
        }
        return organization;
    }
}
