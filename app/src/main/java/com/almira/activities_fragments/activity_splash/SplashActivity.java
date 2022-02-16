package com.almira.activities_fragments.activity_splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.almira.R;
import com.almira.activities_fragments.activity_home.HomeActivity;
import com.almira.activities_fragments.activity_login.LoginActivity;
import com.almira.databinding.ActivitySplashBinding;
import com.almira.language.Language;
import com.almira.models.UserModel;
import com.almira.preferences.Preferences;

import io.paperdb.Paper;

public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding binding;
    private Preferences preferences;
    private UserModel userModel;

    @Override
    protected void attachBaseContext(Context newBase) {
        Paper.init(newBase);
        super.attachBaseContext(Language.updateResources(newBase, Paper.book().read("lang", "ar")));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        preferences = Preferences.getInstance();
        userModel = preferences.getUserData(this);
        new Handler()
                .postDelayed(() -> {

                        Intent intent;

                        if (userModel == null) {
                            intent = new Intent(this, LoginActivity.class);

                        } else {
                            intent = new Intent(this, HomeActivity.class);
                        }
                        startActivity(intent);
                        finish();
                    }
                , 2000);

    }
}
