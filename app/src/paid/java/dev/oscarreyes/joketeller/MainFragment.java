package dev.oscarreyes.joketeller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {
	private static final String TAG = MainFragment.class.getSimpleName();

	private TextView textJokeQuery;

	public MainFragment() {
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container, false);

		this.loadViews(rootView);

		return rootView;
	}

	private void loadViews(View view) {
		this.textJokeQuery = view.findViewById(R.id.text_joke_query);
	}

	public void setQuery(String query) {
		this.textJokeQuery.setText(query);
	}
}
