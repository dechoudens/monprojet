
package dechoudens.projetmaven;

import java.util.ArrayList;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Meckanik
 */
public class ResultatsNGTest {
  private Resultats resultats;
  
  @BeforeMethod
  public void setUpMethod() throws Exception {
    resultats = new Resultats();
  }

  @Test
  public void testCreerCoureur() {
    String strLigne = "MARTIN;Pierre;M;26.5";
    Coureur coureurVoulu = new Coureur("MARTIN", "Pierre", 'M', 26.5);
    
    resultats.addEquipe(new Equipe("UNITTEST", 1));
    
    ArrayList<Equipe> equipes = resultats.getEquipes();
    int derniereEquipe = equipes.size() - 1;
    Equipe equipe = equipes.get(derniereEquipe);
    
    resultats.creerCoureur(strLigne);
    Coureur coureurObtenu = (Coureur)equipe.getCoureurs().get(0);
    
    assertEquals(coureurObtenu, coureurVoulu);
  }

  @Test
  public void testCreerEquipe() {
    
    String strLigne = "Heineken;2";
    Equipe equipeVoulue = new Equipe("Heineken", 2);
   
    resultats.creerEquipe(strLigne);
    ArrayList<Equipe> equipes = resultats.getEquipes();
    Equipe equipeObtenue = equipes.get(0);
    
    assertEquals(equipeObtenue, equipeVoulue);
  }
  
}