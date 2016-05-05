package ch.hesge.projetmaven.metier;

import ch.hesge.projetmaven.base.Fichier;
import ch.hesge.projetmaven.domaine.Equipe;
import ch.hesge.projetmaven.metier.ListeEquipes;
import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Meckanik
 */
public class ListeEquipeTest {

  private ListeEquipes listeEquipe;

  @BeforeMethod
  public void setUp() throws Exception {
    listeEquipe = new ListeEquipes();
  }

  @Test
  public void isEmptyTestFalse() {
    List equipe = listeEquipe.getListe();

    if (equipe.size() > 0) {
      assertFalse(listeEquipe.isEmpty());
    }
  }
  
  @Test
  public void isEmptyTestTrue() {
    listeEquipe.setListe(new ArrayList());
    
    assertTrue(listeEquipe.isEmpty());
  }

}
