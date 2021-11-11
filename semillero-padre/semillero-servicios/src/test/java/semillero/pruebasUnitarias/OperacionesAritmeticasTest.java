package semillero.pruebasUnitarias;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OperacionesAritmeticasTest 
{
	/* cste q contendrá el log de la clase aritmetica test*/
	private final static Logger log = Logger.getLogger(OperacionesAritmeticasTest.class);
	
	@BeforeTest
	public void inicializar() 
	{
		BasicConfigurator.configure(); //inicializa el logger con una conf basica
	}
	
	//Método encargado de probar que el resultado de la suma de dos números
	//sea 450
	@Test
	public void validarResultadosSumamaExitoso() 
	{
		log.info("inicia ejecucion del metodo validarResultadosSumamaExitoso()");
		log.info("====================INICIA PRUEBAS UNITARIAS================");
		
		int numero1 = 300;
		int numero2 = 150;
		int resultado = 450;
		
		//Assert.assertFalse(condition);
		//Assert.assertTrue(condition);
		//Assert.assertEquals(expected, actual);
		//Assert.assertNull(object);
		//Assert.assertNotNull(object);
		Assert.assertEquals(resultado, numero1 + numero2);
		
		log.info("Finaliza ejecucion del metodo validarResultadosSumamaExitoso()");
	}
}
