package observer;

import org.junit.jupiter.api.Test;
import org.observer.BlusaVasco;
import org.observer.Torcedor;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TorcedorTest {

    @Test
    public void deveNotificarUmTorcedor(){
        BlusaVasco blusaVasco = new BlusaVasco("Blusa 1", 150.0);
        Torcedor torcedor = new Torcedor("Marco");
        torcedor.querComprar(blusaVasco);
        blusaVasco.adicionarEstoque();
        assertEquals("Marco, chegou BlusaVasco{nomeBlusa='Blusa 1', valor='150.0'} no estoque! Corre para comprar!", torcedor.getNotificacao());
    }

    @Test
    public void deveNotificarTorcedores(){
        BlusaVasco blusaVasco = new BlusaVasco("Blusa 1", 150.0);
        Torcedor torcedor1 = new Torcedor("Marco");
        Torcedor torcedor2 = new Torcedor("Antonio");
        torcedor1.querComprar(blusaVasco);
        torcedor2.querComprar(blusaVasco);
        blusaVasco.adicionarEstoque();
        assertEquals("Marco, chegou BlusaVasco{nomeBlusa='Blusa 1', valor='150.0'} no estoque! Corre para comprar!", torcedor1.getNotificacao());
        assertEquals("Antonio, chegou BlusaVasco{nomeBlusa='Blusa 1', valor='150.0'} no estoque! Corre para comprar!", torcedor2.getNotificacao());
    }

    @Test
    public void naoDeveNotificarTorcedor(){
        BlusaVasco blusaVasco = new BlusaVasco("Blusa 1", 150.0);
        Torcedor torcedor = new Torcedor("Marco");
        blusaVasco.adicionarEstoque();
        assertEquals(null, torcedor.getNotificacao());
    }

    @Test
    public void deveNotificarTorcedorBlusaLendaria(){
        BlusaVasco blusaVascoLendaria = new BlusaVasco("Lendaria", 150.0);
        BlusaVasco blusaVascoNormal = new BlusaVasco("Normal", 100.0);
        Torcedor torcedor1 = new Torcedor("Marco");
        Torcedor torcedor2 = new Torcedor("Antonio");
        torcedor1.querComprar(blusaVascoLendaria);
        torcedor2.querComprar(blusaVascoNormal);
        blusaVascoLendaria.adicionarEstoque();
        assertEquals("Marco, chegou BlusaVasco{nomeBlusa='Lendaria', valor='150.0'} no estoque! Corre para comprar!", torcedor1.getNotificacao());
        assertEquals(null, torcedor2.getNotificacao());
    }
}
