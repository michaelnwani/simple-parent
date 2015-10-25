package org.sonatype.mavenbook.weather.yahoo;

import java.io.InputStream;

import junit.framework.TestCase;

import org.sonatype.mavenbook.weather.Weather;
import org.sonatype.mavenbook.weather.YahooParser;

public class YahooParserTest extends TestCase {
	
	public YahooParserTest(String name) {
		super(name);
	}
	
	public void testParser() throws Exception {
		// class loaders act as a layer of abstraction
		// between a resource name and its actual location
		// on disk.
		InputStream nyData = getClass().getClassLoader()
			.getResourceAsStream("ny-weather.xml");
		
		Weather weather = new YahooParser().parse(nyData);
		assertEquals("New York", weather.getCity());
		assertEquals("NY", weather.getRegion());
		assertEquals("US", weather.getCountry());
		assertEquals("39", weather.getTemp());
		assertEquals("Fair", weather.getCondition());
		assertEquals("39", weather.getChill());
		assertEquals("67", weather.getHumidity());
	}
}
