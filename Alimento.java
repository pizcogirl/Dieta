
/**
 * Representa tipos de alimentos
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alimento
{
    // Nombre del alimento
    private String nombre;
    // Proteinas por cada 100 gramos del alimento
    private float proteinas;
    // Carbohidratos por cada 100 gramos del alimento
    private float carbohidratos;
    // Grasas por cada 100 gramos del alimento
    private float grasas;
    // Calorias del alimento en funcion de su contenido en proteinas, carbohidratos y grasas
    private float calorias;

    /**
     * Crea un alimento. Introduce su nombre y los 
     * gramos de proteínas, carbohidratos y grasas por cada 100 gramos
     */
    public Alimento(String nombre, float proteinas, float carbohidratos, float grasas)
    {
        // Inicializamos las variables mediante parametros
        this.nombre = nombre;
        this.proteinas = proteinas;
        this.carbohidratos = carbohidratos;
        this.grasas = grasas;
        // Calculamos el valor de las calorias en funcion de las proteinas, carbohidratos
        // y grasas del alimento. Las proteinas y carbohidratos aportan 4 calorias y las grasas
        // aportan 9 calorias
        calorias = ((proteinas + carbohidratos)*4) + (grasas * 9);
    }

    /**
     * Muestra por pantalla la información nutricional del alimento
     */
    public void muestraDatos()
    {
        // Creamos una variable local para almacenar el macronutriente mayoritario y su cantidad
        // para realizar las comparaciones
        float comMayoritario = 0f;
        String nombreMayoritario = null;
        // Lo comparamos con cada componente, si es igual al almacenado, me guarda ambos
        // si es mayor, sustituye lo almacenado por ese
        if (proteinas >= comMayoritario)
        {
            comMayoritario = proteinas;
            nombreMayoritario = "Proteinas";
        }
        if (carbohidratos == comMayoritario)
        {
            nombreMayoritario = nombreMayoritario + " y carbohidratos";
        }
        else if (carbohidratos > comMayoritario)
        {
            comMayoritario = carbohidratos;
            nombreMayoritario = "Carbohidratos";
        }
        if (grasas == comMayoritario)
        {
            nombreMayoritario = nombreMayoritario + " y grasas";
        }
        else if (grasas > comMayoritario)
        {
            comMayoritario = grasas;
            nombreMayoritario = "Grasas";
        }
        // Imprime toda la información nutricional por pantalla
        System.out.println("Nombre: " + nombre);
        System.out.println("Proteinas por cada 100 gramos: " + proteinas);
        System.out.println("Carbohidratos por cada 100 gramos: " + carbohidratos);
        System.out.println("Grasas por cada 100 gramos: " + grasas);
        System.out.println("Calorias: " + calorias);
        System.out.println("Componente/s mayoritario/s: " + nombreMayoritario);
    }
    
    /**
     * Devuelve las proteinas de un alimento por cada 100 gramos
     */
    public float getProteinas()
    {
        return proteinas;
    }
    
      /**
     * Devuelve los carbohidratos de un alimento por cada 100 gramos
     */
    public float getCarbohidratos()
    {
        return carbohidratos;
    }
    
      /**
     * Devuelve las grasas de un alimento por cada 100 gramos
     */
    public float getGrasas()
    {
        return grasas;
    }
    
      /**
     * Devuelve las calorias de un alimento por cada 100 gramos
     */
    public float getCalorias()
    {
        return calorias;
    }
}
