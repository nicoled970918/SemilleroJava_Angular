package semillero.pruebasUnitarias;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.enums.TematicaEnum;

/**
 * 
 * <b>Descripción:<b> Clase que determina las pruebas unitarias para la creación
 * de Comics. <b>Caso de Uso:<b> hbt semillero
 * 
 * @author NICOLE
 * @version
 */
public class CreacionComicTest {

	private final static Logger log = Logger.getLogger(CreacionComicTest.class);

	/**
	 * Atributo que crea la lista de comics
	 */
	public ArrayList<ComicDTO> arrayListComicDTO = new ArrayList<>();
	
	/**
	 * Atributo que determina la lista de Comics con estado = Activo
	 */
	public ArrayList<ComicDTO> arrayListComicDTOActivos;
	
	/**
	 * Atributo que determina la lista de Comics con estado = Inactivo
	 */
	public ArrayList<ComicDTO> arrayListComicDTOInactivos;

	/**
	 * 
	 * Metodo encargado de enviar mensaje de inicio de pruebas <b>Caso de Uso</b>
	 * 
	 * @author NICOLE
	 *
	 */
	@BeforeTest
	public void inicializar() 
	{
		/**
		 * Primero valido si mi lista a llenar está vacía para comenzar a agregar elementos
		 */
		if (arrayListComicDTO.isEmpty()) 
		{
			agregarComics();
		}
		/**
		 * Lleno mi lista de activos (arrayListComicDTOActivos) con los comics que tengan estado = activo
		 */
		this.arrayListComicDTOActivos = comicsEstadoActivo();
		/**
		 * Lleno mi lista de activos (arrayListComicDTOInactivos) con los comics que tengan estado = inactivo
		 */
		this.arrayListComicDTOInactivos = comicsEstadoInactivos();
		/**
		 * Inicializa el Logger con una config. básica
		 */
		BasicConfigurator.configure();
		
		log.info(":::::::::INICIAN PRUEBAS UNITARIAS:::::::::");
	}

	/**
	 * 
	 * Metodo encargado de separar los comics con estado = Activo y guardarlos en mi lista temporal para poder retornarlos
	 * <b>Caso de Uso</b>
	 * 
	 * @author NICOLE
	 *
	 */
	private ArrayList<ComicDTO> comicsEstadoActivo() 
	{
		ArrayList<ComicDTO> arrayListTemporal = new ArrayList<>();
		
		for (ComicDTO comicDTO : arrayListComicDTO) 
		{
			if (comicDTO.getEstadoEnum() == EstadoEnum.ACTIVO) 
			{
				arrayListTemporal.add(comicDTO);
			}
		}
		return arrayListTemporal;
	}

	/**
	 * Metodo encargado de separar los comics con estado = Inactivo y guardarlos en mi lista temporal para poder retornarlos
	 * <b>Caso de Uso</b>
	 * 
	 * @author NICOLE
	 * 
	 * @return
	 */
	private ArrayList<ComicDTO> comicsEstadoInactivos() 
	{
		ArrayList<ComicDTO> arrayListTemporal = new ArrayList<>();
		for (ComicDTO comicDTO : arrayListComicDTO) 
		{
			if (comicDTO.getEstadoEnum() == EstadoEnum.INACTIVO) 
			{
				arrayListTemporal.add(comicDTO);
			}

		}
		return arrayListTemporal;

	}

	private void agregarComics() 
	{
		/**
		 * Atributo que determina la fecha para la creacion de los comics
		 */
		LocalDate localDate = LocalDate.now();

		/**
		 * Creación de 5 comicDto con estado = activo para la realización de las pruebas unitarias
		 */
		ComicDTO comicDTO1 = new ComicDTO(01L, "Hulk", "editorial01", TematicaEnum.BELICO, "coleccion01", 10,
				new BigDecimal(15000000), "autor01", false, localDate, EstadoEnum.ACTIVO, 100000L);
		ComicDTO comicDTO2 = new ComicDTO(02L, "Capitan America", "editorial02", TematicaEnum.FANTASTICO, "coleccion02", 20,
				new BigDecimal(15000000), "autor02", false, localDate, EstadoEnum.ACTIVO, 200000L);
		ComicDTO comicDTO3 = new ComicDTO(03L, "Capitana Marvel", "editorial03", TematicaEnum.FANTASTICO, "coleccion03", 30,
				new BigDecimal(15000000), "autor03", true, localDate, EstadoEnum.ACTIVO, 300000L);
		ComicDTO comicDTO4 = new ComicDTO(04L, "Iron Man", "editorial04", TematicaEnum.HORROR, "coleccion04", 40,
				new BigDecimal(15000000), "autor04", true, localDate, EstadoEnum.ACTIVO, 400000L);
		ComicDTO comicDTO5 = new ComicDTO(05L, "El hombre araña", "editorial05", TematicaEnum.HISTORICO, "coleccion05", 50,
				new BigDecimal(15000000), "autor05", false, localDate, EstadoEnum.ACTIVO, 500000L);
		
		/**
		 * Creacion de 5 comicDto con estado inactivo para la realización de las pruebas unitarias
		 */
		ComicDTO comicDTO6 = new ComicDTO(06L, "Thor", "editorial06", TematicaEnum.AVENTURAS, "coleccion06", 60,
				new BigDecimal(15000000), "autor06", false, localDate, EstadoEnum.INACTIVO, 600000L);
		ComicDTO comicDTO7 = new ComicDTO(07L, "AquaMan", "editorial07", TematicaEnum.BELICO, "coleccion07", 70,
				new BigDecimal(15000000), "autor07", true, localDate, EstadoEnum.INACTIVO, 700000L);
		ComicDTO comicDTO8 = new ComicDTO(11L, "SuperMan", "editorial08", TematicaEnum.CIENCIA_FICCION, "coleccion08", 80,
				new BigDecimal(15000000), "autor08", true, localDate, EstadoEnum.INACTIVO, 800000L);
		ComicDTO comicDTO9 = new ComicDTO(12L, "BatMan", "editorial09", TematicaEnum.DEPORTIVO, "coleccion09", 90,
				new BigDecimal(15000000), "autor09", false, localDate, EstadoEnum.INACTIVO, 900000L);
		ComicDTO comicDTO10 = new ComicDTO(10L, "Flash", "editorial10", TematicaEnum.FANTASTICO, "coleccion10", 100, 
				new BigDecimal(15000000), "autor10", false, localDate, EstadoEnum.INACTIVO, 10000000L);

		/**
		 * Añado los comics creados anteriormente, al arrayList llamado arrayListComicDTO
		 */
		arrayListComicDTO.add(comicDTO1);
		arrayListComicDTO.add(comicDTO2);
		arrayListComicDTO.add(comicDTO3);
		arrayListComicDTO.add(comicDTO4);
		arrayListComicDTO.add(comicDTO5);
		arrayListComicDTO.add(comicDTO6);
		arrayListComicDTO.add(comicDTO7);
		arrayListComicDTO.add(comicDTO8);
		arrayListComicDTO.add(comicDTO9);
		arrayListComicDTO.add(comicDTO10);
	}

	/**
	 * 
	 * Metodo encargado de validar los comics con estado = activo <b>Caso de Uso</b> semillero 2021
	 * 
	 * @author NICOLE
	 *
	 */
	@Test
	public void validarActivos() 
	{

		log.info("Inicia ejecucion del metodo validarActivos()");
		
		/**
		 * Valido que mi lista de activos no esté vacía
		 */
		Assert.assertNotNull(arrayListComicDTOActivos);
		
		/**
		 * Recorro la lista para comparar uno a uno que el estado de los comics sea Avtivo
		 */
		for (ComicDTO comicDTO : arrayListComicDTOActivos) 
		{
			/**
			 * Verifico que el estado de los comic sea activo
			 */
			Assert.assertEquals(comicDTO.getEstadoEnum(), EstadoEnum.ACTIVO);
			{
				System.out.println(comicDTO.toString());
			}
		}

		log.info("Finaliza la ejecucion del metodo validarActivos()");
	}
	
	/**
	 * 
	 * Metodo encargado de validar los comics con estado = inactivo <b>Caso de Uso</b> semillero 2021
	 * @author NICOLE
	 *
	 */
	@Test
	public void validarInactivos() 
	{

		log.info("Inicia ejecucion del metodo validarInactivos()");
		
		/**
		 * Lista temporal que guardará el nombre de los comics con estado = inactivo
		 */
		ArrayList<String> arrayListTempInactivos = new ArrayList<>();
		
		/**
		 * Valido que mi lista de inactivos no esté vacía
		 */
		Assert.assertNotNull(arrayListTempInactivos);
		try {
			/**
			 * Recorro la lista para comparar uno a uno que el estado de los comics sea Inactivo
			 */
			for (ComicDTO comicDTO : arrayListComicDTOInactivos)
			{
				/**
				 * Verifico que el estado de los comic sea inactivo
				 */
				Assert.assertEquals(comicDTO.getEstadoEnum(), EstadoEnum.INACTIVO);
				{
					arrayListTempInactivos.add(comicDTO.getNombre());
				}
			}	
			
			throw new Exception("Se genero una excepcion");		
			
		} catch (Exception e) 
		{
			Assert.assertEquals(e.getMessage(),"Se genero una excepcion");
			
			System.out.println("Se ha detectado que de " + arrayListComicDTO.size() + " comics se encontraron que "
					+ arrayListComicDTOActivos.size() + " se encuentran activos y " + arrayListComicDTOInactivos.size()
				+ " inactivos. Los comics inactivos son:" + arrayListTempInactivos.toString());
		}

		log.info("Finaliza la ejecucion del metodo validarInactivos()");
	}

	@AfterTest
	public void finalizaPruebasUnitarias() 
	{
		log.info(":::::::::FINALIZA PRUEBAS UNITARIAS:::::::::");
	}
}
