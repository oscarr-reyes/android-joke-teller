package dev.oscarreyes.joketeleller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import dev.oscarreyes.jokeanswerdisplayer.AnswerActivity;

public class MainActivity extends AppCompatActivity {
	private TextView textJokeQuery;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.loadViews();
		this.loadData();
	}

	private void loadViews() {
		this.textJokeQuery = this.findViewById(R.id.text_joke_query);
	}

	private void loadData() {
		this.textJokeQuery.setText("Some random joke query");
	}

	public void onJokeButtonClick(View view) {
		Intent intent = new Intent(this, AnswerActivity.class);

		intent.putExtra(AnswerActivity.JOKE_ANSWER_KEY, "Some random joke answer");

		this.startActivity(intent);
	}
}
