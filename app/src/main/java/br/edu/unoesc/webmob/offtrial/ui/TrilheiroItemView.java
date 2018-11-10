package br.edu.unoesc.webmob.offtrial.ui;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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


    public TrilheiroItemView(Context context) {
        super(context);
    }

    public void bind(Trilheiro t) {
        txtNome.setText(t.getNomTri());
        txtMoto.setText(t.getCodMot().getDesMod() + " - " + t.getCodMot().getCinMot());
        imvFoto.setImageBitmap(BitmapFactory.decodeByteArray(t.getFoto(), 0, t.getFoto().length));
    }
}