package ch.hesge.projetmaven.metier;

import ch.hesge.projetmaven.base.EquipeDao;
import ch.hesge.projetmaven.base.Fichier;
import ch.hesge.projetmaven.domaine.Equipe;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Meckanik
 */
public class ListeEquipeTest {

  private ListeEquipes listeEquipe;
  EquipeDao mockedEquipeDao = mock(EquipeDao.class);

  @BeforeMethod
  public void setUp() throws Exception {
    ArrayList equipes = new ArrayList();
    equipes.add(new Equipe("Heineken", 2));
    
    when(mockedEquipeDao.getListeEquipe()).thenReturn(equipes);
    listeEquipe = new ListeEquipes(mockedEquipeDao);
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
