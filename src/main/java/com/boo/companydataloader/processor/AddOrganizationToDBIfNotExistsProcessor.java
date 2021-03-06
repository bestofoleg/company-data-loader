package com.boo.companydataloader.processor;

import com.boo.companydataloader.dto.OrganizationData;
import com.boo.companydataloader.ontology.system.repository.IOntologyRepository;
import com.boo.companydataloader.service.CompanyService;
import com.boo.companydataloader.sparql.query.Queries;
import com.hp.hpl.jena.query.QuerySolution;
import com.kuliginstepan.dadata.client.domain.organization.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddOrganizationToDBIfNotExistsProcessor implements IProcessor{
    @Autowired
    private IOntologyRepository ontologyRepository;

    @Autowired
    private CompanyService companyService;

    @Override
    public Organization doAction(OrganizationData data, Organization organization) {
        List <QuerySolution> solutions =
                ontologyRepository.getResultSetByQuery(
                        String.format(Queries.CHECK_INN_EXISTENCE, data.getInn())
                );
        if (solutions.isEmpty()) {
            organization = companyService.addCompany(data.getInn());
            data.setNeedToBeSave(true);
            System.out.println("Check exist processor. Data will selected from dadata!");
        } else {
            data.setNeedToBeSave(false);
                    System.out.println("Check exist processor. Data will selected from onto!");
            solutions = ontologyRepository.getResultSetByQuery(
                    String.format(
                            Queries.SELECT_COMPANY_NAME_BY_INN,
                            data.getInn()
                    )
            );
            data.setName(solutions.get(0).getResource("INST").getLocalName());
            solutions = ontologyRepository.getResultSetByQuery(
                    String.format(
                            Queries.SELECT_COMPANY_ADDRESS_BY_INN,
                            data.getInn()
                    )
            );
            data.setAddress(solutions.get(0).getResource("INST").getLocalName());
        }
        System.out.println("Check existence processor. Data will save = " + data.isNeedToBeSave());
        return organization;
    }
}
