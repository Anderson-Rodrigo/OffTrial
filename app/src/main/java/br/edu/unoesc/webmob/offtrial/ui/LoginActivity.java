package br.edu.unoesc.webmob.offtrial.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Fullscreen;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;

import java.sql.SQLException;

import br.edu.unoesc.webmob.offtrial.R;
import br.edu.unoesc.webmob.offtrial.helper.DatabaseHelper;
import br.edu.unoesc.webmob.offtrial.model.Usuario;

@EActivity(R.layout.activity_login)
@Fullscreen
@WindowFeature(Window.FEATURE_NO_TITLE)
public class LoginActivity extends AppCompatActivity {

    @Bean
    DatabaseHelper dh;

    @ViewById
    EditText edtLogin;
    @ViewById
    EditText edtSenha;

    public void fechar(View v) {
        finish();
        System.exit(0);
    }

    public void login(View v) {
        String strLogin = edtLogin.getText().toString();
        String strSenha = edtSenha.getText().toString();

        if (strLogin != null && strSenha != null &&
                !strLogin.trim().equals("") &&
                !strSenha.trim().equals("")) {

            Usuario u = dh.validaLogin(strLogin, strSenha);
            if (u != null) {
                Intent intPrincipal = new Intent(this, PrincipalActivity_.class);
                //passando parametro para outra tela
                //utiliza hashmap
                intPrincipal.putExtra("usuario", u);
                startActivity(intPrincipal);
                finish();
            }
        } else {
            Toast.makeText(this, "Usuaário e/ou senha Inválidos!", Toast.LENGTH_LONG).show();
            edtLogin.setText("");
            edtSenha.setText("");
            edtLogin.requestFocus();
        }
    }
}
