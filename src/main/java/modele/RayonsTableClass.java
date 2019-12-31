package modele;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class RayonsTableClass {

    public SimpleStringProperty nom;
    public SimpleStringProperty chef;
    public SimpleIntegerProperty nombre;

    public String getNom() {
        return nom.get();
    }

    public String getChef() {
        return chef.get();
    }

    public int getNombre() {
        return nombre.get();
    }

    public RayonsTableClass(String nom, String chef, int nombre) {
        this.nom = new SimpleStringProperty(nom);
        this.chef = new SimpleStringProperty(chef);
        this.nombre = new SimpleIntegerProperty(nombre);
    }
}