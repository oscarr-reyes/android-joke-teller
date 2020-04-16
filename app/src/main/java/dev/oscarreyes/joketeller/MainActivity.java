package dev.oscarreyes.joketeller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

import dev.oscarreyes.jokeanswerdisplayer.AnswerActivity;

public class MainActivity extends AppCompatActivity {
	private static final String TAG = MainActivity.class.getSimpleName();

	private Map<String, String> joke;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onStart() {
		super.onStart();

		JokeTask jokeTask = new JokeTask(data -> {
			this.joke = data;

			MainFragment fragment = (MainFragment) this.getSupportFragmentManager().findFragmentById(R.id.fragment_joke);

			fragment.setQuery(this.joke.get("query"));
		});

		jokeTask.execute();
	}

	public void onJokeButtonClick(View view) {
		Intent intent = new Intent(this, AnswerActivity.class);

		intent.putExtra(AnswerActivity.JOKE_ANSWER_KEY, this.joke.get("response"));

		this.startActivity(intent);
	}
}
