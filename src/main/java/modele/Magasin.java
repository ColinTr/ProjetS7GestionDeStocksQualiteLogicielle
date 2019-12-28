package modele;

import javax.persistence.*;

@Entity
public class Magasin {

    //============================= Attributs =============================

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idMagasin;

    private String nomMagasin;

    @OneToOne(mappedBy = "magasinDirige", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Utilisateur chefDeMagasin;

    //============================= Constructeurs =============================



    //============================= Getters et Setters =============================

}