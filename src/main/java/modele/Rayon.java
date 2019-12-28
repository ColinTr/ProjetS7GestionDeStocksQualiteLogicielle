package modele;

import javax.persistence.*;

@Entity
public class Rayon {

    //============================= Attributs =============================

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idRayon;

    private String nomRayon;

    //============================= Constructeurs =============================



    //============================= Getters et Setters =============================

}