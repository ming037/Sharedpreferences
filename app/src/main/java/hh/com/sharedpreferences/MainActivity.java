package hh.com.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_FILE = "hh.com.sharedpreferences.preferences"; //보통 패키지이름 + .preferences
    private static final String KEY_EDITTEXT = "key_edittext";
    private EditText  mEditText;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor; //저장하기 위한 공간
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText)findViewById(R.id.editText);
        mSharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        //첫 번째 인자는 유니크 해야한다.(키 개념), 두 번째 인자는 모드.
        mEditor = mSharedPreferences.edit();


        String editTextString = mSharedPreferences.getString(KEY_EDITTEXT,""); //두 번째 인자는 디폴트
        mEditText.setText(editTextString);
    }

    @Override
    protected void onPause() {
        super.onPause();

        mEditor.putString(KEY_EDITTEXT, mEditText.getText().toString());
        mEditor.apply(); // commit해도 됨
    }
}
