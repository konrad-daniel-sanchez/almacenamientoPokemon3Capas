package presentacion;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import logicaNegocio.ArchivosControlador;
import logicaNegocio.Pikachu;
import logicaNegocio.Pokemon;
import logicaNegocio.Raichu;

public class Consola {
    public void iniciar(){
        final String NOMBRE_ARCHIVO = "miJuego.pokemon";
        List<Pokemon> pokemones = new LinkedList<>();
        ArchivosControlador controlador = new ArchivosControlador();
        
        // Lectura de datos desde disco duro:
        Object object = controlador.leer(NOMBRE_ARCHIVO);
        pokemones = (LinkedList<Pokemon>) object;
        
        Scanner lector = new Scanner(System.in);
        System.out.println("Bienvenido al simulador de Pokémon");
        
        int opcion;
        
        do{
            System.out.println("Ingresa la operación");
            System.out.println("1. Adicionar Pokemon a la lista");
            System.out.println("2. Mostrar Pokemones");
            System.out.println("0. Salir");
            opcion = lector.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Selecciona el pokémon");
                    System.out.println("1. Pikachu");
                    System.out.println("2. Raichu");
                    int tipoPokemon = lector.nextInt();
                    switch (tipoPokemon) {
                        case 1:
                            Pikachu pikachu = new Pikachu();
                            pokemones.add(pikachu);
                            break;
                        case 2:
                            Raichu raichu = new Raichu();
                            pokemones.add(raichu);
                            break;
                    }
                    controlador.guardar(pokemones, NOMBRE_ARCHIVO);
                    break;
                case 2:
                    System.out.println("Existen " + pokemones.size() + " pokemones en la lista:");
                    for (Pokemon pokemon : pokemones) {
                        System.out.println(pokemon.getNombre());
                    }
                    break;
            }
        }while(opcion != 0);
    }
}
