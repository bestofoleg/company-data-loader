package com.boo.companydataloader.config;

import com.boo.companydataloader.processor.AddOrganizationAddressToDBProcessor;
import com.boo.companydataloader.processor.AddOrganizationToDBIfNotExistsProcessor;
import com.boo.companydataloader.processor.IProcessor;
import com.boo.companydataloader.processor.SetOrganizationNameProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ProcessorsConfiguration {
    @Autowired
    private SetOrganizationNameProcessor setOrganizationNameProcessor;

    @Autowired
    private AddOrganizationToDBIfNotExistsProcessor addOrganizationToDBIfNotExistsProcessor;

    @Autowired
    private AddOrganizationAddressToDBProcessor addOrganizationAddressToDBProcessor;

    @Bean
    public List<IProcessor> getProcessorsQueue() {
        List<IProcessor> queue = new ArrayList<>();
        queue.add(addOrganizationToDBIfNotExistsProcessor);
        queue.add(setOrganizationNameProcessor);
        queue.add(addOrganizationAddressToDBProcessor);
        return queue;
    }
}
