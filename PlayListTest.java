package ar.edu.uno.poo1.tp1;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class PlayListTest {
	
	PlayList Obj; //SE DECLARA EL OBJETO GLOBAL
	
	@Before
	public void beforeEjemplo() { // LA OPCION BEFORE PERMITE QUE SIEMPRE SE INICIALICE ESTE METODO ANTES DE ENTRAR EN EN CADA UNO DE LOS METODOS @TEST
		PlayList Obj = new PlayList(); //SE INICIALIZA EL OBJETO Y CON ESTO LOGRAMOS COMPARTIR UN UNICO OBJETO CON TODAS LOS METODOS A TRABAJAR
	}
	
	@After
	public void afterEjemplo() {
		
	}
	
	//@Test CONTIENE DOS HERRAMIENTAS LLAMADAS "expected" y "timeout".
	//AMBOS SIENDO PARÁMETROS QUE SON POSIBLES DE UTILIZAR DE LA SIGUIENTE MANERA @Test(expected = VALOR) ó @Test(timeout = VALOR)
	
	//EL PARAMETRO "expected" NOS PERMITE OMITIR UN ERROR EN EL TEST QUE NOSOTROS LE ESPECIFIQUEMOS PARA EL MÉTODO A TRABAJAR.
	//DE ESTA FORMA, AL PARAMETRO "expected" DEBEMOS ASIGNARLE UN VALOR ESPERADO QUE QUERAMOS OMITIR PARA QUE EL TEST SEA POSITIVO.
	//@Test (expected = VALOR_POSIBLE_ERROR_QUE_SE_QUIERE_OMITIR)
	
	
	//POR OTRA PARTE;
	//EL PARAMETRO "timeout" NOS PERMITE ESPECIFICARLE AL TEST, QUÉ EL MÉTODO A TESTEAR DEBE TARDAR UN DETERMINADO TIEMPO LIMITE DE EJECUCIÓN.
	//Y QUE PASADO ESTE TIEMPO LIMITE EL MÉTODO A EVALUAR DEBE CONSIDERARSE COMO UN ERROR.
	//DE ESTA FORMA, AL PARAMETRO "timeout" DEBEMOS ASIGNARLE UN VALOR LIMITE EN MILISEGUNDOS, Y PASADO ESTE TIEMPO EL TEST NOS DARÁ UN ERROR EN EL MÉTODO.
	//@Test (timeout = VALOR_EN_MILISEGUNDOS_DEL_TIEMPO_LIMITE_DE_EJECUCION_DEL_METODO)
	
	
	//USAR assertEquals(Long EXPECTATIVA_RESULTADO,Long RESULTADO_OBTENIDO) | PARA COMPARAR NUMEROS DE TIPO NO DECIMAL
	//USAR assertEquals(OBJETO EXPECTATIVA_RESULTADO,OBJETO RESULTADO_OBTENIDO) | PARA COMPARAR OBJETOS
	//USAR assertEquals(OBJETO[] EXPECTATIVA_RESULTADO,OBJETO[] RESULTADO_OBTENIDO) | PARA COMPARAR ARRAYS DE OBJETOS
	//USAR assertEquals(Double EXPECTATIVA_RESULTADO, Double RESULTADO_OBTENIDO, Double DELTA) | PARA COMPARAR NUMEROS DE TIPO DECIMAL
	//NOTA: TODOS LOS "assertEquals" PUEDEN INCLUIR UN MENSAJE DE ERROR SI SE LO ESPECIFICAMOS Y FUNCIONA DE LA SIGUIENTE FORMA:
	
	//USAR assertEquals(String MENSAJE_ERROR , [RESTO DE LA COMPARACION "assertEquals()" A UTILIZAR...])
	
	//USAR assertFalse(Boolean CONDICION_COMPARAR) | CONDICION_COMPARAR DEBE SER "false" PARA OBJETENER UN RESULTADO POSITIVO POR EL TEST
	//USAR assertTrue(Boolean CONDICION_COMPARAR) | CONDICION_COMPARAR DEBE SER "true" PARA OBJETENER UN RESULTADO POSITIVO POR EL TEST
	//USAR assertNotEquals() | FUNCIONA IGUAL A TODOS LOS "assertEquals()" NOMBRADOS CON ANTERIORIDAD, CON LA DIFERENCIA
	//DE QUE REALIZA UNA COMPARACIÓN INVERSA, SI LAS COMPARACIONES SON IGUALES EL TEST FALLA.
	
	//USAR assertNull(OBJETO RESULTADO) | SI UN OBJETO ES NULL EL TEST SERÁ POSITIVO, CASO CONTRARIO DARÁ ERROR.
	//USAR assertNotNull(OBJETO RESULTADO) | SI UN OBJETO ES NULL EL TEST DARÁ ERROR, CASO CONTRARIO DARÁ POSITIVO.
	//USAR assertSame(EXPECTATIVA_RESULTADO, RESULTADO_OBTENIDO) | COMPARA SI LAS DOS VARIABLES SON IGUALES Y A SU VEZ, 
	//COMPARA SI AMBOS OBJETOS PERTENECEN A UNA MISMA CLASE, DE SER ASI EL TEST DARÁ POSITIVO, CASO CONTRARIO DARÁ ERROR

	
	@Test 
	public void testNumeroAleatorio() {
		int resultado = Obj.dameNumeroAleatorio();
		
	}
	
	@Test
	public void testAsignarMaximoPermitido() {
		
		Obj.asignarMaximoPermitidoDeCanciones(10);
	}
	
	@Test
	//METODO 1 PARA AGREGAR CANCION AL PLAYLIST (NUEVO)
	//METODO 2 PARA AGREGAR CANCION AL PLAYLIST (NUEVO)
	public void testAgregarCancionAlPlaylist(){
		Obj.agregarCancionAlPlaylist("Titulo 1", 5);
		Obj.agregarCancionAlPlaylist("Titulo 2", "Album 2", "Artista 2", 10);
	}
	
	@Test
	//METODO 1 PARA BUSCAR UNA CANCION EN EL PLAYLIST INGRESANDO DURACION (NUEVO)
	public void testBuscarCancionPorDuracion() {
			
		int resultado = Obj.buscarCancionPorDuracion(5);
		
	}
	@Test
	//METODO 1 PARA QUITAR UNA CANCION DEL PLAYLIST INGRESANDO LA DURACION (NUEVO)
	//METODO 2 PARA QUITAR UNA CANCION EN EL PLAYLIST INGRESANDO TITULO (NUEVO)
	public void testQuitarCancionDelPlaylist() {
		
		Obj.quitarCancionDelPlaylist(5);
		Obj.quitarCancionDelPlaylist("Titulo");
	}
	@Test
	//METODO 1 PARA BUSCAR UNA CANCION EN EL PLAYLIST INGRESANDO TITULO (NUEVO)
	//METODO 2 PARA BUSCAR UNA CANCION EN EL PLAYLIST INGRESANDO TITULO E INDICANDO EL INICIO DE LA POSICION DE BUSQUEDA (NUEVO)
	public void testBuscarCancionPorTitulo() {
		int resultado1 = Obj.buscarCancionPorTitulo("Titulo 1");
		int resultado2 = Obj.buscarCancionPorTitulo("Titulo 1", 5);
	}

	@Test	
	//METODO PARA CONSULTAR LA DURACION DE UNA CANCION INGRESANDO TITULO (NUEVO)
	public void testConsultarDuracionCancion() {
		Obj.consultarDuracionCancion("Titulo");
			
	}
	@Test
	//METODO PARA OBTENER LA DURACION COMPLETA DEL PLAYLIST (NUEVO)
	public void testDameDuracionCompletaPlayList() {
		int resultado = Obj.dameDuracionCompletaPlayList();
	}
	@Test
	//METODO PARA OBTENER LA CANTIDAD DE CANCIONES INGRESADAS AL PLAYLIST (NUEVO)
	public void testDameCantidadDeCancionesPlayList() {
		int resultado = Obj.dameCantidadDeCancionesPlayList();
	}
	@Test
	//METODO PARA OBTENER LA CANCION CON MAYOR DURACION DEL PLAYLIST (NUEVO)
	public void testDameCancionMayorDuracionPlayList() {
		
		int resultado = Obj.dameCancionMayorDuracionPlayList();
	}
	@Test
	//METODO PARA OBTENER LA CANCION CON MENOR DURACION DEL PLAYLIST (NUEVO)
	public void testDameCancionMenorDuracionPlayList() {
		int resultado = Obj.dameCancionMenorDuracionPlayList();
		
	}
	@Test
	//METODO PARA MOSTRAR EL PLAYSLIST ORDENADO POR TITULO DE CANCION (NUEVO)
	public void mostrarPlayListOrdenadoPorTituloCancion(){
		Obj.mostrarPlayListOrdenadoPorTituloCancion();	
	}
	
	@Test	
	//METODO PARA MOSTRAR EL PLAYSLIST ORDENADO POR ARTISTA DE CANCION (NUEVO)
	public void testMostrarPlayListOrdenadoPorArtistaCancion(){

		Obj.mostrarPlayListOrdenadoPorArtistaCancion();
			
	}

	
	//@After POR EL CONTRARIO A @BEFORE, @AFTER SIEMPRE SE VA A EJECUTAR A LO ULTIMO DE TODAS LAS FUNCIONES TEST QUE SE HAYAN CREADO
	//@AfterClass y @BeforeClass
	//@RunWith y @Parameters | PRUEBAS PARAMETRIZADAS
	
	
	
}

	