package ch.hesge.projetmaven.metier;

import ch.hesge.projetmaven.base.EquipeDao;
import ch.hesge.projetmaven.domaine.Equipe;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.mockito.Mockito.mock;

/**
 * @author Meckanik
 */
public class ListeEquipesTest {

  private ListeEquipes listeEquipe;
  EquipeDao mockedEquipeDao = mock(EquipeDao.class);
  ArrayList equipes = new ArrayList();
  
  @BeforeMethod
  public void setUp() throws Exception {
    
    
  }

  @Test
  public void isEmptyTestFalse() {
    equipes.add(new Equipe("Heineken", 2));
    when(mockedEquipeDao.getListeEquipe()).thenReturn(equipes);
    listeEquipe = new ListeEquipes(mockedEquipeDao);

    assertFalse(listeEquipe.isEmpty());
  }
  
  @Test
  public void isEmptyTestTrue() {
    when(mockedEquipeDao.getListeEquipe()).thenReturn(new ArrayList());
    listeEquipe = new ListeEquipes(mockedEquipeDao);
    
    assertTrue(listeEquipe.isEmpty());
  }
  
}
