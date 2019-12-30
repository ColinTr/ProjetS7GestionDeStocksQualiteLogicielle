package vue;

import controleur.Connexion;
import controleur.ControleurFenetrePrincipale;
import controleur.UtilisateurDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modele.Magasin;
import modele.Utilisateur;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.io.IOException;

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

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fenetrePrincipaleFXML.fxml"));
        Pane root = loader.load();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1080, 720));

        ControleurFenetrePrincipale c = loader.getController();

        if(utilisateurConnecte != null){
            c.setContenuTable(utilisateurConnecte.getMagasin());
        }

        primaryStage.show();
    }
}