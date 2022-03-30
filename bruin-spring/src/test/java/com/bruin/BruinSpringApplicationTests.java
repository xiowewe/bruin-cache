package com.bruin;

import com.bruin.service.SpringCacheApi;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class BruinSpringApplicationTests {

	@Autowired
	private SpringCacheApi springCacheApi;

	@Test
	void contextLoads() {
		log.info(".... Fetching books");
		log.info("isbn-1234 -->" + springCacheApi.getByIsbn("isbn-1234"));
		log.info("isbn-4567 -->" + springCacheApi.getByIsbn("isbn-4567"));
		log.info("isbn-1234 -->" + springCacheApi.getByIsbn("isbn-1234"));
		log.info("isbn-4567 -->" + springCacheApi.getByIsbn("isbn-4567"));
		log.info("isbn-1234 -->" + springCacheApi.getByIsbn("isbn-1234"));
		log.info("isbn-1234 -->" + springCacheApi.getByIsbn("isbn-1234"));
	}

}
