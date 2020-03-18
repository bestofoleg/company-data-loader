package com.boo.companydataloader.processor;

import com.boo.companydataloader.dto.OrganizationData;
import com.boo.companydataloader.ontology.system.repository.IOntologyRepository;
import com.boo.companydataloader.sparql.query.Queries;
import com.hp.hpl.jena.query.QuerySolution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddOrganizationToDBIfNotExistsProcessor implements IProcessor{
    @Autowired
    private IOntologyRepository ontologyRepository;

    @Override
    public void doAction(OrganizationData data) {
        List <QuerySolution> solutions =
                ontologyRepository.getResultSetByQuery(
                        String.format(Queries.CHECK_INN_EXISTENCE, data.getInn())
                );
        if (solutions.isEmpty()) {
            System.out.println("It's not exists!");
        } else {
            solutions.forEach(solution -> System.out.println(solution.toString()));
        }
    }
}
