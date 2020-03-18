package com.boo.companydataloader.service;

import com.boo.companydataloader.dto.OrganizationData;
import com.boo.companydataloader.processor.IProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationDataMineService {
    @Autowired
    private List<IProcessor> processorsQueue;

    public OrganizationData search(String inn) {
        OrganizationData organizationData = new OrganizationData(inn);
        processorsQueue.forEach(processor -> processor.doAction(organizationData));
        return organizationData;
    }
}
