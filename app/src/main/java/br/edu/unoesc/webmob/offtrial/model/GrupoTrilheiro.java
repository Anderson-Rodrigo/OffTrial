package br.edu.unoesc.webmob.offtrial.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable
public class GrupoTrilheiro {

    @DatabaseField(generatedId = true, width = 10)
    private Integer codGri;
    @DatabaseField(foreign = true, foreignColumnName = "codGrp")
    private Grupo codGrp;
    @DatabaseField(foreign = true, foreignColumnName = "codTri")
    private Trilheiro codTri;
    @DatabaseField
    private Date dataCadastro;

    public Integer getCodGri() {
        return codGri;
    }

    public void setCodGri(Integer codGri) {
        this.codGri = codGri;
    }

    public Grupo getCodGrp() {
        return codGrp;
    }

    public void setCodGrp(Grupo codGrp) {
        this.codGrp = codGrp;
    }

    public Trilheiro getCodTri() {
        return codTri;
    }

    public void setCodTri(Trilheiro codTri) {
        this.codTri = codTri;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public GrupoTrilheiro() {}

}
