package taller03;

import java.util.Scanner;

public class Zombi extends Monstruo
{
	protected int fuerzaDeMordida;
	
	private int maxFuerzaDeMordida = 100;

	public Zombi(int vida, int velocidad, int fuerza, int resistencia, int fuerzaDeMordida) 
	{
		super(vida, velocidad, fuerza, resistencia);
		
		if (fuerzaDeMordida < 1) {fuerzaDeMordida = 1;}
		
		if (fuerzaDeMordida > maxFuerzaDeMordida) {fuerzaDeMordida = maxFuerzaDeMordida;}
		
		this.fuerzaDeMordida = fuerzaDeMordida;
	}

	public int getFuerzaDeMordida() {return fuerzaDeMordida;}
	
	@Override
	public void toText() {
		System.out.printf("%-10s | VIT: %-3s | VEL: %-3s | FUE: %-3s | RES: %-3s | MOR: %-3s | %n","Zombi",vida,velocidad,fuerza,resistencia,fuerzaDeMordida);
	}
	
	@Override
	public int carreraDeCementerio () 
	{return ((velocidad*resistencia)/100);}
	@Override
	public int cazaDeCalabazas () 
	{return (((fuerzaDeMordida*vida)/100) + (resistencia/2));}
	@Override
	public int lanzamientoDeLapida () 
	{return ((fuerza*resistencia)/100);}
	@Override
	public int sobrevivirAlAmanecer () 
	{return ((resistencia*vida)/100);}
	
	@Override
	public String tipoAtaque() 
	{
		Scanner scan = new Scanner(System.in);
		while (true) 
		{
			System.out.println("¿Quieres usar una habilidad?");
			System.out.println("  [1] Morder");
			System.out.println("  [2] Regenerarse");
			System.out.println("  [3] Ninguna");
			System.out.print  ("Seleccione una opcion: ");
			int inputIntegerBA = scan.nextInt();
			switch (inputIntegerBA) {
			case 1: 
				return "Morder";
			case 2: 
				return "Regenerarse";
			case 3: 
				return "nada";	
			default:
				System.out.println("[!] [ZTA] Valor fuera de rango");
			}
		}
	}
}
