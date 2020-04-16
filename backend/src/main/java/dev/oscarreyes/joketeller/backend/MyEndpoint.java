package dev.oscarreyes.joketeller.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import dev.oscarreyes.joke.Joker;
import dev.oscarreyes.joke.entity.Joke;

/**
 * An endpoint class we are exposing
 */
@Api(
	name = "myApi",
	version = "v1",
	namespace = @ApiNamespace(
		ownerDomain = "backend.builditbigger.gradle.udacity.com",
		ownerName = "backend.builditbigger.gradle.udacity.com",
		packagePath = ""
	)
)
public class MyEndpoint {
	@ApiMethod(name = "getJoke")
	public MyBean getJoke() {
		Joke joke = Joker.getRandomJoke();
		MyBean response = new MyBean();
		String jokeString = String.format("Q: %s; R: %s", joke.getQuery(), joke.getResponse());

		response.setData(jokeString);

		return response;
	}
}
