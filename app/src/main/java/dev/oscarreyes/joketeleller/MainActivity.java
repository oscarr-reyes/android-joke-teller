package dev.oscarreyes.joketeleller;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import dev.oscarreyes.jokeanswerdisplayer.AnswerActivity;

public class MainActivity extends AppCompatActivity {
	private static final String TAG = MainActivity.class.getSimpleName();

	private TextView textJokeQuery;
	private AdView adJoke;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.loadViews();
		this.loadData();
		this.loadAds();
	}

	private void loadViews() {
		this.textJokeQuery = this.findViewById(R.id.text_joke_query);
		this.adJoke = this.findViewById(R.id.ad_joke);
	}

	private void loadData() {
		this.textJokeQuery.setText("Some random joke query");
	}

	private void loadAds() {
		// MobileAds.initialize(this, initializationStatus -> {
		// 	Log.i(TAG, "Ads initialized");
		// });

		AdRequest adRequest = new AdRequest.Builder()
			.build();

		this.adJoke.loadAd(adRequest);
	}

	public void onJokeButtonClick(View view) {
		Intent intent = new Intent(this, AnswerActivity.class);

		intent.putExtra(AnswerActivity.JOKE_ANSWER_KEY, "Some random joke answer");

		this.startActivity(intent);
	}
}
