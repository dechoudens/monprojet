package ch.hesge.projetmaven;

import ch.hesge.projetmaven.domaine.Coureur;
import ch.hesge.projetmaven.metier.CoureurFactory;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Antoine de Choudens
 */
public class CoureurFactoryTest {

  private CoureurFactory coureurFactory;

  @BeforeMethod
  public void setUp() throws Exception {
    coureurFactory = new CoureurFactory();
  }

  @DataProvider(name = "coureurs")
  public Object[][] coureurs() {
    Object[][] coureurs = new Object[3][4];
    coureurs[0] = new Object[]{"DUPONT", "Jean", 'M', 32.1};
    coureurs[1] = new Object[]{"ATAN", "Charles", 'M', 27.4};
    coureurs[2] = new Object[]{"MARQUIS", "Claire", 'F', 29.4};
    return coureurs;
  }

  @Test(dataProvider = "coureurs")
  public void testCreerCoureur(String nom, String prenom, char sexe, double temps) {
    String ligne = nom + ";" + prenom + ";" + sexe + ";" + temps;
    Coureur coureurObtenu = coureurFactory.creerCoureur(ligne);

    Coureur coureurVoulu = new Coureur(nom, prenom, sexe, temps);

    assertEquals(coureurVoulu, coureurObtenu);
  }
}
