package com.bbpos.tms2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import({BuildProperties.class})
class ApplicationTests {

	@Test()
	void contextLoads() {
		Assertions.assertDoesNotThrow(()-> {
			Application.main(new String[] {});
		});
	}
}
