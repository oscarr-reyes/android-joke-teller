package dev.oscarreyes.joketeleller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainFragment extends Fragment {
	private static final String TAG = MainFragment.class.getSimpleName();

	private AdView adJoke;

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
	}

	private void loadAds() {
		AdRequest adRequest = new AdRequest.Builder()
			.build();

		this.adJoke.loadAd(adRequest);
	}
}
