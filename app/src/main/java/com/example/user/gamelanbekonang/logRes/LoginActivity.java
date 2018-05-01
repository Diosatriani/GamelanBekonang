package com.example.user.gamelanbekonang.logRes;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.gamelanbekonang.MainActivity;
import com.example.user.gamelanbekonang.R;
import com.example.user.gamelanbekonang.api.BaseApiService;
import com.example.user.gamelanbekonang.api.UtilsApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private TextView coba;
    private Button btnLogin;
    private Button btnRegister;
    private CheckBox c;
    private ProgressDialog loading;
    private String TAG="";
    private Context mContext;
    private BaseApiService mApiService;
    private Toolbar mActionToolbar;
    SharedPreferences sharedpreferences;
    public static final  String value = "key";
    Boolean session = false;
    private String id,image,name,email,notelp;
    public static final String session_status = "session_status";
    public static final String my_shared_preferences = "my_shared_preference";
    SharedPreferences sharedPreferences;
    private int i;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mActionToolbar = (Toolbar) findViewById(R.id.tabs);
        setSupportActionBar(mActionToolbar);
        getSupportActionBar().setTitle("LOGIN");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        mContext = this;
        mApiService = UtilsApi.getAPIService(); // meng-init yang ada di package apihelper
        initComponents();
    }



    private void initComponents() {
        sharedpreferences = getSharedPreferences(my_shared_preferences, Context.MODE_PRIVATE);
        session = sharedpreferences.getBoolean(session_status, false);
        id = sharedpreferences.getString("id",null);
        image = sharedpreferences.getString("iamge", null);
        name = sharedpreferences.getString("name", null);
        email = sharedpreferences.getString("email", null);
        notelp = sharedpreferences.getString("notelp",null);
        int i = sharedpreferences.getInt(value, 0);

        coba = (TextView) findViewById(R.id.coba);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        c = (CheckBox) findViewById(R.id.checkBox);
        c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked){
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
        btnRegister = (Button) findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
                requestLogin();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, RegisterActivity.class));
            }
        });
    }




    private void requestLogin() {
        mApiService.loginRequest(etEmail.getText().toString(), etPassword.getText().toString())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            loading.dismiss();
                            try {
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                if (!jsonRESULTS.getString("msg").equals("404")){
                                    // Jika login berhasil maka data nama yang ada di response API
                                    // akan diparsing ke activity selanjutnya.
                                    String success =  jsonRESULTS.getString("msg");
                                    Toast.makeText(mContext, success, Toast.LENGTH_SHORT).show();
                                    String id = jsonRESULTS.getJSONObject("user").getString("id");
                                    String image = jsonRESULTS.getJSONObject("user").getString("image");
                                    String nama = jsonRESULTS.getJSONObject("user").getString("name");
                                    String email = jsonRESULTS.getJSONObject("user").getString("email");
                                    String notelp = jsonRESULTS.getJSONObject("user").getString("notelp");
                                    Log.d(TAG, "kkkkkkkkkkkkkk: "+id+image+nama+email+notelp);
                                    Intent intent = new Intent(mContext, MainActivity.class);

                                    SharedPreferences sharedPreferences = PreferenceManager
                                            .getDefaultSharedPreferences(getApplicationContext());
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putBoolean(session_status, true);
                                    editor.putString("id", id);
                                    editor.putString("image", image);
                                    editor.putString("name", nama);
                                    editor.putString("email", email);
                                    editor.putString("notelp", notelp);
                                    editor.commit();
//                                    intent.putExtra("result_nama", nama);
                                    startActivity(intent);

//                                    Log.d("hh", "uuuuuu"+nama );
                                } else {
                                    // Jika login gagal
                                    String error_message = jsonRESULTS.getString("404");
                                    Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();

                                    Log.d(TAG, "onResponse: "+error_message);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();

                                Toast.makeText(mContext, "Login Gagal", Toast.LENGTH_SHORT).show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            loading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.toString());
                        loading.dismiss();
                    }
                });

    }

    //button back toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()== android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
