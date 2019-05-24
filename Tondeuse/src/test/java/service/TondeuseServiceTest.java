package test.java.service;

import org.junit.Assert;
import org.junit.Test;

import main.java.service.TondeuseService;

public class TondeuseServiceTest {
	
	TondeuseService service = new TondeuseService();

	@Test
	public void executionProgrammeeTest() {
		String url = "D:/Profiles/regarip/Desktop/Temp/Tondeuse/src/main/resources/input.txt";
		service.executionProgramme(url);
	}
	
	@Test
	public void orienterTondeuseTest() {
		String result = service.orienterTondeuse('D', "N");
		Assert.assertTrue("E".equals(result));
		result = service.orienterTondeuse('G', "N");
		Assert.assertTrue("W".equals(result));
	}
	
	@Test
	public void deplacerTondeuseAxeXTest() {
		int result = service.deplacerTondeuseAxeX(0, "W", 5);
		Assert.assertTrue(result == 0);
		result = service.deplacerTondeuseAxeX(0, "E", 5);
		Assert.assertTrue(result == 1);
		result = service.deplacerTondeuseAxeX(5, "E", 5);
		Assert.assertTrue(result == 5);
	}
	
	@Test
	public void deplacerTondeuseAxeYTest() {
		int result = service.deplacerTondeuseAxeX(0, "S", 5);
		Assert.assertTrue(result == 0);
		result = service.deplacerTondeuseAxeY(0, "N", 5);
		Assert.assertTrue(result == 1);
		result = service.deplacerTondeuseAxeY(5, "N", 5);
		Assert.assertTrue(result == 5);
	}
}
