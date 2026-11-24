# taller 03 - "Spooky Season"
Software hecho en Java que simula ser un juego de estrategia y fantasia basado en texto, capaz de guardar una leaderboard en un archivo .txt, conservándolo.

---

## Integrantes
* **Nombre:** Agustín Muñoz | **RUT:** 22.387.587-4 | **Usuario GitHub:** Agustin-Munoz-Vargas-UCN (https://github.com/Agustin-Munoz-Vargas-UCN) | **Carrera:** Ingeniería Civil en Computación e Informática (ICCI)

---

## Estructura del Repositorio


```text
.
├── README.md
├── Agustin-Munoz-Vargas-UCN_POO_Taller03_Eclipse.zip
└── taller03/
    └── src/
        ├── module-info.java
        ├── textos/
        │   ├── Monstruos.txt
        │   ├── Registros.txt
        │   ├── Monstruos (Variante Original).txt
        │   └── Registros (Variante Original).txt
        └── taller03/
            ├── HombreLobo.java
            ├── Jugador.java
            ├── Main.java **
            ├── Minijuego.java
            ├── Momia.java
            ├── Monstruo.java
            ├── Vampiro.java
            └── Zombi.java
```

---

## Clases presentes:

1.   **Jugador**     *(String nombre, int puntaje)*
2.   **Minijuego**   *(String nombreMinijuego, int puntaje, Monstruo monstruo, String habilidad)*
3.   **Monstruo**    *(int vida, int velocidad, int fuerza, int resistencia)*
4.   **HombreLobo**  *(int vida, int velocidad, int fuerza, int resistencia, int        ferocidad, int        faseLunar)* (hijo de Monstruo)
5.   **Vampiro**     *(int vida, int velocidad, int fuerza, int resistencia, int velocidadDeVuelo, int resistenciaAlSol)* (hijo de Monstruo)
7.   **Momia**       *(int vida, int velocidad, int fuerza, int resistencia, int longitudVendajes)* (hijo de Monstruo)
5.   **Zombi**       *(int vida, int velocidad, int fuerza, int resistencia, int  fuerzaDeMordida)* (hijo de Monstruo)
   

---

## Más detalle de las clases:
1.   **Jugador**
     * Cada persona guarda individualmente una serie de datos de cada uno de los integrantes, siendo: el "Nombre del usuario" (String) y el "Puntaje récord del usuario" (Integer), y cada instancia se crea en base al archivo "Registros.txt" y se guardan dentro de un ArrayList llamada "listaJugador".

2.   **Minijuego**
     * Función dedicada a conservar los minijuegos jugados en una sesión de forma individual, conservando el puntaje, tipo de ataque, monstruo, y nombre del juego, funcionando como una base para hacer el historial temporal que se presenta en el programa, y facilitando la suma de puntaje final para determinar si es un record.

3.   **Monstruo**
     * Funciona como base para sus clases hija, permitiendo-las guardarse en un mismo arreglo (ArrayList llamado "listaMonstruo", y el cual se genera en base al contenido de "Monstruos.txt", descartando entradas erróneas, y ajustando algunas con valores fuera de los rangos permitidos, pero con estructuras "correctas"), y guardando cualidades comunes de los monstruos, vida, velocidad, fuerza y resistencia (todo Integer).

4.   **HombreLobo, Vampiro, Momia y Zombi**
     * Clases hijas de "Monstruo", cada una compartiendo los métodos correspondientes del calculo de puntaje de cada minijuego, la acción de elegir uno de dos ataques y la transcripción de la instancia a texto, pero cada uno comportándose de forma diferente, ajustándose a la clase, estadísticas y elecciones del usuario.
       
---

## Opciones disponibles:
Bajo la naturaleza del juego, inicialmente tienes que ingresar un Username para conservar tu progreso, si no existe, te creara un perfil, si ya existe, te cargara el usuario correspondiente.
Luego tendrás una oportunidad para jugar cada uno de los minijuegos (después de cada intento, el monstruo usado sera bloqueado, y el minijuego elegido no podrá ser elegido hasta iniciar sesión de bueno.)
Si hay menos de 4 monstruos disponibles en la "listaMonstruo", el juego lo notificara, y en caso de que no quede ninguno, el juego no permitirá elegir los minijuegos.

```text
Inicio de secciona:
Ingresar usuario:

Menú principal:
  [1] Jugar un minijuego         //Cada minijuego tiene un indicador que puede decir false (minijuego disponible) o true (minijuego no disponible)
     [1] Carrera del Cementerio
     [2] Caza de Calabazas
     [3] Lanzamiento de Lápidas
     [4] Sobrevivir al Amanecer
     [5] Volver al menú principal
  [2] Ver catálogo de monstruos
  [3] Ver historial de la sesión
  [4] Ver ranking de jugadores    //El ranking no se actualiza hasta terminar la sesión [5] o salir [6] (Siempre en cuando el puntaje supere el ultimo récord)
  [5] Terminar sesión
  [6] Salir
```

---

## Estructuras de Datos y Decisiones Técnicas

El proyecto presente utilizo Programación Orientada a Objetos (POO) y ArrayList, manejándose de esta forma:

1. **Lista monstruos (ArrayList<Monstruo> listaMonstruo):**
   * Maneja los monstruos que se encuentran presentes en el archivo "Monstruos.txt", se rellena automáticamente y se modifica de forma volátil con el paso de las acciones, eliminando los monstruos usados, pero no modifica el archivo "Monstruos.txt", cargando los monstruos eliminados cada vez que se inicia sesión de vuelta, reiniciando la lista.
   * No tiene un limite de elementos conocidos.
     
2. **Lista jugador (ArrayList<Jugador> listaJugador):**
   * Maneja los jugadores que se encuentran presentes en el archivo "Registros.txt", se rellena automáticamente y se modifica con el paso de las acciones, creando e integrando nuevos jugadores, modificando el archivo "Registros.txt" cada vez que se supera un récord al terminar sesión [5] o salir [6].
   * No tiene un limite de elementos conocidos.

3. **Lista jugador (ArrayList<Jugador> listaMinijuego):**
   * Se encarga de guardar el historial de la sesión, conservando el puntaje individual hecho en cada minijuego, con que monstruo se jugo, que ataque utilizo y que minijuego jugo, reiniciándose cada vez que se terminar sesión [5] o se sale [6].
   * No tiene un limite de elementos conocidos, pero solo se llegan a utilizar cuatro slots (El numero total de minijuegos existentes).
---

## Requisitos del Entorno

* Se requiere una computadora con Java instalado previamente.
* Es preferible el uso de alguna versión de "Eclipse IDE" para ejecutarlo

---

## Instrucciones de Ejecución

### Eclipse IDE.

- Descargue el archivo "Agustin-Munoz-Vargas-UCN_POO_Taller03_Eclipse.zip"

- Abra Eclipse y dele a "Importar"

- Seleccione "General/Archive File"

- Busque el archivo descargado "Agustin-Munoz-Vargas-UCN_POO_Taller03_Eclipce.zip" y selecciónelo y continué.

- Ya con el proyecto iniciado, dele a la carpeta raíz, clic derecho, "Run As/Java aplication" 

- Y con eso el archivo tendría que estar ejecutándose en Eclipse.
  
```text
Si después de terminar un ciclo el programa empieza a dar vueltas deforma infinita, el problema es... no se, se supone que debería lanzar un mensaje de error escrito en la linea 442 de "Main.java". Aunque esto lo comento mas ya que, a la hora de remplazar el "throw" con un "syso println", empieza el bucle en caso de falla. Se intento arreglar, pero no se llego a un final satisfactorio. De todas formas siento que usted solo debería ignorar esta linea...
```
---
## Manejo de Casos Borde y Validaciones

* **Control de Archivo:** Si no esta disponible, el programa tirara un aviso, y no sera capaz de funcionar por su cuenta ya que no van a haber monstruos disponibles, en caso de que unicamente falte "Registros.txt", sera capaz de generarlo de forma independiente.
* **Fallas a la hora de ingresar inputs:** Si se presenta un argumento de formato incorrecto durante la navegación de los menús, el programa tirara un "throw new IllegalArgumentException" y se cerrara sin guardar los cambios.
* **Guardado de archivos:** Unicamente se guardan los cambios si hay un récord y si se terminar sesión [5] o se sale [6], sobrescribiendo el ArrayList "listaJugador" en "Registros.txt", eliminando entradas mal escritas, y estandarizando las que se lograron escribir.
