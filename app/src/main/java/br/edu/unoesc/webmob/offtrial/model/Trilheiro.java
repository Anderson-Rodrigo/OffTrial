package br.edu.unoesc.webmob.offtrial.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Trilheiro {

    @DatabaseField(generatedId = true, width = 10)
    private Integer codTri;
    @DatabaseField(width = 40)
    private String nomTri;
    @DatabaseField(width = 10)
    private Integer idAtri;
    @DatabaseField(foreign = true, foreignColumnName = "codMoto")
    private Moto codMot;
    @DatabaseField(dataType = DataType.BYTE_ARRAY)
    private byte[] foto;

    public Integer getCodTri() {
        return codTri;
    }

    public void setCodTri(Integer codTri) {
        this.codTri = codTri;
    }

    public String getNomTri() {
        return nomTri;
    }

    public void setNomTri(String nomTri) {
        this.nomTri = nomTri;
    }

    public Integer getIdAtri() {
        return idAtri;
    }

    public void setIdAtri(Integer idAtri) {
        this.idAtri = idAtri;
    }

    public Moto getCodMot() {
        return codMot;
    }

    public void setCodMot(Moto codMot) {
        this.codMot = codMot;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Trilheiro() {}
}
