
package ch.hesge.projetmaven.metier;

import ch.hesge.projetmaven.domaine.Equipe;
import ch.hesge.projetmaven.metier.EquipeFactory;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Meckanik
 */
public class EquipeFactoryTest {
  private EquipeFactory equipeFactory;

  @BeforeMethod
  public void setUp() throws Exception {
    equipeFactory = new EquipeFactory();
  }

  @DataProvider(name = "coureurs")
  public Object[][] coureurs() {
    Object[][] coureurs = new Object[3][2];
    coureurs[0] = new Object[]{"Guiness", 3};
    coureurs[1] = new Object[]{"Heineken", 2};
    coureurs[2] = new Object[]{"Cardinal", 4};
    return coureurs;
  }

  @Test(dataProvider = "coureurs")
  public void testCreerCoureur(String nom, int nbCoureur) {
    String ligne = nom + ";" + nbCoureur;
    Equipe equipeObtenu = equipeFactory.creerEquipe(ligne);

    Equipe equipeVoulu = new Equipe(nom, nbCoureur);

    assertEquals(equipeObtenu, equipeVoulu);
  }
}
