package br.edu.unoesc.webmob.offtrial.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Fullscreen;
import org.androidannotations.annotations.ViewById;

import br.edu.unoesc.webmob.offtrial.R;

@EActivity(R.layout.activity_cadastro_trilheiros)
@Fullscreen
public class CadastroTrilheirosActivity extends AppCompatActivity {


    @ViewById
    EditText edtNome;
    @ViewById
    EditText edtIdade;

    public void cancelar(View v){
        finish();
    }

    public void salvar(View v){

        String strNome = edtNome.getText().toString();
        String strIdade = edtIdade.getText().toString();

        if (strNome != null && strIdade != null &&
                !strNome.trim().equals("") &&
                !strIdade.trim().equals("")) {

            Toast.makeText(this, "Cadastro Efetuado com Sucesso!", Toast.LENGTH_LONG).show();
            edtNome.setText("");
            edtIdade.setText("");
            edtNome.requestFocus();

        }else {
            Toast.makeText(this, "Informe Nome e Idade!", Toast.LENGTH_SHORT).show();
            edtNome.setText("");
            edtIdade.setText("");
            edtNome.requestFocus();
        }
    }
}
