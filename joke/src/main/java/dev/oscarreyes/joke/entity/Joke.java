package dev.oscarreyes.joke.entity;

public class Joke {
	private String query;
	private String response;

	public Joke(String query, String response) {
		this.query = query;
		this.response = response;
	}

	public String getQuery() {
		return query;
	}

	public String getResponse() {
		return response;
	}
}
