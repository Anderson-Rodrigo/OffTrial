package br.edu.unoesc.webmob.offtrial.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Usuario {

    @DatabaseField(generatedId = true, width = 10)
    private Integer codUsu;
    @DatabaseField(canBeNull = false, width = 80)
    private String emaUsu;
    @DatabaseField(width = 32)
    private String senUsu;

    public Integer getCodUsu() {
        return codUsu;
    }

    public void setCodUsu(Integer codUsu) {
        this.codUsu = codUsu;
    }

    public String getEmaUsu() {
        return emaUsu;
    }

    public void setEmaUsu(String emaUsu) {
        this.emaUsu = emaUsu;
    }

    public String getSenUsu() {
        return senUsu;
    }

    public void setSenUsu(String senUsu) {
        this.senUsu = senUsu;
    }

    public Usuario() {}
}
