package dev.oscarreyes.joketeleller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import dev.oscarreyes.jokeanswerdisplayer.AnswerActivity;

public class MainActivity extends AppCompatActivity {
	private static final String TAG = MainFragment.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
	}

	public void onJokeButtonClick(View view) {
		Intent intent = new Intent(this, AnswerActivity.class);

		intent.putExtra(AnswerActivity.JOKE_ANSWER_KEY, "Some random joke answer");

		this.startActivity(intent);
	}
}
