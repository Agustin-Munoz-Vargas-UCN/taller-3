package taller03;

public class Monstruo {

	protected int        vida;
	protected int   velocidad;
	protected int      fuerza;
	protected int resistencia;
	
	private int maxVida        = 200;
	private int maxVelocidad   = 100;
	private int maxFuerza      = 100;
	private int maxResistencia = 100;
	
	public Monstruo(int vida, int velocidad, int fuerza, int resistencia) 
	{
		super();
		
		if (vida        < 1) {vida        = 1;}
		if (velocidad   < 1) {velocidad   = 1;}
		if (fuerza      < 1) {fuerza      = 1;}
		if (resistencia < 1) {resistencia = 1;}
		
		if (vida        >        maxVida) {vida        =        maxVida;}
		if (velocidad   >   maxVelocidad) {velocidad   =   maxVelocidad;}
		if (fuerza      >      maxFuerza) {fuerza      =      maxFuerza;}
		if (resistencia > maxResistencia) {resistencia = maxResistencia;}
		
		this.vida        =        vida;
		this.velocidad   =   velocidad;
		this.fuerza      =      fuerza;
		this.resistencia = resistencia;
	}

	public int getVida()        {return        vida;}
	public int getVelocidad()   {return   velocidad;}
	public int getFuerza()      {return      fuerza;}
	public int getResistencia() {return resistencia;}
	
	public void toText() {
		System.out.printf("%-10s | VIT: %-3s | VEL: %-3s | FUE: %-3s | RES: %-3s | %n","Monstruo",vida,velocidad,fuerza,resistencia);;
	}
	
	public int carreraDeCementerio () 
	{return 0;}
	public int cazaDeCalabazas () 
	{return 0;}
	public int lanzamientoDeLapida () 
	{return 0;}
	public int sobrevivirAlAmanecer () 
	{return 0;}
	
	public String tipoAtaque() {return null;}
	
	public int playMinigame (String minijuego, String tipoAtaque) 
	{
		int puntos = 0;
		String tipoMinijuego = "";
		switch (minijuego)
		{
			case "carreraDeCementerio":	
				puntos = carreraDeCementerio();
				tipoMinijuego = "Volar";
				break;
			case "cazaDeCalabazas":
				puntos = cazaDeCalabazas();
				tipoMinijuego = "Morder";
				break;
			case "lanzamientoDeLapida":
				puntos = lanzamientoDeLapida();
				tipoMinijuego = "Enfurecerse";
				break;
			case "sobrevivirAlAmanecer":
				puntos = sobrevivirAlAmanecer();
				tipoMinijuego = "Regenerarse";
				break;
			default:
				System.out.println("[!] [MPM] Huh?");
		}
		System.out.println(puntos);
		if (tipoMinijuego.equalsIgnoreCase(tipoAtaque)) 
		{puntos = (int)(puntos*(1.5));}
		
		return puntos;
	}
}
