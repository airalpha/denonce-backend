package com.air.etab;

import com.air.etab.entities.Ville;
import com.air.etab.repository.VilleRepository;
import com.air.etab.service.VilleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EtabApplicationTests {


    @Test
    public void contextLoads() {
    }

    @Autowired
    private VilleService villeService;

    @MockBean
    private VilleRepository villeRepository;

    @Test
    public  void getVilleByIdTest(){
        when(villeRepository.findById(11L)).thenReturn(
                java.util.Optional.of(new Ville("Bafoussam"))
        );
        Optional<Ville> ville = villeService.getVille(11L);
        assertEquals("Bafoussam", ville.get().getNom());
    }

    @Test
    public void addVilleTest(){
        Ville ville = new Ville("VilleTest");
        villeService.save(ville);
        verify(villeRepository, times(1)).save(ville);
    }





}
