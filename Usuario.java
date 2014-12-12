import java.util.ArrayList;

/**
 * Representa a un usuario que usa la aplicacion de dietas
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Usuario
{
    // Nombre del usuario de la aplicacion
    private String nombre;
    // Proteinas totales ingeridas por el usuario
    private float proteinasIng;
    // Carbohidratos totales ingeridos por el usuario
    private float carbohidratosIng;
    // Grasas totales ingeridas por el usuario
    private float grasasIng;
    // Calorias totales ingeridas por el usuario
    private float caloriasIng;
    // Almacena el nombre del alimento más calorico por cada 100 gramos consumido por el usuario
    private String nombreCalorico;
    // Almacena la cantidad de calorias por cada 100 gramos del alimento más calorico consumido por el usuario
    private float caloriasAliCalorico;
    // Lista de los alimentos consumidos por el usuario
    private ArrayList<Alimento> listaAlimentos;

    /**
     * Crea el usuario de la aplicacion. Introduce el nombre
     */
    public Usuario(String nombre)
    {
        // Inicializa las variables con el nombre introducido y las demas a 0 o null
        this.nombre = nombre;
        proteinasIng = 0f;
        carbohidratosIng = 0f;
        grasasIng = 0f;
        caloriasIng = 0f;
        nombreCalorico = null;
        caloriasAliCalorico = 0f;
        // Inicializamos la ArrayList vacia
        listaAlimentos = new ArrayList<Alimento>();
    }

    /**
     * Metodo para comer un alimento. Introduce el alimento a ingerir y cuantos gramos del mismo
     */
    public void comer(Alimento alimento, float gramos)
    {
        // Calcula la cantidad de proteinas, carbohidratos, grasas y calorias ingeridas por el usuario
        // en funcion del alimento y los gramos ingeridos, y los suma a cada atributo. Dividimos los gramos
        // por 100 ya que en los alimentos guardamos las cantidades para bloques de 100 gramos
        proteinasIng = proteinasIng + ((gramos/100)*alimento.getProteinas());
        carbohidratosIng = carbohidratosIng + ((gramos/100)*alimento.getCarbohidratos());
        grasasIng = grasasIng + ((gramos/100)*alimento.getGrasas());
        caloriasIng = caloriasIng + ((gramos/100)*alimento.getCalorias());
        // Ahora comparamos las calorias del alimento ingerido ahora con las almacenadas del alimento más calorico
        // que hayamos tomado hasta ahora. Si es mayor, guardamos el nuevo como el más calorico. Sino no hacemos nada
        if (alimento.getCalorias() > caloriasAliCalorico)
        {
            caloriasAliCalorico = alimento.getCalorias();
            nombreCalorico = alimento.getNombre();
        }
        // Añadimos el alimento que hemos ingerido a la lista de alimentos
        listaAlimentos.add(alimento);
    }

    /**
     * Metodo para mostrar por pantalla el estado actual del usuario
     */
    public void mostrarDatosUsuario()
    {
        // Calcula el total de macronutrientes ingeridos por usuario
        float totalMacro = proteinasIng + carbohidratosIng + grasasIng;

        // Imprime por pantalla toda la información almacenada sobre el usuario. Si ha ingerido
        // alguna cantidad de cada macronutriente, mostrara por pantalla el % del total de macronutrientes
        // ingeridos que representa, sino solo mostrara un 0
        System.out.println("Nombre: " + nombre);
        if (proteinasIng != 0)
        {
            System.out.println("Gramos de proteinas ingeridos: " + proteinasIng + "(" + ((proteinasIng/totalMacro)*100) + "%)");
        }
        else
        {
            System.out.println("Gramos de proteinas ingeridos: " + proteinasIng);
        }
        if (carbohidratosIng != 0)
        {
            System.out.println("Gramos de carbohidratos ingeridos: " + carbohidratosIng + "(" + ((carbohidratosIng/totalMacro)*100) + "%)");
        }
        else
        {
            System.out.println("Gramos de carbohidratos ingeridos: " + carbohidratosIng);
        }
        if (grasasIng != 0)
        {
            System.out.println("Gramos de grasas ingeridos: " + grasasIng + "(" + ((grasasIng/totalMacro)*100) + "%)");
        }
        else
        {
            System.out.println("Gramos de grasas ingeridos: " + grasasIng);
        }
        System.out.println("Calorias ingeridas: " + caloriasIng);
    }

    /**
     * Devuelve las calorias consumidas hasta ahora por el usuario
     */
    public float getCalorias()
    {
        return caloriasIng;
    }

    /**
     * Devuelve el nombre del usuario del programa
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * Metodo para comparar la ingesta de calorias entre dos usuarios. Introduce el usuario con el que compararte
     */
    public void comparaUsuarios(Usuario usuario)
    {
        // Almacenamos las calorias del segundo usuario para compararlas con las nuestras
        float caloriasOtroUsuario = usuario.getCalorias();
        // Almacenamos tambien el nombre del segundo usuario para mostrar despues por pantalla
        String nombreOtroUsuario = usuario.getNombre();
        // Dependiendo de quien haya ingerido más calorias, imprimimos el mensaje correspondiente por pantalla
        if (caloriasIng > caloriasOtroUsuario)
        {
            System.out.println(nombre + " ha ingerido más calorias que " + nombreOtroUsuario);
        }
        else if (caloriasOtroUsuario > caloriasIng)
        {
            System.out.println(nombreOtroUsuario + " ha ingerido más calorias que " + nombre);
        }
        else
        {
            System.out.println(nombre + " y " + nombreOtroUsuario + " han ingerido las mismas calorias");
        }
    }

    /**
     * Visualiza por pantalla el alimento más calorico consumido hasta ahora por el usuario
     */
    public void visualizaCalorico()
    {
        // Si hemos comido ya algo, mostrara el alimento más calorico consumido hasta ahora. Si no hemos comido aun, no mostrara nada
        if (nombreCalorico != null)
        {
            System.out.println("Alimento más calórico ingerido por el usuario hasta el momento: " + nombreCalorico);
        }
    }

    /**
     * Permite visualizar los datos nutricionales por cada 100 gramos de cualquier alimento previamente
     * ingerido, introduciendo su posición de ingesta
     */
    public void mostrarDatosNutricionales(int index)
    {
        // Si el indice introducido es valido, mostrara los datos nutricionales del alimento
        if ((index >= 0) && (index < listaAlimentos.size()))
        {
            Alimento alimentoAMostrar = listaAlimentos.get(index);
            alimentoAMostrar.muestraDatos();
        }
        // Si es un indice no valido, muestra un mensaje de error
        else
        {
            System.out.println("El indice introducido no es valido");
        }
    }
}
