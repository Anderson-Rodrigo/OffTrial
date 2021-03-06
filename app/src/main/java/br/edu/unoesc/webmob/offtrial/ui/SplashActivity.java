package br.edu.unoesc.webmob.offtrial.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Fullscreen;
import org.androidannotations.annotations.WindowFeature;

import br.edu.unoesc.webmob.offtrial.R;

@EActivity(R.layout.activity_splash)
@Fullscreen
@WindowFeature(Window.FEATURE_NO_TITLE)
public class SplashActivity extends AppCompatActivity {


    @AfterViews
    @Background(delay = 3000)
    public void abrirLogin() {
        Intent itLogin = new Intent(
                SplashActivity.this,
                LoginActivity_.class
        );
        startActivity(itLogin);
        finish();
    }
}
