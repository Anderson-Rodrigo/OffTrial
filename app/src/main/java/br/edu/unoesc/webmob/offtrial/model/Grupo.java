package br.edu.unoesc.webmob.offtrial.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Grupo {

    @DatabaseField(generatedId = true, width = 10)
    private Integer codGrp;
    @DatabaseField(canBeNull = false, width = 40)
    private String nomGrp;
    @DatabaseField(foreign = true, foreignColumnName = "codCid")
    private Cidade cidade;

    public Integer getCodGrp()
    {
        return codGrp;
    }

    public void setCodGrp(Integer codigo) {
        this.codGrp = codigo;
    }

    public String getNomGrp() {
        return nomGrp;
    }

    public void setNomGrp(String nomGrp) {
        this.nomGrp = nomGrp;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Grupo() {}

    @Override
    public String toString() {
        return getNomGrp();
    }
}
