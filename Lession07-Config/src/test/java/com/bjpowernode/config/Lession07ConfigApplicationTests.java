package com.bjpowernode.config;

import com.bjpowernode.config.pk1.SomeService;
import com.bjpowernode.config.pk2.ReadConfig;
import com.bjpowernode.config.pk4.MultiEnvService;
import com.bjpowernode.config.pk5.AppBean;
import com.bjpowernode.config.pk6.NestAppBean;
import com.bjpowernode.config.pk7.ApplicationConfig;
import com.bjpowernode.config.pk8.CollectionConfig;
import com.bjpowernode.config.pk9.Group;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lession07ConfigApplicationTests {
	@Autowired
	SomeService someService;

	@Autowired
	ReadConfig readConfig;

	@Autowired
	MultiEnvService multiEnvService;

	@Autowired
	AppBean appBean;

	@Autowired
	NestAppBean nestAppBean;

	@Autowired
	ApplicationConfig config;

	@Autowired
	CollectionConfig collectionConfig;

	@Test
	void test01() {
		someService.printValue();
	}

	@Test
	void test02(){
		readConfig.print();
	}

	@Test
	void test04(){multiEnvService.print();}

	@Test
	void test05(){
		System.out.println("appBean="+appBean);
	}

	@Test
	void test06(){
		System.out.println("nestAppBean="+nestAppBean);
	}

	@Test
	void test07(){
		System.out.println("security:"+config.createSecurity());
	}

	@Test
	void test08(){
		System.out.println("collectionConfig:"+collectionConfig);
	}

	@Autowired
	Group group;
	@Test
	void test09(){
		System.out.println("group"+group);
	}
}
