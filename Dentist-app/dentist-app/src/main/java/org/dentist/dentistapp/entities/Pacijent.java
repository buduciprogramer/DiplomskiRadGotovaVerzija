package org.dentist.dentistapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.dentist.dentistapp.model.Role;

import javax.persistence.*;
import java.awt.print.Book;
import java.io.Serializable;
import java.sql.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


@Entity
@Table(name = "pacijent",schema = "dentist")
public class Pacijent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpacijent;

    @Column(name = "datum_rodjenja")
    private Date datum_rodjenja;

    @Column(name = "stomatolog")
    private String stomatolog;

    @Column(name = "dom_zdravlja")
    private String dom_zdravlja;

    @Column(name = "ime")
    private String ime;

    @Column(name = "prezime")
    private String prezime;

    @Column(name = "role")
    private Role role;

    @ManyToMany(mappedBy = "pacijenti")
    Set<Stomatolog>stomatolozi;
    public Set<Stomatolog>getStomatolozi(){
        return stomatolozi;
    }


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "pacijent_katalog_usluga",
            joinColumns = {@JoinColumn(name = "idpacijent")},
            inverseJoinColumns = {@JoinColumn(name = "id_usluge")}
    )
    private Set<Katalog_usluga> katalog_usluga = new HashSet<>();

    public void setStomatolozi(Set<Stomatolog>stomatolozi){
        this.stomatolozi=stomatolozi;
    }




    public Pacijent() {
    }


    public int getIdpacijent() {
        return idpacijent;
    }

    public void setIdpacijent(int idpacijent) {
        this.idpacijent = idpacijent;
    }

    public Date getDatum_rodjenja() {
        return datum_rodjenja;
    }

    public void setDatum_rodjenja(Date datum_rodjenja) {
        this.datum_rodjenja = datum_rodjenja;
    }

    public String getStomatolog() {
        return stomatolog;
    }

    public void setStomatolog(String stomatolog) {
        this.stomatolog = stomatolog;
    }

    public String getDom_zdravlja() {
        return dom_zdravlja;
    }

    public void setDom_zdravlja(String dom_zdravlja) {
        this.dom_zdravlja = dom_zdravlja;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Katalog_usluga> getKatalog_usluga() {
        return katalog_usluga;
    }

    public void setKatalog_usluga(Set<Katalog_usluga> katalog_usluga) {
        this.katalog_usluga = katalog_usluga;
    }

    @Override
    public String toString() {
        return "Pacijent{" +
                "idpacijent=" + idpacijent +
                ", datum_rodjenja=" + datum_rodjenja +
                ", stomatolog='" + stomatolog + '\'' +
                ", dom_zdravlja='" + dom_zdravlja + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", role=" + role +
                '}';
    }


    }



