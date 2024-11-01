package Ejercicio3;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private Spotify spotify;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.spotify = new Spotify();
    }

    public void iniciar() {
        System.out.print("Ingrese su tipo de cuenta (Básico/Premium): ");
        String tipoCuenta = scanner.nextLine();
        spotify.setTipoCuenta(tipoCuenta); //crea la lista asociada a la cuenta
        System.out.println(spotify.getTipoCuenta());

        boolean salir = false;

        while (!salir) {
            int opcion = mostrarMenuPrincipal(); // Mostrar menú y obtener la opción del usuario

            switch (opcion) {

                case 1: // Reproducir canción
                    if (spotify.getListaUsuario()!= null) {
                        System.out.println(spotify.reproducirCancion());
                    } else {
                        System.out.println("Ingrese una lista valida.");
                    }
                    break;

                case 2: // Cambiar de canción
                    if (spotify.getListaUsuario() != null) {
                        System.out.println(spotify.cambiarDeCancion());
                    } else {
                        System.out.println("Ingrese una lista valida.");
                    }
                    break;

                case 3: // Añadir canción a lista usuario
                    System.out.println(spotify.agregarCancionUsuario());
                    break;

                case 4: // Eliminar canción
                    if(spotify.getListaUsuario() != null){
                        System.out.println(spotify.eliminarCancion());
                    }else{
                        System.out.println("Ingrese una lista valida.");
                    }
                    break;

                case 5: // Ver lista de reproducción
                    if (spotify.getListaUsuario() != null) {
                        System.out.println(spotify.verCancionesUsuario());
                    } else {
                        System.out.println("Ingrese una lista valida.");
                    }
                    break;

                case 6: // reproducir lista hasta que decida
                    if (spotify.getListaUsuario() != null) {
                        spotify.reproducirListaHastaQueDecida();
                    } else {
                        System.out.println("Ingrese una lista valida.");
                    }
                    break;

                case 7: // añadir canciones al catalogo de Spotify
                    Cancion nuevaCancion = crearCancion(); // Crea nueva canción
                    System.out.println(spotify.agregarCancionCatalogo(nuevaCancion));
                    break;

                case 8: // Salir
                    salir = true;
                    System.out.println("Gracias por usar el programa.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }

    // Método para mostrar el menú principal
    public int mostrarMenuPrincipal() {
        System.out.println("\n--- Menú Principal ---");
        System.out.println("1. Reproducir cancion (cuenta básica: sólo 1er canción - cuenta Premium: podrá elegir la canción)");
        System.out.println("2. Cambiar a otra canción");
        System.out.println("3. Añadir canción a su lista");
        System.out.println("4. Eliminar canción de su lista");
        System.out.println("5. Ver lista de reproducción");
        System.out.println("6. Reproducir lista");
        System.out.println("7. Añadir más canciones al catálogo de Spotify");
        System.out.println("8. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    // Método para seleccionar una canción desde la lista
    public int seleccionarCancion() {
        System.out.print("Elige una canción (número): ");
        return scanner.nextInt() - 1; // Ajustar índice a base 0
    }

    // Método para añadir una nueva canción
    public Cancion crearCancion() {
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Ingrese el nombre de la canción: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la duración de la canción (en minutos): ");
        double duracion = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Ingrese el género de la canción: ");
        String genero = scanner.nextLine();
        GeneroMusical generoMusical = convertirAGeneroMusical(genero);

        System.out.println("¿La cancion tiene un artista invitado? Coloque 'si' o 'no': ");
        String tieneInvitados = scanner.nextLine();

        if(!tieneInvitados.equalsIgnoreCase("si") && !tieneInvitados.equalsIgnoreCase("no")){
            System.out.println("Ha seleccionado una opcion invalida. Se asumira que la cancion no tiene artistas invitados.");
        }

        Album album = crearAlbum();
        Artista artistaInvitado;
        Cancion cancion;

        if(tieneInvitados.equalsIgnoreCase("si")){
            System.out.println("Por ultimo, vamos a cargar los datos del artista invitado: ");
            artistaInvitado = crearArtista();
            cancion = new Cancion(album, artistaInvitado, duracion, generoMusical, nombre );
        }else{
            cancion = new Cancion(album, duracion, generoMusical, nombre );
        }

        return cancion;
    }

    public Album crearAlbum(){
        System.out.println("Ingrese el anio de publicacion del album: ");
        int anio = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Ingrese el titulo del album: ");
        String titulo = scanner.nextLine();

        Artista artista = crearArtista();

        Album album = new Album(anio, artista, titulo);

        return album;
    }

    public Artista crearArtista(){
        System.out.println("Ingrese nombre del artista: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la edad del artista: ");
        int edad = scanner.nextInt();

        scanner.nextLine(); //

        System.out.println("Ingrese la nacionalidad del artista: ");
        String nacionalidad = scanner.nextLine();

        Artista artista = new Artista(edad, nacionalidad, nombre);

        return artista;
    }

    private GeneroMusical convertirAGeneroMusical(String genero) {

        for (GeneroMusical g : GeneroMusical.values()) {
            if (g.name().equalsIgnoreCase(genero)) {
                return g;
            }
        }
        System.out.println("Género inválido. Se asignará el género ROCK por defecto.");
        return GeneroMusical.ROCK; // Valor por defecto
    }
}
