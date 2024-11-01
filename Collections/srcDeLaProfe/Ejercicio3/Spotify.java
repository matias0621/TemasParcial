package Ejercicio3;

import java.util.ArrayList;
import java.util.Scanner;

public class Spotify {

    private ArrayList<Cancion> canciones;
    private ListaBasica listaBasica;
    private ListaPremium listaPremium;
    private String tipoCuenta;


    public Spotify() {
        this.canciones = new ArrayList<>(); // solo crea el catalogo, las otras listaslas crea al setear la cuenta

/// HARCODEO ALGUNAS CANCIONES PARA AGREGAR AL CATALOGO DE SPOTIFY
        Artista s= new Artista(14, "argentinos", "Soda Stéreo");
        Album m= new Album(1997, s,"Soda Stereo Ultimo Concierto");

        canciones.add(new Cancion(m, 4.5, GeneroMusical.ROCK, "En la ciudad de la Furia"));
        canciones.add(new Cancion(m,3.5, GeneroMusical.ROCK, "El rito"));
        canciones.add(new Cancion(m,5.5, GeneroMusical.ROCK, "Trátame suavemente"));
        canciones.add(new Cancion(m,4.5, GeneroMusical.ROCK, "Zoom"));
        canciones.add(new Cancion(m,4.1, GeneroMusical.ROCK, "Lo que sangra (La cúpula)"));
    }


    public String setTipoCuenta(String tipoCuenta) {
        String mensaje = "";
        if (!tipoCuenta.equalsIgnoreCase("Basico") && !tipoCuenta.equalsIgnoreCase("Premium")) {
            mensaje = "Tipo de cuenta no válido. Debe ser 'Básico' o 'Premium'.";
        } else {
            this.tipoCuenta = tipoCuenta;
            inicializarLista();
            mensaje = "Tipo de cuenta cargado con exito!";
        }
        return mensaje;
    }

    private void inicializarLista() {
        if (tipoCuenta.equalsIgnoreCase("Basico")) {
            this.listaBasica = new ListaBasica("Mi Lista Básica");
            this.listaPremium = null;
        } else if (tipoCuenta.equalsIgnoreCase("Premium")) {
            this.listaPremium = new ListaPremium("Mi Lista Premium");
            this.listaBasica = null;
        }
    }

    // Método para añadir canción a la lista de cada usuario
    public String agregarCancionUsuario() {
        String mensaje= "";

        System.out.println(verCancionesCatalogo());

        Scanner scanner= new Scanner(System.in);
        System.out.print("Elige el número de canción a agregar: ");// Solicitar selección de canción
        int indiceCancion = scanner.nextInt()-1; // Ajustar índice a base 0
        scanner.nextLine();

        if (indiceCancion >= 0 && indiceCancion < canciones.size()) {
            Cancion cancion= canciones.get(indiceCancion);
            if (tipoCuenta.equalsIgnoreCase("basico")) {
                listaBasica.añadirCancion(cancion);
            }
            if (tipoCuenta.equalsIgnoreCase("premium")) {
                listaPremium.añadirCancion(cancion);
            }
            mensaje= "Cancion agregada con exito! ";
        }
        else {
            mensaje = "Selección inválida.";
        }
        return mensaje;
    }


    // Método para añadir canción al ArrayList general de canciones
    public String agregarCancionCatalogo(Cancion cancion) {
        canciones.add(cancion);
        return "Cancion agregada con exito! ";
    }


    public String verCancionesCatalogo() {
        String mensaje= "";

        for (int i = 0; i < canciones.size(); i++) {
            mensaje += i + 1 + ". " + canciones.get(i).toString() + " \n";
        }
        return mensaje;
    }


    public String getTipoCuenta() {
        return tipoCuenta;
    }


    // Método para acceder a la lista de reproducción del usuario
    public ListaDeCanciones getListaUsuario() {
        if (tipoCuenta.equalsIgnoreCase("basico")) {
            return listaBasica;
        } else if (tipoCuenta.equalsIgnoreCase("Premium")) {
            return listaPremium;
        }
        return null;
    }


    public String eliminarCancion() {
        String mensaje = "";

        if (tipoCuenta.equalsIgnoreCase("basico")) {
            mensaje = listaBasica.eliminarCancion(0); // dice que pague Premium
        }
        if (tipoCuenta.equalsIgnoreCase("premium")) {
            Scanner scanner= new Scanner(System.in);

            System.out.println(listaPremium.verMiLista()); //le muestro la lista para que elija

            System.out.print("Elige el número de canción a borrar: ");// Solicitar selección de canción
            int indiceCancion = scanner.nextInt() - 1; // Ajustar índice a base 0
            scanner.nextLine();

            mensaje= listaPremium.eliminarCancion(indiceCancion);
        }
        return mensaje;

    }

    public String reproducirCancion() {
        String mensaje = "";

        if (tipoCuenta.equalsIgnoreCase("basico")) {
            mensaje = listaBasica.reproducir(0); // solo puede reproducir la 1ra
        }
        if (tipoCuenta.equalsIgnoreCase("premium")) { // permite elegir cancion a reproducir
            Scanner scanner= new Scanner(System.in);

            System.out.println(listaPremium.verMiLista()); //le muestro la lista para que elija

            System.out.print("Elige el número de canción a reproducir: ");// Solicitar selección de canción
            int indiceCancion = scanner.nextInt() - 1; // Ajustar índice a base 0
            scanner.nextLine();

            mensaje= listaPremium.reproducir(indiceCancion);
        }

        return mensaje;
    }


    public String cambiarDeCancion() {
        String mensaje = "";

        if (tipoCuenta.equalsIgnoreCase("basico")) {
            mensaje = listaBasica.cambiarCancion(); // mensaje de que pague Premium
        }
        if (tipoCuenta.equalsIgnoreCase("premium")) {
            mensaje = reproducirCancion(); // permite elegir cancion a reproducir
        }
        return mensaje;
    }


    public void reproducirListaHastaQueDecida() {
        Scanner scanner = new Scanner(System.in);
        char seguir = 's';
        int i= 0;

        while (seguir != 'p') {
            if (tipoCuenta.equalsIgnoreCase("basico")) {
                System.out.println(listaBasica.reproducir(0) + "\n"); // reproduce siempre la 1ra y la manda al final
            }
            if (tipoCuenta.equalsIgnoreCase("premium")) {
                if (i >= listaPremium.getMiLista().size()) {
                    System.out.println("Ya llegó al final de la lista\n");
                    return;
                } else {
                    System.out.println(listaPremium.reproducir(i) + "\n"); // permite elegir cancion a reproducir
                    i++;
                }
            }
            System.out.println("Desea continuar reproduciendo? (s para sí, p para parar)");
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                seguir = input.charAt(0);
            } else {
                System.out.println("Entrada inválida, se asume que desea salir.");
                seguir = 'p';
            }
        }

    }


    public String verCancionesUsuario() {
        String mensaje = "";

        if (tipoCuenta.equalsIgnoreCase("basico")) {
            mensaje = listaBasica.verMiLista();
        }
        if (tipoCuenta.equalsIgnoreCase("premium")) {
            mensaje = listaPremium.verMiLista();
        }
        return mensaje;
    }



}
