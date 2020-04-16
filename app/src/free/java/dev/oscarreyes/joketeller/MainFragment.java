package dev.oscarreyes.joketeller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainFragment extends Fragment {
	private static final String TAG = MainFragment.class.getSimpleName();

	private AdView adJoke;
	private TextView textJokeQuery;

	public MainFragment() {
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_main, container, false);

		this.loadViews(root);
		this.loadAds();

		return root;
	}

	private void loadViews(View view) {
		this.adJoke = view.findViewById(R.id.ad_joke);
		this.textJokeQuery = view.findViewById(R.id.text_joke_query);
	}

	private void loadAds() {
		AdRequest adRequest = new AdRequest.Builder()
			.build();

		this.adJoke.loadAd(adRequest);
	}

	public void setQuery(String query) {
		this.textJokeQuery.setText(query);
	}
}
