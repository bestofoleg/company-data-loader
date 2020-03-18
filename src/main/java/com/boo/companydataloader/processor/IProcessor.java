package com.boo.companydataloader.processor;

import com.boo.companydataloader.dto.OrganizationData;

public interface IProcessor {
    void doAction(OrganizationData data);
}
