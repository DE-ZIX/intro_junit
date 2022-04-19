package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois numeros")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Excecao nao lancada");
		} catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}
	}

	@Test
	void testSubtracao(int n1, int n2)
	{
		assertEquals(n1-n2, calc.subtracao(n1, n2));
	}

	@Test
	void testMultiplicacao(int n1, int n2)
	{
		assertEquals(n1*n2, calc.multiplicacao(n1, n2));
	}

	@Test
	void testDivisao(int num, int den)
	{
		assertEquals(num/den, calc.divisao(num, den));
	}

	@Test
	void testSomatoria(int num) // 5 => 0+1+2+3+4+5 = 15
	{

		if(num > 1)
		{
			int n = num;
			int sum = 0;
			while (num >= 0) {
				sum += n;
				n--;
			}		
			assertEquals(sum, calc.somatoria(num));
		} else {
			assertEquals(num, calc.somatoria(num));
		}
	}

	@Test
	void testEhPositivo(int num)
	{
		assertTrue(calc.ehPositivo(num));
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}

}
