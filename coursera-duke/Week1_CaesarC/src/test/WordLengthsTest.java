package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.duke.FileResource;
import junit.framework.Assert;
import week1.WordLengths;


class WordLengthsTest {

	@Test
	void testCountWordLengths() {
		fail("Not yet implemented");
	}

	@Test
	void testIndexOfMax() {
		fail("Not yet implemented");
	}

	@Test
	void testCountWords() {
		int is;
		int shouldBe;
		FileResource fr = new FileResource("src/smallHamlet.txt");
		shouldBe = 5;
		WordLengths wl = new WordLengths();
		is = WordLengths.countWords(fr);
		Assert.assertEquals(shouldBe, is);
	}

	@Test
	void testTestCountWordLengths() {
		fail("Not yet implemented");
	}

}
