package com.iab.bootdrools.configuration;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.iab.bootdrools.service.DownloadServiceImpl;

@Configuration
public class DroolsConfiguration {

	@Autowired DownloadServiceImpl downloadServiceImpl;
	private final KieServices kieServices = KieServices.Factory.get();

//	@Bean
//	public KieContainer kieContainer() {
//		KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
//		kieFileSystem.write(ResourceFactory.newClassPathResource("complaince_rules.xlsx"));
//		
//		KieBuilder kb = kieServices.newKieBuilder(kieFileSystem);
//		kb.buildAll();
//		KieModule kieModule = kb.getKieModule();
//		return kieServices.newKieContainer(kieModule.getReleaseId());
//	}
//	
	@Bean
	public KieContainer kieContainer() {
		KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
		kieFileSystem.write(ResourceFactory.newClassPathResource("complaince_rules_geometryChange.xlsx"));
		
		KieBuilder kb = kieServices.newKieBuilder(kieFileSystem);
		kb.buildAll();
		KieModule kieModule = kb.getKieModule();
		return kieServices.newKieContainer(kieModule.getReleaseId());
	}
	
	
}
