package taller03;

public class Minijuego {

	private String nombreMinijuego;
	private int            puntaje;
	private Monstruo      monstruo;
	private String       habilidad;
	
	public Minijuego(String nombreMinijuego, int puntaje, Monstruo monstruo, String habilidad) {
		super();
		this.nombreMinijuego = nombreMinijuego;
		this.puntaje         =         puntaje;
		this.monstruo        =        monstruo;
		this.habilidad       =       habilidad;
	}
	
	public String   getNombreMinijuego() {return nombreMinijuego;}
	public int      getPuntaje()         {return         puntaje;}
	public Monstruo getMonstruo()        {return        monstruo;}
	public String   getHabilidad()       {return       habilidad;}
	
	public void toText() {
		System.out.printf("%-22s | %-5s | %-10s | %-12s | %n",nombreMinijuego,puntaje,monstruo.getClass().getSimpleName(),habilidad);;
	}
}
