package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * = SpringJUnit4ClassRunner.class
 */
@RunWith(SpringRunner.class)
/**
 * @SpringBootTest tells JUnit to bootstrap the test with Spring Boot capabilities.
 *
 * For now, it’s enough to think of this as the test class equivalent of calling Spring-
 * Application.run() in a main() method.
 */
@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
