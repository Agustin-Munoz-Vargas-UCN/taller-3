package taller03;

import java.util.Scanner;

public class Vampiro extends Monstruo
{
	
	protected int velocidadDeVuelo;
	protected int resistenciaAlSol;
	
	private int maxVelocidadDeVuelo = 100;
	private int maxResistenciaAlSol = 100;
	
	public Vampiro(int vida, int velocidad, int fuerza, int resistencia, int velocidadDeVuelo, int resistenciaAlSol) 
	{
		super(vida, velocidad, fuerza, resistencia);
		
		if (velocidadDeVuelo < 1) {velocidadDeVuelo = 1;}
		if (resistenciaAlSol < 1) {resistenciaAlSol = 1;}
		
		if (velocidadDeVuelo > maxVelocidadDeVuelo) {velocidadDeVuelo = maxVelocidadDeVuelo;}
		if (resistenciaAlSol > maxResistenciaAlSol) {resistenciaAlSol = maxResistenciaAlSol;}
		
		this.velocidadDeVuelo = velocidadDeVuelo;
		this.resistenciaAlSol = resistenciaAlSol;
	}

	public int getVelocidadDeVuelo() {return velocidadDeVuelo;}
	public int getResistenciaAlSol() {return resistenciaAlSol;}
	
	@Override
	public void toText() {
		System.out.printf("%-10s | VIT: %-3s | VEL: %-3s | FUE: %-3s | RES: %-3s | VUE: %-3s | SOL: %-3s | %n","Vampiro",vida,velocidad,fuerza,resistencia,velocidadDeVuelo,resistenciaAlSol);
	}
	
	@Override
	public int carreraDeCementerio () 
	{return ((velocidad+2*velocidadDeVuelo)/2);}
	@Override
	public int cazaDeCalabazas () 
	{return ((fuerza+velocidad)/3);}
	@Override
	public int lanzamientoDeLapida () 
	{return (fuerza+velocidadDeVuelo/4);}
	@Override
	public int sobrevivirAlAmanecer () 
	{return ((resistencia*resistenciaAlSol)/100);}
	
	@Override
	public String tipoAtaque() 
	{
		Scanner scan = new Scanner(System.in);
		while (true) 
		{
			System.out.println("¿Quieres usar una habilidad?");
			System.out.println("  [1] Morder");
			System.out.println("  [2] Volar");
			System.out.println("  [3] Ninguna");
			System.out.print  ("Seleccione una opcion: ");
			int inputIntegerBA = scan.nextInt();
			switch (inputIntegerBA) {
			case 1: 
				return "Morder";
			case 2: 
				return "Volar";
			case 3: 
				return "nada";	
			default:
				System.out.println("[!] [VTA] Valor fuera de rango");
			}
		}
	}
}
