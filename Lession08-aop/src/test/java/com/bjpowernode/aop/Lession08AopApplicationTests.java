package com.bjpowernode.aop;

import com.bjpowernode.aop.service.SomeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lession08AopApplicationTests {
	@Autowired
	private SomeService someService;

	@Test
	void testLog() {
		someService.query(1001);
		someService.save("anze",17);
	}

}
