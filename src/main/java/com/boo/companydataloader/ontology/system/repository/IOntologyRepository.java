package com.boo.companydataloader.ontology.system.repository;

import com.hp.hpl.jena.query.QuerySolution;
import org.apache.jena.ontology.*;

import java.util.List;

public interface IOntologyRepository extends IRepository <OntResource> {
    OntProperty addDatatypedProperty(String individualName, String dtPropertyName, Object typedLiteral);
    //DatatypeProperty addDatatypeProperty(String dtProperty, String propertyName, String ofClass);

    OntClass addOntClass(String ontClass);

    OntProperty addOntProperty(String ontProperty, String begin, String end);

    Individual addIndividual(String ontClass, String ontResource);

    OntClass addSubClass(String superClassName, String ontClassChild);

    OntModel saveOntology();

    Individual getIndividualByName(String name);

    List<QuerySolution> getResultSetByQuery(String sparqlQuery);
}
