package com.boo.companydataloader.processor;

import com.boo.companydataloader.dto.OrganizationData;
import com.boo.companydataloader.ontology.system.repository.IOntologyRepository;
import com.boo.companydataloader.service.RussianCharsetsCorrectorService;
import com.boo.companydataloader.util.EntitiesConstants;
import com.kuliginstepan.dadata.client.domain.address.Address;
import com.kuliginstepan.dadata.client.domain.organization.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddOrganizationAddressToDBProcessor implements IProcessor {
    @Autowired
    private IOntologyRepository ontologyRepository;

    @Autowired
    private RussianCharsetsCorrectorService correctorService;

    @Override
    public Organization doAction(OrganizationData data, Organization organization) {
        System.out.println("Address Processor started! Data will save = " + data.isNeedToBeSave());
        if (data.isNeedToBeSave()) {
            Address addressObj = organization.getAddress().getData();
            String russianLangAddress =
                    addressObj.getCity()+"_"+addressObj.getStreet();
            String companyAddress =
                    correctorService.correct(russianLangAddress);
            ontologyRepository.addIndividual(
                    EntitiesConstants.COMPANY_ADDRESS_CLASS_NAME,
                    companyAddress
            );
            ontologyRepository.saveOntology();
            ontologyRepository.addOntProperty(
                    EntitiesConstants.HAS_COMPANY_ADDRESS_PROPERTY_NAME,
                    organization.getInn(),
                    companyAddress
            );
            ontologyRepository.saveOntology();
            data.setAddress(companyAddress);
        }
        return organization;
    }
}
