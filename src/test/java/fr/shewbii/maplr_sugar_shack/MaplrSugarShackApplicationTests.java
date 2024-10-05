package fr.shewbii.maplr_sugar_shack;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class MaplrSugarShackApplicationTests {

	@Test
	void contextLoads() {
	}

}
