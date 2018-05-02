package com.imooc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SellApplicationTests {

//	private final Logger logger = LoggerFactory.getLogger(SellApplicationTests.class);

	@Test
	public void test1(){
		String username = "immoc";
		String password = "1234";
		log.debug("debug......");
		log.info("username:{},password:{}",username,password);
		log.error("error12......");
		log.warn("warn......");
	}

}
