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
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author meckanik
 */
public class CoureurDaoTest {
  
  @Test
  public void getListeCoureur_returns_list_of_Coureur() {
    Fichier mockedFichier = mock(Fichier.class);
    when(mockedFichier.size()).thenReturn(3);
    when(mockedFichier.isEOF()).thenReturn(false).thenReturn(false).thenReturn(false).thenReturn(true);
    when(mockedFichier.isLigneEquipe()).thenReturn(false);
    when(mockedFichier.getLigneCourante()).thenReturn("DUPONT;Jean;M;32.1;Heineken");
    
    CoureurDao coureurDaoTest = new CoureurDao(mockedFichier);
    List coureurs = coureurDaoTest.getListeCoureur();
    for (Object coureur : coureurs) {
      assertTrue(coureur.equals(coureurDaoTest));
    }
  }
}
