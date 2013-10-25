package com.example.parseexample;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class MainActivity extends Activity {
	final String TAG = getClass().getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Parse.initialize(this, "kqxcx5eKiv1StMbnN0JYF1189PtTNEIY0hqblKuB",
				"vkl2PL3h6FPnEGmD6lmDZ8arh43gs4iJSRuPK7Uf");

		saveData("Hardik", "26");

		getData();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void saveData(String name, String age) {
		ParseObject testObject = new ParseObject("TestClass");
		testObject.put("name", name);
		testObject.put("age", age);
		testObject.saveInBackground();
	}

	private void getData() {
		ParseQuery<ParseObject> query = ParseQuery.getQuery("TestClass");
		query.findInBackground(new FindCallback<ParseObject>() {

			@Override
			public void done(List<ParseObject> data, ParseException arg1) {
				// TODO Auto-generated method stub
				Log.v(TAG, "TOTal Record Found " + data.size());
			}
		});
	}
}
