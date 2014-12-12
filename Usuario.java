
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

    /**
     * Crea el usuario de la aplicacion. Introduce el nombre
     */
    public Usuario(String nombre)
    {
        // Inicializa las variables con el nombre introducido y las demas a 0
        this.nombre = nombre;
        proteinasIng = 0f;
        carbohidratosIng = 0f;
        grasasIng = 0f;
        caloriasIng = 0f;
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
    }

    /**
     * Metodo para mostrar por pantalla el estado actual del usuario
     */
    public void mostrarDatosUsuario()
    {
        // Imprime por pantalla toda la información almacenada sobre el usuario
        System.out.println("Nombre: " + nombre);
        System.out.println("Gramos de proteinas ingeridos: " + proteinasIng);
        System.out.println("Gramos de carbohidratos ingeridos: " + carbohidratosIng);
        System.out.println("Gramos de grasas ingeridos: " + grasasIng);
        System.out.println("Calorias ingeridas: " + caloriasIng);
    }
}
