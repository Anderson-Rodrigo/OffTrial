package br.edu.unoesc.webmob.offtrial.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Fullscreen;
import org.androidannotations.annotations.LongClick;
import org.androidannotations.annotations.OnActivityResult;
import org.androidannotations.annotations.ViewById;

import java.io.ByteArrayOutputStream;
import java.sql.SQLException;
import java.util.Date;

import br.edu.unoesc.webmob.offtrial.R;
import br.edu.unoesc.webmob.offtrial.helper.DatabaseHelper;
import br.edu.unoesc.webmob.offtrial.model.Grupo;
import br.edu.unoesc.webmob.offtrial.model.GrupoTrilheiro;
import br.edu.unoesc.webmob.offtrial.model.Moto;
import br.edu.unoesc.webmob.offtrial.model.Trilheiro;

@EActivity(R.layout.activity_cadastro_trilheiros)
@Fullscreen
public class CadastroTrilheirosActivity extends AppCompatActivity {

    @ViewById
    ImageView imvFoto;
    @ViewById
    EditText edtNome;
    @ViewById
    EditText edtIdade;
    @ViewById
    Spinner spnMotos;
    @ViewById
    Spinner spnGrupos;
    @Bean
    DatabaseHelper dh;

    @AfterViews
    public void inicializar() {
        try {
            ArrayAdapter<Moto> motos = new ArrayAdapter<Moto>(this, android.R.layout.simple_spinner_item,
                    dh.getMotoDao().queryForAll());
            //vincula o adapter ao spiner
            spnMotos.setAdapter(motos);

            ArrayAdapter<Grupo> grupos = new ArrayAdapter<Grupo>(this, android.R.layout.simple_spinner_item,
                    dh.getGrupoDao().queryForAll());
            //vincula o adapter ao spiner
            spnGrupos.setAdapter(grupos);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void cancelar(View v){
        finish();
    }

    public void salvar(View v){

        try {
        Trilheiro t = new Trilheiro();
        t.setNomTri(edtNome.getText().toString());
        t.setIdAtri(Integer.parseInt(edtIdade.getText().toString()));
        t.setCodMot((Moto)spnMotos.getSelectedItem());

        Bitmap bitmap = ((BitmapDrawable) imvFoto.getDrawable()).getBitmap();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);

        t.setFoto(baos.toByteArray());
        dh.getTrilheiroDao().create(t);
        GrupoTrilheiro gt = new GrupoTrilheiro();

        gt.setCodTri(t);
        gt.setCodGrp((Grupo)spnGrupos.getSelectedItem());
        gt.setDataCadastro(new Date());
        dh.getGrupoTrilheiroDao().create(gt);
        finish();
        }catch (Exception e){
            e.printStackTrace();
        }

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

    @LongClick(R.id.imvFoto)
    public void capturarFoto() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//aqui poderia ser usado par abri uma activity criada por mim
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, 100);
        }
    }

    @OnActivityResult(100)
    void onResult(int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imvFoto.setImageBitmap(imageBitmap);
        }
    }
}
