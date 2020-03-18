package com.boo.companydataloader.sparql.query;

public interface Queries {
    String BASE_PREFIXES =
            "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
            "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" +
            "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
            "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" +
                    "PREFIX boo: <file://C:/Users/olega/Desktop/company-data-loader/database.owl/Orgs#>";

    String CHECK_INN_EXISTENCE = BASE_PREFIXES  +
            "SELECT ?INST WHERE { ?INST a boo:INN . FILTER (?INST = boo:%s) }";
}
