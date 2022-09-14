package org.dentist.dentistapp.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Katalog_usluga implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usluge;

    @Column(name = "naziv_usluge")
    private String naziv_usluge;

    @Column(name = "id_dom_zdravlja")
    private String id_dom_zdravlja;

    @ManyToMany(mappedBy = "katalog_usluga")
    Set<Pacijent>pacijent;
    public Set<Pacijent>getPacijent(){
        return pacijent;
    }

    public Katalog_usluga() {
    }

    public int getId_usluge() {
        return id_usluge;
    }

    public void setId_usluge(int id_usluge) {
        this.id_usluge = id_usluge;
    }

    public String getNaziv_usluge() {
        return naziv_usluge;
    }

    public void setNaziv_usluge(String naziv_usluge) {
        this.naziv_usluge = naziv_usluge;
    }

    public String getId_dom_zdravlja() {
        return id_dom_zdravlja;
    }

    public void setId_dom_zdravlja(String id_dom_zdravlja) {
        this.id_dom_zdravlja = id_dom_zdravlja;
    }

    public void setPacijent(Set<Pacijent> pacijent) {
        this.pacijent = pacijent;
    }

    @Override
    public String toString() {
        return "Katalog_usluga{" +
                "id_usluge=" + id_usluge +
                ", naziv_usluge='" + naziv_usluge + '\'' +
                ", id_dom_zdravlja='" + id_dom_zdravlja + '\'' +
                '}';
    }
}