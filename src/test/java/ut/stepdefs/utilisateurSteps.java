package ut.stepdefs;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

import modele.Magasin;
import modele.Rayon;
import modele.TypeDeCompte;
import modele.Utilisateur;
import org.mockito.Mockito;

//@DisplayName("UtilisateurTestClass")
public class utilisateurSteps {

    private String nomDeCompte;
    private String motDePasse;

    private boolean resultat;

    @Given("^j'ai entre ce nom de compte \"([^\"]*)\"$")
    public void jAiEntreCeNomDeCompte(String arg0) throws Throwable {
        nomDeCompte = arg0;
    }

    @When("^je teste \"([^\"]*)\" pour voir si c'est un nom de compte acceptable$")
    public void jeTestePourVoirSiCEstUnNomDeCompteAcceptable(String arg0) throws Throwable {
        resultat = Utilisateur.estCeUnNomDeCompteAcceptable(nomDeCompte);
    }

    @Then("^le resultat devrait etre \"([^\"]*)\" pour nomDeCompteATester$")
    public void leResultatDevraitEtrePourNomDeCompteATester(String arg0) throws Throwable {
        assertEquals(Boolean.parseBoolean(arg0), resultat);
    }

    @Given("^j'ai entre ce mot de passe \"([^\"]*)\"$")
    public void jAiEntreCeMotDePasse(String arg0) throws Throwable {
        motDePasse = arg0;
    }

    @When("^je teste \"([^\"]*)\" pour voir si c'est un mot de passe acceptable$")
    public void jeTestePourVoirSiCEstUnMotDePasseAcceptable(String arg0) throws Throwable {
        resultat = Utilisateur.estCeUnMotDePasseAcceptable(motDePasse);
    }

    @Then("^le resultat devrait etre \"([^\"]*)\" pour motDePasseATester$")
    public void leResultatDevraitEtrePourMotDePasseATester(String arg0) throws Throwable {
        assertEquals(Boolean.parseBoolean(arg0), resultat);
    }


    int idUtilisateur;
    Utilisateur utilisateur;
    String nomCompte = "A";
    String nom = "Doe";
    String prenom = "John";
    String password = "1234";
    TypeDeCompte typeDeCompte = TypeDeCompte.UTILISATEUR;
    boolean restreint = false;
    Magasin magasinDirige = Mockito.mock(Magasin.class);
    Rayon rayonDirige = Mockito.mock(Rayon.class);
    Magasin magasin = Mockito.mock(Magasin.class);


    @Given("Un utilisateur avec des parametres definis")
    public void unUtilisateurAvecDesParametresDefinis() {
        utilisateur = new Utilisateur(nomCompte,nom,prenom,password,typeDeCompte,restreint,magasinDirige,rayonDirige,magasin);

        idUtilisateur = utilisateur.getIdUtilisateur(); //Generer par hibernate
    }

    @Then("les informations recuperees par les getters de l'utilisateur correspondent")
    public void lesInformationsRecupereesParLesGettersDeLUtilisateurCorrespondent() {
        assertEquals(utilisateur.getIdUtilisateur(), idUtilisateur);
        assertEquals(utilisateur.getNomDeCompte(), nomCompte);
        assertEquals(utilisateur.getNom(), nom);
        assertEquals(utilisateur.getPrenom(), prenom);
        assertEquals(utilisateur.getMotDePasse(), password);
        assertEquals(utilisateur.getTypeDeCompte(), typeDeCompte);
        assertEquals(utilisateur.isRestreint(), restreint);
        assertEquals(utilisateur.getMagasinDirige(), magasinDirige);
        assertEquals(utilisateur.getRayonDirige(), rayonDirige);
        assertEquals(utilisateur.getMagasin(), magasin);
    }

    @Given("Un utilisateur par defaut")
    public void unUtilisateurParDefaut() {
        utilisateur = new Utilisateur();
    }

    @When("On change les attributs de l'utilisateur par les nouveaux")
    public void onChangeLesAttributsDeLUtilisateurParLesNouveaux() {
        idUtilisateur = 54;
        utilisateur.setIdUtilisateur(idUtilisateur);
        utilisateur.setNomDeCompte(nomCompte);
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setMotDePasse(password);
        utilisateur.setTypeDeCompte(typeDeCompte);
        utilisateur.setRestreint(restreint);
        utilisateur.setMagasinDirige(magasinDirige);
        utilisateur.setRayonDirige(rayonDirige);
        utilisateur.setMagasin(magasin);
    }
}