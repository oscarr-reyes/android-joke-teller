package dev.oscarreyes.joke;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dev.oscarreyes.joke.entity.Joke;

public class Joker {
	static List<Joke> jokes = new ArrayList<Joke>() {{
		add(new Joke("What's the best thing about Switzerland?", "I don't know, but the flag is a big plus."));
		add(new Joke("Why do we tell actors \"break a leg\"?", "Because every play has a cast."));
		add(new Joke("Why should you never date tennis players?", "Love means nothing to them."));
		add(new Joke("What happened to the guy who sued over his missing luggage?", "He lost his case."));
		add(new Joke("What kind of jokes are told on a farm?", "Corny ones."));
	}};

	public static Joke getRandomJoke() {
		final Random random = new Random();
		final int position = Math.abs(
			random.nextInt(Joker.jokes.size())
		);

		return Joker.jokes.get(position);
	}
}
