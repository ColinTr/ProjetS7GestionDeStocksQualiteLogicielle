package vue;

import controleur.ControleurFenetrePrincipale;
import controleur.UtilisateurDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modele.Utilisateur;

import java.io.IOException;

/**
 * Cette classe fait le lien entre le fichier .fxml et son contrôleur.
 * Elle initialise également les éléments de l'application (utilisateur, magasin à afficher, etc...).
 */
public class FenetrePrincipale extends Application {

    private static Utilisateur utilisateurConnecte;

    public static void main(String[] args) {
        if(args != null && args.length > 0) {
            utilisateurConnecte = UtilisateurDAO.getUtilisateur(Integer.valueOf(args[0]));
        }
        else{
            utilisateurConnecte = null;
        }

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        if(utilisateurConnecte != null){
            ControleurFenetrePrincipale.setUtilisateurConnecte(utilisateurConnecte);
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fenetrePrincipaleFXML.fxml"));
        Pane root = loader.load();
        primaryStage.setTitle("Polystocker");
        primaryStage.setScene(new Scene(root, 1080, 720));

        ControleurFenetrePrincipale c = loader.getController();

        if(utilisateurConnecte != null){
            c.setContenuTableRayons(utilisateurConnecte.getMagasin());
        }

        primaryStage.show();
    }
}