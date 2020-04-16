package dev.oscarreyes.joketeller;

import java.util.Map;

public interface JokeListener {
	void onResponse(Map<String, String> joke);
}
