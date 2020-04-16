package dev.oscarreyes.joketeller;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dev.oscarreyes.backend.myApi.MyApi;

public class JokeTask extends AsyncTask<Void, Void, String> {
	private final String regex = "Q:\\s(.+);\\sR:\\s(.+)";

	private static MyApi api;

	private JokeListener callback;

	public JokeTask(JokeListener callback) {
		this.callback = callback;
	}

	@Override
	protected String doInBackground(Void... voids) {
		if (api == null) {
			MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
				new AndroidJsonFactory(), null)
				.setRootUrl("192.168.0.7:8000/_ah/api/")
				.setGoogleClientRequestInitializer(request -> request.setDisableGZipContent(true));

			api = builder.build();
		}

		try {
			return api.getJoke().execute().getData();
		} catch (IOException e) {
			e.printStackTrace();

			return null;
		}
	}

	@Override
	protected void onPostExecute(String s) {
		super.onPostExecute(s);

		if (this.callback != null) {
			final Map<String, String> response = new HashMap<>();
			final Pattern pattern = Pattern.compile(regex);
			final Matcher matcher = pattern.matcher(s);

			response.put("query", matcher.group(1));
			response.put("response", matcher.group(2));

			this.callback.onResponse(response);
		}
	}
}
