package br.edu.unoesc.webmob.offtrial.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Moto {

    @DatabaseField(generatedId = true, width = 10)
    private Integer codMoto;
    @DatabaseField(width = 40)
    private String desMod;
    @DatabaseField(width = 40)
    private String desMar;
    @DatabaseField(width = 20)
    private String cinMot;
    @DatabaseField(canBeNull = false, width = 20)
    private String corMot;

    public Integer getCodMoto() {
        return codMoto;
    }

    public void setCodMoto(Integer codMoto) {
        this.codMoto = codMoto;
    }

    public String getDesMod() {
        return desMod;
    }

    public void setDesMod(String desMod) {
        this.desMod = desMod;
    }

    public String getDesMar() {
        return desMar;
    }

    public void setDesMar(String desMar) {
        this.desMar = desMar;
    }

    public String getCinMot() {
        return cinMot;
    }

    public void setCinMot(String cinMot) {
        this.cinMot = cinMot;
    }

    public String getCorMot() {
        return corMot;
    }

    public void setCorMot(String corMot) {
        this.corMot = corMot;
    }
}
