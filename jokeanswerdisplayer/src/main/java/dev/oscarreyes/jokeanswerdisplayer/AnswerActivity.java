package dev.oscarreyes.jokeanswerdisplayer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AnswerActivity extends AppCompatActivity {
	public static final String JOKE_ANSWER_KEY = "joke-answer";

	private TextView textJokeAnswer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_answer);

		this.loadViews();
		this.loadIntent();
	}

	private void loadViews() {
		this.textJokeAnswer = this.findViewById(R.id.text_joke_answer);
	}

	private void loadIntent() {
		Intent intent = this.getIntent();

		if (intent == null || !intent.hasExtra(JOKE_ANSWER_KEY)) {
			this.textJokeAnswer.setText(this.getString(R.string.joke_answer_not_found));
		} else {
			final String answer = intent.getStringExtra(JOKE_ANSWER_KEY);

			if (answer.isEmpty()) {
				this.textJokeAnswer.setText(this.getString(R.string.joke_answer_empty));
			} else {
				this.textJokeAnswer.setText(answer);
			}
		}
	}
}
