package fr.shewbii.maplr_sugar_shack;

import org.springframework.boot.SpringApplication;

public class TestMaplrSugarShackApplication {

	public static void main(String[] args) {
		SpringApplication.from(MaplrSugarShackApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
