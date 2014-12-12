
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
        // Calcula el total de macronutrientes ingeridos por usuario
        float totalMacro = proteinasIng + carbohidratosIng + grasasIng;
        // Si el total es 0 (aun no ha comido nada), imprime un mensaje sin porcentajes
        if (totalMacro == 0)
        {
            // Imprime por pantalla toda la información almacenada sobre el usuario
            System.out.println("Nombre: " + nombre);
            System.out.println("Gramos de proteinas ingeridos: " + proteinasIng);
            System.out.println("Gramos de carbohidratos ingeridos: " + carbohidratosIng);
            System.out.println("Gramos de grasas ingeridos: " + grasasIng);
            System.out.println("Calorias ingeridas: " + caloriasIng);
        }
        // Si no es 0, calcula el % de cada macronutriente sobre el total y lo muestra en el mensaje
        else
        {
            // Imprime por pantalla toda la información almacenada sobre el usuario
            System.out.println("Nombre: " + nombre);
            System.out.println("Gramos de proteinas ingeridos: " + proteinasIng + "(" + ((proteinasIng/totalMacro)*100) + "%)");
            System.out.println("Gramos de carbohidratos ingeridos: " + carbohidratosIng + "(" + ((carbohidratosIng/totalMacro)*100) + "%)");
            System.out.println("Gramos de grasas ingeridos: " + grasasIng + "(" + ((grasasIng/totalMacro)*100) + "%)");
            System.out.println("Calorias ingeridas: " + caloriasIng);
        }
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
}
