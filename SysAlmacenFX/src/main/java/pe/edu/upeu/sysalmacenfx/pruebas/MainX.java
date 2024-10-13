package pe.edu.upeu.sysalmacenfx.pruebas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.upeu.sysalmacenfx.modelo.Categoria;
import pe.edu.upeu.sysalmacenfx.repositorio.CategoriaRepository;

import java.util.Scanner;

@Component
public class MainX {
    @Autowired
    private CategoriaRepository repository;
    private boolean exit = false;
    private final Scanner mary = new Scanner(System.in);

    private void mostrarMenu() {
        System.out.println("|------------------------------------------|");
        System.out.println("| 1. Crear---------------------------------|");
        System.out.println("| 2. Actualizar----------------------------|");
        System.out.println("| 3. Listar--------------------------------|");
        System.out.println("| 4. Eliminar------------------------------|");
        System.out.println("| 5. Salir---------------------------------|");
        System.out.println("|------------------------------------------|");
        System.out.print("Seleccione una opción: ");
    }

    public void registro() {
        Categoria categoria = new Categoria();
        System.out.print("Nuevo nombre: ");
        String nombre = mary.nextLine();
        categoria.setNombre(nombre);
        Categoria categoriaGuardada = repository.save(categoria);
        System.out.println("Categoría registrada: ");
        System.out.println(categoriaGuardada.getIdCategoria() + " - " + categoriaGuardada.getNombre());
    }

    public void actualizarCategoria() {
        System.out.println("Actualizar Categoría");
        System.out.print("Ingrese el ID de la categoría a actualizar: ");
        int idCategoria = mary.nextInt();
        mary.nextLine();

        System.out.print("Nuevo nombre: ");
        String nuevoNombre =mary.nextLine();

        Categoria categoria = repository.findById((long) idCategoria).orElse(null);

        if (categoria != null) {
            categoria.setNombre(nuevoNombre);
            Categoria categoriaActualizada = repository.save(categoria);
            System.out.println("Categoría actualizada: ");
            System.out.println(categoriaActualizada.getIdCategoria() + " - " + categoriaActualizada.getNombre());
        } else {
            System.out.println("Categoría no encontrada.");
        }
    }

    public void listar() {
        System.out.println("Listado de Categorías:");
        for (Categoria categoria : repository.findAll()) {
            System.out.println(categoria.getIdCategoria() + " - " + categoria.getNombre());
        }
    }

    public void opcionesEliminar() {
        System.out.println("|------------------------------------------|");
        System.out.println("| 1. Eliminar una categoría----------------|");
        System.out.println("| 2. Eliminar todas las categorías---------|");
        System.out.println("| 3. Volver al menú------------------------|");
        System.out.println("|------------------------------------------|");
        System.out.print("Seleccione una opción: ");

        int opcion = mary.nextInt();
        mary.nextLine();

        switch (opcion) {
            case 1 -> eliminarUnaCategoria();
            case 2 -> eliminarTodasCategorias();
            case 3 -> System.out.println("Volviendo al menú principal.");
            default -> System.out.println("Opción no válida, volviendo al menú.");
        }
    }

    public void eliminarUnaCategoria() {
        System.out.println("Eliminar Categoría");
        System.out.print("Selecciona el ID de la categoría a eliminar: ");
        Long idCategoria = mary.nextLong();
        mary.nextLine();

        if (repository.existsById(idCategoria)) {
            repository.deleteById(idCategoria);
            System.out.println("Categoría con ID " + idCategoria + " eliminada.");
        } else {
            System.out.println("Categoría no encontrada.");
        }
    }

    public void eliminarTodasCategorias() {
        System.out.println("¿Estás seguro de que deseas eliminar todas las categorías? (si/no)");
        String confirmacion = mary.nextLine();

        if (confirmacion.equalsIgnoreCase("si")) {
            repository.deleteAll();
            System.out.println("Todas las categorías han sido eliminadas.");
        } else {
            System.out.println("Operación cancelada.");
        }
    }

    public void salir() {
        System.out.print("Saliendo del sistema ");

        for (int i = 0; i < 20; i++) {
            System.out.print(".");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("Error en el temporizador.");
            }
        }
        System.out.println(" ¡Felicidades Proceso Completado 😊🌟✨!");
        exit = true;
    }

    public void menu() {
        do {
            mostrarMenu();
            int opc = mary.nextInt();
            mary.nextLine();

            switch (opc) {
                case 1 -> registro();
                case 2 -> actualizarCategoria();
                case 3 -> listar();
                case 4 -> opcionesEliminar();
                case 5 -> salir();
                default -> System.out.println("Opción no válida ❌❌❌, por favor intente nuevamente.");
            }
        } while (!exit);
    }
}
