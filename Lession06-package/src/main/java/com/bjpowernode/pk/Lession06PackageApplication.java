package com.bjpowernode.pk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 核心注解功能
 * @SpringBootConfiguration： 包含@Configuration注解的功能
 *    @Configuration： JavaConfig的功能，配置类，结合@Bean能够将对象注入到spring的IOC容器。
 *    有@SpringBootConfiguration标注的类是配置类，Lession06PackageApplication是配置类
 *
 * @EnableAutoConfiguration ： 开启自动配置。 将spring和第三方库中的对象创建好，注入到spring容器
 *                             避免写xml，去掉样例代码。 需要使用的对象，由框架提供。
 *
 * @ComponentScan ： 组件扫描器，<context:component-scan base-package="xxx包"/>
 *        扫描@Controller, @Service, @Repository ,@Component注解， 创建他们的对象注入到容器
 *        springboot约定:启动类，作为扫描包的根（起点）， @ComponentScan扫描com.bjpowernode.pk
 *        和它的子包中所有的类。
 */
@SpringBootApplication
public class Lession06PackageApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lession06PackageApplication.class, args);
	}

}
