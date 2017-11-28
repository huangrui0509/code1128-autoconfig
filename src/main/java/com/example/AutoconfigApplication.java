package com.example;

import java.io.IOException;

import javax.activation.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.autoconfig.domain.FooProperties;
import com.example.autoconfig.domain.Person;

@SpringBootApplication
public class AutoconfigApplication {


	
	private static final Logger log = LoggerFactory.getLogger(AutoconfigApplication.class);
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AutoconfigApplication.class, args);
		
		int count = context.getBeanDefinitionCount();
        System.out.println("Beans的个数：" + count);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
               System.out.print(name);
               System.out.print("->");
               Object bean = context.getBean(name);
               System.out.println(bean.getClass().getName());
        }
        
        Person p = new Person("huangrui",22);
        p.setAge(66);
        System.out.println(p);
      //---------------  
        
        System.out.println(context.getBean(Info.class));
		log.debug(context.getId());
		log.debug("Info => {}", context.getBean(Info.class));
       
		//------------
		FooProperties foo = context.getBean(FooProperties.class);
		System.out.println(foo.isEnabled());
		System.out.println(foo.getRemoteAddress());
		System.out.println(foo.getSecurity().getUsername());
		System.out.println(foo.getSecurity().getRoles());
	}
	
	@Bean
	public FooProperties fooProperties() {
		return new FooProperties();
	}
}
