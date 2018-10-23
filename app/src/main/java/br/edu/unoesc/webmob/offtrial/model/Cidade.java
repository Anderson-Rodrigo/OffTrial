package br.edu.unoesc.webmob.offtrial.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Cidade {

    @DatabaseField(generatedId = true, width = 10)
    private Integer codCid;
    @DatabaseField(canBeNull = false, width = 40)
    private String nomCid;

    public Integer getCodCid() {
        return codCid;
    }

    public void setCodCid(Integer codCid) {
        this.codCid = codCid;
    }

    public String getNomCid() {
        return nomCid;
    }

    public void setNomCid(String nomCid) {
        this.nomCid = nomCid;
    }

    public Cidade() {}
}
