package Interfaces.Repositorio.Lista;
import Interfaces.Modelo.Producto;
import Interfaces.Repositorio.AbstractaListRepositorio;
import Interfaces.Repositorio.Direccion;

import java.util.ArrayList;
import java.util.List;

public class ProductoListRepositorio extends AbstractaListRepositorio<Producto> {

    @Override
    public void editar(Producto cliente) {
        Producto c = this.porId(cliente.getId());
        c.setDescripcion(cliente.getDescripcion());
        c.setPrecio(cliente.getPrecio());
    }

    @Override
    public List<Producto> listar(String campo, Direccion dir) {
        List<Producto> listaOrdenada = new ArrayList<>(this.dataSource);
        listaOrdenada.sort((a, b) -> {
            int resultado = 0;
            if (dir == Direccion.ASC) {
                resultado = ordenar(campo, a, b);
            } else if (dir == Direccion.DESC) {
                resultado = ordenar(campo, b, a);
            }
            return resultado;
        });
        return listaOrdenada;
    }

    public static int ordenar(String campo, Producto a, Producto b){
        int resultado = 0;
        switch (campo){
            case "id" ->
                resultado=a.getId().compareTo(b.getId());
            case "nombre" ->
                resultado = a.getDescripcion().compareTo(b.getDescripcion());
            case "apellido" ->
                resultado = a.getPrecio().compareTo(b.getPrecio());
        }
        return resultado;
    }

}


