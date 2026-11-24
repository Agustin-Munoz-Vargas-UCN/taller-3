package taller03;

public class Jugador 
{

	private String nombre;
	private int   puntaje;
	
	public Jugador(String nombre, int puntaje) 
	{
		super();
		if (puntaje < 0) {puntaje = 0;}
		this.nombre  =  nombre;
		this.puntaje = puntaje;
	}

	public String getNombre() {return nombre ;}
	public int   getPuntaje() {return puntaje;}
	
	public void setPuntaje(int puntaje) {this.puntaje = puntaje;}

	public void toText() {
		System.out.printf("%-22s | %-5s | %n",nombre,puntaje);
	}
}
