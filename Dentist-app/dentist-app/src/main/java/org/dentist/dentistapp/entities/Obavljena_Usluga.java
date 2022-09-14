package org.dentist.dentistapp.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


@Entity
@Table(name = "obavljena_usluga",schema = "dentist")
public class Obavljena_Usluga implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usluga;

    @Column(name = "vrsta_usluge")
    private String vrsta_usluge;

    @Column(name = "stomatolog")
    private String stomatolog;

    @Column(name = "pacijent")
    private String pacijent;

    @Column(name = "datum_usluge")
    private Date datum_usluge;

    @Column(name = "dom_zdravlja")
    private String dom_zdravlja;

    @Column(name = "cijena_usluge")
    private String cijena_usluge;

    public int getId_usluga() {
        return id_usluga;
    }

    public void setId_usluga(int id_usluga) {
        this.id_usluga = id_usluga;
    }

    public String getVrsta_usluge() {
        return vrsta_usluge;
    }

    public void setVrsta_usluge(String vrsta_usluge) {
        this.vrsta_usluge = vrsta_usluge;
    }

    public String getStomatolog() {
        return stomatolog;
    }

    public void setStomatolog(String stomatolog) {
        this.stomatolog = stomatolog;
    }

    public String getPacijent() {
        return pacijent;
    }

    public void setPacijent(String pacijent) {
        this.pacijent = pacijent;
    }

    public Date getDatum_usluge() {
        return datum_usluge;
    }

    public void setDatum_usluge(Date datum_usluge) {
        this.datum_usluge = datum_usluge;
    }

    public String getDom_zdravlja() {
        return dom_zdravlja;
    }

    public void setDom_zdravlja(String dom_zdravlja) {
        this.dom_zdravlja = dom_zdravlja;
    }

    public String getCijena_usluge() {
        return cijena_usluge;
    }

    public void setCijena_usluge(String cijena_usluge) {
        this.cijena_usluge = cijena_usluge;
    }


    public Obavljena_Usluga() {

    }


    @Override
    public String toString() {
        return "Obavljena_Usluga{" +
                "id_usluga=" + id_usluga +
                ", vrsta_usluge='" + vrsta_usluge + '\'' +
                ", stomatolog='" + stomatolog + '\'' +
                ", pacijent='" + pacijent + '\'' +
                ", datum_usluge=" + datum_usluge +
                ", dom_zdravlja='" + dom_zdravlja + '\'' +
                ", cijena_usluge='" + cijena_usluge + '\'' +
                '}';
    }
}

