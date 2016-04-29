
package ch.hesge.projetmaven;


import ch.hesge.projetmaven.domaine.Equipe;
import ch.hesge.projetmaven.metier.ListeEquipe;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Meckanik
 */
public class ListeEquipeTest {
  private ListeEquipe listeEquipe;
  
  @BeforeMethod
  public void setUp() throws Exception {
    listeEquipe = new ListeEquipe();
  }
  
  @Test
  public void getDerniereEquipeTest(){
    Equipe e1 = new Equipe("Guiness", 3);
    Equipe e2 = new Equipe("Heineken", 2);
    Equipe e3 = new Equipe("Cardinal", 4);
    
    listeEquipe.add(e1);
    listeEquipe.add(e2);
    listeEquipe.add(e3);
    
    Equipe equipeObtenue = listeEquipe.getDerniereEquipe();
    
    assertEquals(equipeObtenue, e3);
  }
  
}
