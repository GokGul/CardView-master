package domain.fake.cardview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class Login extends AppCompatActivity {
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    public void loginUser(View view){
        String user =  username.getText().toString();
        String pwd =  password.getText().toString();

        ParseUser.logInInBackground(user, pwd, new LogInCallback() {
            public void done(ParseUser user, ParseException e) {
                if (user != null) {
                    Intent main = new Intent(Login.this, MainActivity.class);
                    startActivity(main);
                } else {
                    Toast.makeText(Login.this, "Login failed..", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void register(View view){
        Intent register = new Intent(Login.this, Register.class);
        startActivity(register);
    }

    public void initViews(){
        username = (EditText) findViewById(R.id.txt_username);
        password = (EditText) findViewById(R.id.txt_password);
    }
}
