/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hesge.projetmaven.base;

import ch.hesge.projetmaven.domaine.Coureur;
import ch.hesge.projetmaven.outils.FileToStr;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author meckanik
 */
public class CoureurDaoTest {

  CoureurDao coureurDao;
  
  @Test
  public void CoureurDaoReturnsAnArrayListOf3Coureurs() {
    Fichier mockedFichier = mock(Fichier.class);
    when(mockedFichier.size()).thenReturn(3);
    when(mockedFichier.isNull()).thenReturn(false);
    when(mockedFichier.isLigneEquipe()).thenReturn(false);
    when(mockedFichier.getLigneCourante()).thenReturn("DUPONT;Jean;M;32.1;Heineken");
    
    CoureurDao coureurDaoTest = new CoureurDao(mockedFichier);
    List coureurs = coureurDaoTest.getListeCoureur();
    assertTrue(coureurs.size() == 3);
    
    Coureur fakeCoureur = new Coureur("DUPONT", "Jean", 'M', 32.1, "Heineken");
    for (Object coureur : coureurs) {
      assertTrue(coureur.equals(fakeCoureur));
    }
  }
}
