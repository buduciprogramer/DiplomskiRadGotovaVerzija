package org.dentist.dentistapp.entities;

import org.dentist.dentistapp.model.Role;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "stomatolog", schema = "dentist")

public class Stomatolog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private Role role;

    @Column(name = "ime")
    private String ime;

    @Column(name = "prezime")
    private String prezime;

    @Column(name = "datum_diplomiranja")
    private Date datum_diplomiranja;

    @Column(name = "biografija")
    private String biografija;

    @Column(name = "dom_zdravlja")
    private String dom_zdravlja;



    @ManyToMany()
    @JoinTable(
            name = "stomatolog_pacijent",
            joinColumns = @JoinColumn(name = "stomatolog_id"),
            inverseJoinColumns = @JoinColumn(name = "pacijent_id")
    )
    Set<Pacijent> pacijenti;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public Date getDatum_diplomiranja() {
        return datum_diplomiranja;
    }

    public void setDatum_diplomiranja(Date datum_diplomiranja) {
        this.datum_diplomiranja = datum_diplomiranja;
    }

    public String getBiografija() {
        return biografija;
    }

    public void setBiografija(String biografija) {
        this.biografija = biografija;
    }

    public String getDom_zdravlja() {
        return dom_zdravlja;
    }

    public void setDom_zdravlja(String dom_zdravlja) {
        this.dom_zdravlja = dom_zdravlja;
    }

    public Set<Pacijent> getPacijenti() {
        return pacijenti;
    }

    public void setPacijenti(Set<Pacijent> pacijenti) {
        this.pacijenti = pacijenti;
    }

    @Override
    public String toString() {
        return "Stomatolog{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", datum_diplomiranja=" + datum_diplomiranja +
                ", biografija='" + biografija + '\'' +
                ", dom_zdravlja='" + dom_zdravlja + '\'' +
                '}';
    }
}
