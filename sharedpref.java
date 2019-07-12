package com.gohool.sharedprefsapp.sharedprefs;

import ...

public class MainActivity extends AppCompatActivity {
  private Button saveButton;
  private TextView result;
  private EditText enterMessage;
  private SharedPreferences myPrefs;
  private static final String PREFS_NAME = "myPrefsFile";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    enterMessage = (EditText) findViewById(R.id.enterName);
    result = (TextView) findviewById(R.id.resultTextView);

    saveButton = (Button) findViewById(R.id.saveButton);
    saveButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        myPrefs = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = myPrefs.edit();

        editor.putString("message", enterMessage.getText().toString());
        editor.commit();
      }
    });

    // Get data back
    SharedPreferences prefs = getSharedPreferences(PREFS_NAME, 0);
    if (prefs.contains("message")) {
      String message = prefs.getString("message", "not found");
      result.setText("Message: " + message);
    }

  }
}