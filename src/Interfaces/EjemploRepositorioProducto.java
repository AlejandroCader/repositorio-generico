package Interfaces;

import Interfaces.Modelo.Producto;
import Interfaces.Repositorio.Direccion;
import Interfaces.Repositorio.Lista.ProductoListRepositorio;
import Interfaces.Repositorio.OrdenablePaginableCrudRepositorio;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {
        OrdenablePaginableCrudRepositorio<Producto> repo = new ProductoListRepositorio();
        repo.crear(new Producto("mesa", 50.52));
        repo.crear(new Producto("silla", 18.0));
        repo.crear(new Producto("lampara", 15.5));
        repo.crear(new Producto("notebook", 50.52));

        List<Producto> productos = repo.listar();
        productos.forEach(System.out::println);
        System.out.println("===== Paginable =====");
        List<Producto> paginable = repo.listar(1, 4);
        paginable.forEach(System.out::println);

        System.out.println("===== Ordernar =====");
        List<Producto> productosOrdenAsc = repo.listar("apellido", Direccion.ASC);
        for (Producto c: productosOrdenAsc){
            System.out.println(c);
        }

        System.out.println("===== Editar =====");
        Producto lamparaActualizar = new Producto("Bea",23.0);
        lamparaActualizar.setId(3);
        repo.editar(lamparaActualizar);
        Producto lampara = (Producto) repo.porId(3);
        System.out.println(lampara);
        System.out.println("==========");
        repo.listar("precio", Direccion.ASC).forEach(System.out::println);

        System.out.println("===== Eliminar =====");
        repo.eliminar(2);
        repo.listar().forEach(System.out::println);
        System.out.println("===== Total =====");
        System.out.println("Total registros: " + repo.total());

    }
}
