package modele;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Magasin {

    //============================= Attributs =============================

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idMagasin;

    private String nomMagasin;

    @OneToOne(mappedBy = "magasinDirige", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Utilisateur chefDeMagasin;

    @OneToMany(mappedBy = "magasin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rayon> listeRayons;

    @OneToMany(mappedBy = "magasin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Utilisateur> listeEmployes;
    //============================= Méthodes =============================

    /**
     * Méthode permettant d'ajouter un nouveau rayon au magasin.
     * @param r : un rayon.
     */
    public void ajouterRayon(Rayon r){
        if(listeRayons == null){
            listeRayons = new ArrayList<>();
        }
        listeRayons.add(r);
    }

    @Override
    public String toString(){
        return nomMagasin;
    }

    //============================= Constructeurs =============================

    public Magasin(String nomMagasin, Utilisateur chefDeMagasin, List<Rayon> listeRayons, List<Utilisateur> listeEmployes) {
        this.nomMagasin = nomMagasin;
        this.chefDeMagasin = chefDeMagasin;
        this.listeRayons = listeRayons;
        this.listeEmployes = listeEmployes;
    }

    public Magasin(){
    }

    //============================= Getters et Setters =============================

    public int getIdMagasin() {
        return idMagasin;
    }

    public void setIdMagasin(int idMagasin) {
        this.idMagasin = idMagasin;
    }

    public String getNomMagasin() {
        return nomMagasin;
    }

    public void setNomMagasin(String nomMagasin) {
        this.nomMagasin = nomMagasin;
    }

    public Utilisateur getChefDeMagasin() {
        return chefDeMagasin;
    }

    public void setChefDeMagasin(Utilisateur chefDeMagasin) {
        this.chefDeMagasin = chefDeMagasin;
    }

    public List<Rayon> getListeRayons() {
        return listeRayons;
    }

    public void setListeRayons(List<Rayon> listeRayons) {
        this.listeRayons = listeRayons;
    }

    public List<Utilisateur> getListeEmployes() {
        return listeEmployes;
    }

    public void setListeEmployes(List<Utilisateur> listeEmployes) {
        this.listeEmployes = listeEmployes;
    }
}