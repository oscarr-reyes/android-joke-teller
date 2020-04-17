package dev.oscarreyes.joketeller;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class JokeTaskTest {
	@Test
	public void testJokeTask() {
		new JokeTask(joke -> {
			String query = joke.get("query");
			String response = joke.get("response");

			Assert.assertFalse(query.isEmpty());
			Assert.assertFalse(response.isEmpty());
		}).execute();
	}
}
