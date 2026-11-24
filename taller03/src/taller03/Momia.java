package taller03;

import java.util.Scanner;

public class Momia extends Monstruo
{

	protected int longitudVendajes;
	
	private int maxLongitudVendajes = 300;

	public Momia(int vida, int velocidad, int fuerza, int resistencia, int longitudVendajes) 
	{
		super(vida, velocidad, fuerza, resistencia);
		
		if (longitudVendajes < 1) {longitudVendajes = 1;}
		
		if (longitudVendajes > maxLongitudVendajes) {longitudVendajes = maxLongitudVendajes;}
		
		this.longitudVendajes = longitudVendajes;
	}

	public int getLongitudVendajes() {return longitudVendajes;}
	
	@Override
	public void toText() {
		System.out.printf("%-10s | VIT: %-3s | VEL: %-3s | FUE: %-3s | RES: %-3s | LON: %-3s | %n","Zombi",vida,velocidad,fuerza,resistencia,longitudVendajes);
	}
	
	@Override
	public int carreraDeCementerio () 
	{return ((velocidad*100)/(100+longitudVendajes));}
	@Override
	public int cazaDeCalabazas () 
	{return ((longitudVendajes*fuerza)/200);}
	@Override
	public int lanzamientoDeLapida () 
	{return (fuerza+longitudVendajes/10);}
	@Override
	public int sobrevivirAlAmanecer () 
	{return ((resistencia+vida)/2*(1+longitudVendajes/300));}
	
	@Override
	public String tipoAtaque() 
	{
		Scanner scan = new Scanner(System.in);
		while (true) 
		{
			System.out.println("¿Quieres usar una habilidad?");
			System.out.println("  [1] Regenerarse");
			System.out.println("  [2] Enfurecerse");
			System.out.println("  [3] Ninguna");
			System.out.print  ("Seleccione una opcion: ");
			int inputIntegerBA = scan.nextInt();
			switch (inputIntegerBA) {
			case 1: 
				return "Regenerarse";
			case 2: 
				return "Enfurecerse";
			case 3: 
				return "nada";	
			default:
				System.out.println("[!] [MTA] Valor fuera de rango");
			}
		}
	}
}
