//Agustín Muñoz Vargas - 22.387.587-4 - ICCI
package taller03;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
	
	private static void GuardarTXT (String filePath, ArrayList<Jugador> arregloJugador)
	{
		try {
			FileWriter writerAlumnos = new FileWriter(filePath);
			for (int i = 0; i < arregloJugador.size(); i++)
			{
			String soporteMoral = arregloJugador.get(i).getNombre() + ";" + arregloJugador.get(i).getPuntaje() + "\n";
			writerAlumnos.write(soporteMoral);
			}
			writerAlumnos.close();
			System.out.println("[!] Guardado :3");
		} catch (Exception e) {
			System.out.println("[!] Ruta de escritura no encontrada");
		}
	}

	
	public static ArrayList<Monstruo> ReadMounstro(String filePath) 
	{
		Integer contador = 0;
		File arch = new File(filePath);
		String archLinePart;
		String[] archLinePartList;
		ArrayList<Monstruo> listaMonstruo = new ArrayList<>();
		try 
		{
			Scanner archLine = new Scanner(arch);
			while (true) 
			{
				if (archLine.hasNextLine() == false) {break;}
				
				archLinePart = archLine.nextLine();
				archLinePartList = archLinePart.split(";");
				boolean tester = false;
				
				for (String entrada : archLinePartList) 
				{if (entrada == null) {tester = true; break;}}
				
				
				if ((archLinePart != null) && (tester == false))
				{
//					System.out.println(archLinePart);
//					System.out.println(archLinePartList[0]);
					try 
					{
						switch (archLinePartList[0].toLowerCase())
						{
							case "zombi":
//								System.out.println("Z");
								contador = contador + 1;
								listaMonstruo.add(new Zombi     ((int)Float.parseFloat(archLinePartList[1]),(int)Float.parseFloat(archLinePartList[2]),(int)Float.parseFloat(archLinePartList[3]),(int)Float.parseFloat(archLinePartList[4]),(int)Float.parseFloat(archLinePartList[5])));
								break;
							case "vampiro":
//								System.out.println("V");
								contador = contador + 1;
								listaMonstruo.add(new Vampiro   ((int)Float.parseFloat(archLinePartList[1]),(int)Float.parseFloat(archLinePartList[2]),(int)Float.parseFloat(archLinePartList[3]),(int)Float.parseFloat(archLinePartList[4]),(int)Float.parseFloat(archLinePartList[5]),(int)Float.parseFloat(archLinePartList[6])));
								break;
							case "momia":
//								System.out.println("M");
								contador = contador + 1;
								listaMonstruo.add(new Momia     ((int)Float.parseFloat(archLinePartList[1]),(int)Float.parseFloat(archLinePartList[2]),(int)Float.parseFloat(archLinePartList[3]),(int)Float.parseFloat(archLinePartList[4]),(int)Float.parseFloat(archLinePartList[5])));
								break;
							case "hombrelobo":
//								System.out.println("H");
								contador = contador + 1;
								listaMonstruo.add(new HombreLobo((int)Float.parseFloat(archLinePartList[1]),(int)Float.parseFloat(archLinePartList[2]),(int)Float.parseFloat(archLinePartList[3]),(int)Float.parseFloat(archLinePartList[4]),(int)Float.parseFloat(archLinePartList[5]),(int)Float.parseFloat(archLinePartList[6])));
								break;
							default:
//								System.out.println("[!] [RM-D] [" + archLinePartList[0] + "] No encontrada");;
								break;
						}
					}
					catch (NumberFormatException e)
					{
//						System.out.println("[!] [RM-B] Entrada incluye texto");
					}
					catch (ArrayIndexOutOfBoundsException e)
					{
//						System.out.println("[!] [RM-C] No hay entradas suficientes");
					}
				}
			}
			System.out.println(contador + " mounstros cargados desde " + filePath);
			return listaMonstruo;
		}
		catch (Exception FileNotFoundException)
		{
			System.out.println("[!] [RM-A] Archivo no encontrado");
			return null; 
		}
	}
	
	public static ArrayList<Jugador> ReadJugador(String filePath)
	{
		Integer contador = 0;
		File arch = new File(filePath);
		String archLinePart;
		String[] archLinePartList;
		ArrayList<Jugador> listaJugador = new ArrayList<>();
		try 
		{
			Scanner archLine = new Scanner(arch);
			
			while (true)
			{
				if (archLine.hasNextLine() == false) {break;}
				
				archLinePart = archLine.nextLine();
				archLinePartList = archLinePart.split(";");
				try
				{
					if (archLinePartList[0] != "" && archLinePartList[0] != null && archLinePartList[1] != null)
					{
						listaJugador.add(new Jugador(archLinePartList[0],Integer.parseInt(archLinePartList[1])));
						contador = contador + 1;
//						System.out.println(archLinePartList[0] + " " +  Integer.parseInt(archLinePartList[1]));
					}
					else
					{
//						System.out.println("[!] [RJ-D] Entrada/s vacia/s");
					}
				}
				catch (NumberFormatException e)
				{
//					System.out.println("[!] [RJ-B] Entrada incluye texto");
				}
				catch (ArrayIndexOutOfBoundsException e)
				{
//					System.out.println("[!] [RJ-C] No hay entradas suficientes");
				}
			}
			System.out.println(contador + " jugadores cargados desde " + filePath);
			return listaJugador;
		}
		catch (Exception FileNotFoundException)
		{
			System.out.println("[!] [RJ-A] Archivo no encontrado");
			return null; 
		}
	}
	
	
	
	
	
	
	
	public static ArrayList<Monstruo > listaMonstruo  = new ArrayList<>( );
	public static ArrayList<Jugador  > listaJugador   = new ArrayList<>( );
	public static ArrayList<Minijuego> listaMinijuego = new ArrayList<>(4);
	
	public static void main(String[] args) // TODO
	{
		
		System.out.println("Cargando archivos...");
		listaMonstruo = ReadMounstro("src/textos/Monstruos.txt");
		listaJugador  = ReadJugador ("src/textos/Registros.txt");
		
		if (listaMonstruo.size() < 4) {System.out.println("[!] no hay mounstros suficientes para completar los 4 minijuegos.");}
		
		Jugador jugadorSelecto = null;
		
		Scanner scan = new Scanner(System.in);
		String  inputStringAA;
		int    inputIntegerAA;
		
		boolean miniA = false; // Para determinas si un juego ya fue jugado.
		boolean miniB = false;
		boolean miniC = false;
		boolean miniD = false;
		
		// Si Monstruos.txt no existe o no tiene ningún monstruo válido, el programa debe informarlo y terminar de forma controlada.

		// La forma de resolver lo del registro de los minijuegos y su puntaje seria haciendo una lista de Minijuego (que guarden el nombre y el puntaje,
		// los cuales despues se podrian sumar para registrar el record)
		
		
		System.out.println("=========================================");
		System.out.println("             SPOOKY SEASON               ");
		System.out.println("=========================================");
		
		while (true)
		{
			System.out.println("Ingrese su nombre de usuario: ");
			inputStringAA = scan.next();
//			System.out.println(inputStringAA);
			if (inputStringAA.isBlank()) 
			{System.out.println("[!] El nombre no puede estar vacío.");}
			else if (inputStringAA.contains(";")) 
			{System.out.println("[!] El nombre no puede contener punto/s y coma/s (;).");}
			else 
			{
				Boolean isIn = false;
				for (Jugador iJugador : listaJugador) 
				{
//					System.out.println(iJugador.getNombre().toLowerCase() + " " + inputStringAA.toLowerCase()); 
					if (iJugador.getNombre().equalsIgnoreCase(inputStringAA)) 
					{jugadorSelecto = iJugador; isIn = true; System.out.println("[!] Jugador Cargado"); break;}}
				if (isIn == false) {jugadorSelecto = new Jugador (inputStringAA,0); listaJugador.add(jugadorSelecto); System.out.println("[!] Nuevo Jugador");} //Guardar en texto con puntaje en 0
				break;
			}
		}
		
		System.out.printf("¡Bienvenido [%s]! Tu récord actual es de [%s] puntos.%n", jugadorSelecto.getNombre(), jugadorSelecto.getPuntaje());
		
		
		
		
		while (true) 
		{
			try 
			{
				boolean exitTest = false;
				System.out.println("============================================");
				System.out.println("-   -   -   -  MENÚ PRINCIPAL  -   -   -   -");
				System.out.println("============================================");
				System.out.println("--------------------------------------------");
				System.out.printf ("  Jugador: [%s]%n", jugadorSelecto.getNombre());
				System.out.println("  [1] Jugar un minijuego");
				System.out.println("  [2] Ver catálogo de monstruos");
				System.out.println("  [3] Ver historial de la sesión");
				System.out.println("  [4] Ver ranking de jugadores");
				System.out.println("  [5] Terminar sesión");
				System.out.println("  [6] Salir");
				System.out.println("============================================");
				System.out.print  ("Seleccione una opcion: ");
				inputIntegerAA = scan.nextInt();
				System.out.println("");
				switch (inputIntegerAA)
				{
					case 1:
						if (listaMonstruo.size() <= 0) 
						{
							System.out.println("[!] lo sentimos, pero no hay montruos disponibles, tal vez en la siguiente, retornando...");
						}
						else
						{
							System.out.println("============================================");
							System.out.println("  [1] Carrera del Cementerio   " + miniA);
							System.out.println("  [2] Caza de Calabazas        " + miniB);
							System.out.println("  [3] Lanzamiento de Lápidas   " + miniC);
							System.out.println("  [4] Sobrevivir al Amanecer   " + miniD);
							System.out.println("  [5] Volver   ");
							System.out.println("============================================");
							System.out.print  ("Seleccione una opcion: ");
							inputIntegerAA = scan.nextInt();
							System.out.println("");
							
							int auxInput;
							int auxPuntos = 0;
							String auxTipoAtaque      = "";
							String auxTipoMinijuego   = "";
							String auxNombreMinijuego = "";
							
							boolean auxSeJugo       = false;
							boolean auxFueraDeRango = false;
							boolean auxSaliendo     = false;
							switch (inputIntegerAA) 
							{
								case 1: if (miniA == true) {auxSeJugo = true;} break;
								case 2:	if (miniB == true) {auxSeJugo = true;} break;
								case 3: if (miniC == true) {auxSeJugo = true;} break;
								case 4: if (miniD == true) {auxSeJugo = true;} break;
								case 5:  auxSaliendo     = true; break;
								default: auxFueraDeRango = true; break;
							}
							if (auxSeJugo == false && auxFueraDeRango == false && auxSaliendo == false) 
							{
								auxInput = inputIntegerAA;
								switch (inputIntegerAA) 
								{
									case 1: auxTipoMinijuego =  "carreraDeCementerio"; auxNombreMinijuego = "Carrera del Cementerio"; break;
									case 2:	auxTipoMinijuego =      "cazaDeCalabazas"; auxNombreMinijuego =      "Caza de Calabazas"; break;
									case 3: auxTipoMinijuego =  "lanzamientoDeLapida"; auxNombreMinijuego = "Lanzamiento de Lápidas"; break;
									case 4: auxTipoMinijuego = "sobrevivirAlAmanecer"; auxNombreMinijuego = "Sobrevivir al Amanecer"; break;		
								}
								for (int i = 0; i < listaMonstruo.size(); i++) 
								{
									System.out.printf("[%-3s] ",i);
									listaMonstruo.get(i).toText();
								}
								System.out.print  ("Seleccione una opcion: ");
								inputIntegerAA = scan.nextInt();
								while (true) 
								{
									if (0 <= inputIntegerAA && inputIntegerAA <listaMonstruo.size()) {break;}
									else 
									{
										System.out.println("[!] [MJG] Entrada fuera de rango, intente de nuevo...");
										System.out.print  ("Seleccione una opcion: ");
										inputIntegerAA = scan.nextInt();
									}
								}
								
								auxTipoAtaque = listaMonstruo.get(inputIntegerAA).tipoAtaque();
								auxPuntos     = listaMonstruo.get(inputIntegerAA).playMinigame(auxTipoMinijuego,auxTipoAtaque);
								System.out.println(auxPuntos);
								System.out.println(auxNombreMinijuego + auxPuntos + listaMonstruo.get(inputIntegerAA).getClass().getSimpleName() + auxTipoAtaque);
								listaMinijuego.add(new Minijuego (auxNombreMinijuego,auxPuntos,listaMonstruo.get(inputIntegerAA),auxTipoAtaque)); 
								listaMonstruo.remove(inputIntegerAA);
								
								switch (auxInput) 
								{
									case 1: miniA = true; break;
									case 2:	miniB = true; break;
									case 3: miniC = true; break;
									case 4: miniD = true; break;
								}
							}
							else if (auxSeJugo       == true) 
							{System.out.println("[!] Ya jugaste este minijuego.");}
							else if (auxFueraDeRango == true) 
							{System.out.println("[!] Entrada fuera de rango, retornando...");}
							else if (auxSaliendo     == true) 
							{System.out.println("[!] Saliendo...");}
						}
						break;
					case 2:
						System.out.println("-   -   -  CATÉGORIA DE MONSTRUOS  -   -   -");
						for (int i = 0; i < listaMonstruo.size(); i++) 
						{
							System.out.printf("[%-3s] ",i);
							listaMonstruo.get(i).toText();
						}
						System.out.println("");
						break;
					case 3:
						int auxSumador = 0;
						System.out.println("-   -   -  HISTORIAL DE LA SESIÓN  -   -   -");
						for (int i = 0; i < listaMinijuego.size(); i++) 
						{
							System.out.printf("[%-3s] ",i);
							listaMinijuego.get(i).toText();
							auxSumador = auxSumador + listaMinijuego.get(i).getPuntaje();
						}
						System.out.println("Puntaje acumulado: " + auxSumador + " pts");
						System.out.println("");
						break;
					case 4:

						System.out.println("-   -   -  HISTORIAL DE LA SESIÓN  -   -   -");
						for (int i = 0; i < listaJugador.size(); i++) 
						{
							System.out.printf("[%-3s] ",i);
							listaJugador.get(i).toText();
						}
						System.out.println("");
						break;
						// Sortear la lista de puntos para mostrar el ranking correcto
					case 5:
						
						System.out.println("Sesión terminada.");
						while (true)
						{
							auxSumador = 0;
							//En caso de record, guarda archivos
							for (int i = 0; i < listaMinijuego.size(); i++) 
							{
								System.out.printf("[%-3s] ",i);
								listaMinijuego.get(i).toText();
								auxSumador = auxSumador + listaMinijuego.get(i).getPuntaje();
							}
							if (auxSumador >= jugadorSelecto.getPuntaje())
							{
								System.out.println("[!][!][!]");
								for (int i = 0; i < listaJugador.size(); i++) 
								{
									if (listaJugador.get(i).getNombre().equalsIgnoreCase(jugadorSelecto.getNombre())) 
									{listaJugador.get(i).setPuntaje(auxSumador); break;}
								}
								System.out.println(auxSumador);
								GuardarTXT("src/textos/Registros.txt",listaJugador);
							}
							jugadorSelecto = null; // Reinicia detalles de arranque para no explotar al reiniciar.
							miniA = false; 
							miniB = false;
							miniC = false;
							miniD = false;
							System.out.println("Cargando archivos...");
							listaMonstruo = ReadMounstro("src/textos/Monstruos.txt");
							listaJugador  = ReadJugador ("src/textos/Registros.txt");
							System.out.println("Ingrese su nombre de usuario: ");
							inputStringAA = scan.next();
							if (inputStringAA.isBlank()) 
							{System.out.println("[!] El nombre no puede estar vacío.");}
							else if (inputStringAA.contains(";")) 
							{System.out.println("[!] El nombre no puede contener punto/s y coma/s (;).");}
							else 
							{
								Boolean isIn = false;
								for (Jugador iJugador : listaJugador) 
								{
									if (iJugador.getNombre().equalsIgnoreCase(inputStringAA)) 
									{jugadorSelecto = iJugador; isIn = true; System.out.println("[!] Jugador Cargado"); break;}}
								if (isIn == false) {jugadorSelecto = new Jugador (inputStringAA,0); listaJugador.add(jugadorSelecto); System.out.println("[!] Nuevo Jugador");} //Guardar en texto con puntaje en 0
								break;
							}
						}
						break;
					case 6:
						System.out.println("[!] Terminando ejecutable..."); 
						auxSumador = 0;
						//En caso de record, guarda archivos
						for (int i = 0; i < listaMinijuego.size(); i++) 
						{
							System.out.printf("[%-3s] ",i);
							listaMinijuego.get(i).toText();
							auxSumador = auxSumador + listaMinijuego.get(i).getPuntaje();
						}
						if (auxSumador >= jugadorSelecto.getPuntaje())
						{
							System.out.println("[!][!][!]");
							for (int i = 0; i < listaJugador.size(); i++) 
							{
								if (listaJugador.get(i).getNombre().equalsIgnoreCase(jugadorSelecto.getNombre())) 
								{listaJugador.get(i).setPuntaje(auxSumador); break;}
							}
							System.out.println(auxSumador);
							GuardarTXT("src/textos/Registros.txt",listaJugador);
						}
						exitTest = true;;
						// Buscar guardar archivo en caso de record
						break;
					default:
						System.out.println("[!] Input fuera de rango.");
						break;
				}
				
				if (exitTest == true) {break;}

			} catch(Exception InputMismatchException) {throw new IllegalArgumentException("Tristemente, se equivoco de formato (Puso letras o símbolos cuando solo se piden números) y todo exploto, perdón por los inconvenientes.");  }
		} // while (true) fin
	}
}
