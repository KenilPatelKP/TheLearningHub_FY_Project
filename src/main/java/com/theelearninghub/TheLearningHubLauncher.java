package com.theelearninghub;

import com.theelearninghub.jms.JmsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class TheLearningHubLauncher {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(TheLearningHubLauncher.class, args);
		JmsService.jmsTemplate = context.getBean(JmsTemplate.class);
	}
}
