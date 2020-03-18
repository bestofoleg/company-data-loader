package com.boo.companydataloader.ontology.system.repository;

import com.boo.companydataloader.ontology.system.connection.data.IConnectionData;

public interface IRepository <DATA> {
    void createConnection(IConnectionData connectionData);

    DATA add(DATA obj);

    DATA remove(DATA obj);
}
