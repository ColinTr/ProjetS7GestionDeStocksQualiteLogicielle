package modele.tables;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class RayonsTableClass {

    private final SimpleStringProperty nom;
    private final SimpleStringProperty chef;
    private final SimpleIntegerProperty nombre;
    private final int idRayon;

    public String getNom() {
        return nom.get();
    }

    public String getChef() {
        return chef.get();
    }

    public int getNombre() {
        return nombre.get();
    }

    public int getIdRayon(){ return idRayon; }

    public RayonsTableClass(String nom, String chef, int nombre, int idRayon) {
        this.nom = new SimpleStringProperty(nom);
        this.chef = new SimpleStringProperty(chef);
        this.nombre = new SimpleIntegerProperty(nombre);
        this.idRayon = idRayon;
    }
}