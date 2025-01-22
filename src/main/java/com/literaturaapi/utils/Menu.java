package com.literaturaapi.utils;

//import com.literaturaapi.services.BibliotecaService;
import com.literaturaapi.services.GutendexAPIService;
import com.literaturaapi.repositories.LibroRepository;

import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);
    private static final GutendexAPIService gutendexAPIService = new GutendexAPIService();
    private static final LibroRepository libroRepository = new LibroRepository();

    public static void mostrarMenu() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n=== Menú ===");
            System.out.println("1. Buscar libro por título");
            System.out.println("2. Listar libros registrados");
            System.out.println("3. Listar autores registrados");
            System.out.println("4. Listar autores vivos en un determinado año");
            System.out.println("5. Listar libros por idioma");
            System.out.println("6. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> buscarLibroPorTitulo();
                case 2 -> listarLibrosRegistrados();
                case 3 -> listarAutoresRegistrados();
                case 4 -> listarAutoresVivos();
                case 5 -> listarLibrosPorIdioma();
                case 6 -> salir = true;
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private static void buscarLibroPorTitulo() {
        System.out.print("Ingrese el título: ");
        String titulo = scanner.nextLine();
        gutendexAPIService.buscarLibroPorTitulo(titulo);
    }

    private static void listarLibrosRegistrados() {
        libroRepository.listarLibros().forEach(System.out::println);
    }

    private static void listarAutoresRegistrados() {
        // Implementar lógica en AutorRepository
    }

    private static void listarAutoresVivos() {
        // Implementar lógica de filtro
    }

    private static void listarLibrosPorIdioma() {
        // Implementar menú de idiomas y lógica
    }
}
