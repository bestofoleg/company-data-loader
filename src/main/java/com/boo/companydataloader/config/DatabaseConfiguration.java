package com.boo.companydataloader.config;

import com.boo.companydataloader.ontology.system.connection.data.IConnectionData;
import com.boo.companydataloader.ontology.system.connection.data.OntologyConnectionData;
import com.boo.companydataloader.ontology.system.repository.IOntologyRepository;
import com.boo.companydataloader.ontology.system.repository.OntologyRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class DatabaseConfiguration {
    private static final String ONTOLOGY_DATABASE_FILE_PATHNAME = "database.owl";

    private static final String ONTOLOGY_DATABASE_NAME = "Orgs";

    @Autowired
    private IConnectionData protegeConnectionData;

    @Bean
    public IConnectionData getProtegeConnectionData() {
        File owlFile = new File(ONTOLOGY_DATABASE_FILE_PATHNAME);
        return new OntologyConnectionData(owlFile, ONTOLOGY_DATABASE_NAME);
    }

    @Bean
    public IOntologyRepository getOntologyRepository() {
        IOntologyRepository repository =
                new OntologyRepositoryImpl();
        repository.createConnection(protegeConnectionData);
        repository.saveOntology();
        return repository;
    }
}
