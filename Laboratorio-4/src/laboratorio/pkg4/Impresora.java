/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio.pkg4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author david
 */
public class Impresora {

    public String Nombre;
    public String Paginas;

    public Impresora(String nombre, String paginas) {
        Nombre = nombre;
        Paginas = paginas;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPaginas() {
        return Paginas;
    }

    public void setPaginas(String Paginas) {
        this.Paginas = Paginas;
    }

    public Impresora() {
    }

    public List<Impresora> LeerListadoDeDatos(File f) throws FileNotFoundException {
        List<Impresora> leerDatos = new ArrayList<>();
        try (Scanner scanner = new Scanner(f);) {
            while (scanner.hasNextLine()) {
                String[] hoja = getRecordFromLine(scanner.nextLine());

                leerDatos.add(new Impresora(hoja[0], hoja[1]));
            }
        }
        return leerDatos;
    }

    public static String[] getRecordFromLine(String line) {
        String[] values = line.split(";");
        return values;
    }
}
