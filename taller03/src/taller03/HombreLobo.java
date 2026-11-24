package taller03;

import java.util.Scanner;

public class HombreLobo extends Monstruo
{

	protected int ferocidad;
	protected int faseLunar;
	
	private int maxFerocidad = 100;
	private int maxFaseLunar = 4;
	
	public HombreLobo(int vida, int velocidad, int fuerza, int resistencia, int ferocidad, int faseLunar) 
	{
		super(vida, velocidad, fuerza, resistencia);
		
		if (ferocidad < 1) {ferocidad = 1;}
		if (faseLunar < 1) {faseLunar = 1;}
		
		if (ferocidad > maxFerocidad) {ferocidad = maxFerocidad;}
		if (faseLunar > maxFaseLunar) {faseLunar = maxFaseLunar;}
		
		this.ferocidad = ferocidad;
		this.faseLunar = faseLunar;
	}

	public int getFerocidad() {return ferocidad;}
	public int getFaseLunar() {return faseLunar;}
	
	@Override
	public void toText() {
		System.out.printf("%-10s | VIT: %-3s | VEL: %-3s | FUE: %-3s | RES: %-3s | FER: %-3s | LUN: %-3s | %n","HombreLobo",vida,velocidad,fuerza,resistencia,ferocidad,faseLunar);
	}
	
	@Override
	public int carreraDeCementerio () 
	{return ((velocidad+ferocidad/5)*(faseLunar/4));}
	@Override
	public int cazaDeCalabazas () 
	{return (((ferocidad*faseLunar)/4)+(velocidad/200));}
	@Override
	public int lanzamientoDeLapida () 
	{return (fuerza+ferocidad*faseLunar/8);}
	@Override
	public int sobrevivirAlAmanecer () 
	{return ((resistencia + vida)/2*(5-faseLunar)/4);}
	
	@Override
	public String tipoAtaque() 
	{
		Scanner scan = new Scanner(System.in);
		while (true) 
		{
			System.out.println("¿Quieres usar una habilidad?");
			System.out.println("  [1] Morder");
			System.out.println("  [2] Enfurecerse");
			System.out.println("  [3] Ninguna");
			System.out.print  ("Seleccione una opcion: ");
			int inputIntegerBA = scan.nextInt();
			switch (inputIntegerBA) {
			case 1: 
				return "Morder";
			case 2: 
				return "Enfurecerse";
			case 3: 
				return "nada";	
			default:
				System.out.println("[!] [HTA] Valor fuera de rango");
			}
		}
	}
}
