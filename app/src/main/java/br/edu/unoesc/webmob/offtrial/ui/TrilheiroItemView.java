package br.edu.unoesc.webmob.offtrial.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import br.edu.unoesc.webmob.offtrial.R;
import br.edu.unoesc.webmob.offtrial.model.Trilheiro;

@EViewGroup(R.layout.lista_trilheiros)
public class TrilheiroItemView extends LinearLayout {

    @ViewById
    TextView txtNome;

    @ViewById
    TextView txtMoto;

    @ViewById
    ImageView imvFoto;

    Trilheiro trilheiro;

    public TrilheiroItemView(Context context) {
        super(context);
    }

    @Click(R.id.imvEditar)
    public void editar(){
        Toast.makeText(getContext(), "Editar: " + trilheiro.getNomTri(), Toast.LENGTH_SHORT).show();
    }

    @Click(R.id.imvExcluir)
    public void excluir(){
        //Toast.makeText(getContext(), "Excluir: " + trilheiro.getNomTri(), Toast.LENGTH_SHORT).show();
        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());
        dialogo.setTitle("Exclusão");
        dialogo.setMessage("Deseja Realmente Excluir?? - " + trilheiro.getNomTri());
        dialogo.setCancelable(false);
        dialogo.setNegativeButton("Não", null);
        dialogo.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //aqui implementar

                    }
                }
        );
        dialogo.show();
    }

    public void bind(Trilheiro t) {
        trilheiro = t;
        txtNome.setText(t.getNomTri());
        txtMoto.setText(t.getCodMot().getDesMod() + " - " + t.getCodMot().getCinMot());
        imvFoto.setImageBitmap(BitmapFactory.decodeByteArray(t.getFoto(), 0, t.getFoto().length));
    }

}