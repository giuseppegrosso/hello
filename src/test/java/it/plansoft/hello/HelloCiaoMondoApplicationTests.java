package it.plansoft.hello;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
class HelloCiaoMondoApplicationTests {

	@Test
	void lambdaExpressions() {
		assertTrue(Stream.of(1, 2, 3)
				.mapToInt(i -> i)
				.sum() > 5, () -> "Sum should be greater than 5");

		log.info("ok somma torna");
	}

	@Test
	void groupAssertions() {
		int[] numbers = {0, 1, 2, 3, 4};
		assertAll("numbers",
				() -> assertEquals(numbers[0], 0),
				() -> assertEquals(numbers[3], 3),
				() -> assertEquals(numbers[4], 4)
		);
	}

}
