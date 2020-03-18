package com.boo.companydataloader;

import com.boo.companydataloader.service.DadataService;
import com.kuliginstepan.dadata.client.domain.Suggestion;
import com.kuliginstepan.dadata.client.domain.address.Address;
import com.kuliginstepan.dadata.client.domain.organization.Organization;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;

import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDataLoaderApplicationTests {
	@Test
	public void contextLoads() {}
}

