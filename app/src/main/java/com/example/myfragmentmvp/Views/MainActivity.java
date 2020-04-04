package com.example.myfragmentmvp.Views;

import androidx.appcompat.app.AppCompatActivity;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.entity.ByteArrayEntity;
import cz.msebera.android.httpclient.message.BasicHeader;
import cz.msebera.android.httpclient.protocol.HTTP;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myfragmentmvp.Enums.Enums;
import com.example.myfragmentmvp.Helpers.Helpers;
import com.example.myfragmentmvp.HelpersServices.HelpersService;
import com.example.myfragmentmvp.Models.Login;
import com.example.myfragmentmvp.Presenters.LoginPresenter;
import com.example.myfragmentmvp.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity implements LoginPresenter.View {
    EditText usuario;
    EditText password;
    Button entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = (EditText) findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);
        entrar = (Button)findViewById(R.id.btnentrar);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entrar();
            }
        });
    }

    @Override
    public void entrar(){
        EditText editText = findViewById(R.id.editText);
        EditText editText2 = findViewById(R.id.editText2);
        Login.IniciarSesión(editText.getText().toString(),editText2.getText().toString(),this);

    }
}
