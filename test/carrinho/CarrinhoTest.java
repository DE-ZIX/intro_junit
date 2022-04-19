package carrinho;

import carrinho.Carrinho;
import produto.Produto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarrinhoTest {

    private final Carrinho carrinho = new Carrinho();
	
	@Test
	void totalValue(ArrayList<Produto> itens)
	{
		double total = 0;
		
		Produto[] products = new Produto[itens.size()]; 
		itens.toArray(products);
		
		for(int i=0; i < products.length; i++)
		{
			assertNotEquals(0.0d, products[i].getPreco());
			total += products[i].getPreco();
		}

		assertEquals(total, carrinho.getValorTotal());
	}

    @Test
	void testAdicaoDeItems(Produto item)
    {
        carrinho.addItem(item);
		assertTrue(carrinho.getItems().contains(item));
	}

	@Test
	void testRemocaoDeItens(Produto item)
    {
        carrinho.removeItem(item);
		assertFalse(carrinho.getItems().contains(item));
	}

	@Test
	void testQtdeItems(ArrayList<Produto> itens)
	{
		assertEquals(itens.size(), carrinho.getQtdeItems());
	}

	@Test
	// Deve ser chamado para testar o carrinho depois que ele for esvaziado
	void isEmpty(ArrayList<Produto> itens)
	{
		assertTrue(itens.size() == 0);
	}
    
}
