/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package libreriavalidacion;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Clase de utilidades para validación de formularios en interfaces gráficas con Swing.
 * Proporciona métodos para validar campos como nombre, correo, fecha, CURP, RFC, etc.
 * También permite marcar visualmente los campos válidos o inválidos.
 */
public final class LibreriaValidacion {

    private LibreriaValidacion() {} // Evita instanciación

    /**
     * Verifica si una cadena está vacía o contiene solo espacios.
     * 
     * @param texto Texto a verificar
     * @return true si es nulo o vacío, false en caso contrario
     */
    public static boolean estaVacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }

    /**
     * Cambia el color de fondo de un JTextField según su validez.
     * 
     * @param campo Campo a marcar
     * @param valido true si es válido, false si es inválido
     */
    public static void marcarCampo(JTextField campo, boolean valido) {
        if (valido) {
            campo.setBackground(new Color(200, 255, 200));
        } else {
            campo.setBackground(new Color(255, 200, 200));
        }
    }

    /**
     * Valida que el texto contenga solo números.
     * 
     * @param texto Texto a validar
     * @param campo Campo asociado para marcar
     * @return true si es válido, false si no
     */
    public static boolean soloNumeros(String texto, JTextField campo) {
        boolean valido = !estaVacio(texto) && texto.matches("\\d+");
        if (!valido) {
            JOptionPane.showMessageDialog(null, "Solo se permiten números");
        }
        marcarCampo(campo, valido);
        return valido;
    }

    /**
     * Valida que el texto contenga solo letras (mayúsculas, minúsculas y tildes).
     * 
     * @param texto Texto a validar
     * @param campo Campo asociado para marcar
     * @return true si es válido, false si no
     */
    public static boolean soloLetras(String texto, JTextField campo) {
        boolean valido = !estaVacio(texto) && texto.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
        if (!valido) {
            JOptionPane.showMessageDialog(null, "Solo se permiten letras");
        }
        marcarCampo(campo, valido);
        return valido;
    }

    /**
     * Valida que la longitud del texto esté dentro del rango permitido.
     * 
     * @param texto Texto a validar
     * @param campo Campo asociado para marcar
     * @param minimo Longitud mínima permitida
     * @param maximo Longitud máxima permitida
     * @return true si está en el rango, false si no
     */
    public static boolean validarLongitud(String texto, JTextField campo, int minimo, int maximo) {
        boolean valido = !estaVacio(texto) && texto.length() >= minimo && texto.length() <= maximo;
        if (!valido) {
            JOptionPane.showMessageDialog(null, "El texto debe tener entre " + minimo + " y " + maximo + " caracteres");
        }
        marcarCampo(campo, valido);
        return valido;
    }

    /**
     * Valida el formato de un correo electrónico.
     * 
     * @param correo Correo a validar
     * @param campo Campo asociado para marcar
     * @return true si el formato es válido, false si no
     */
    public static boolean correoValido(String correo, JTextField campo) {
        boolean valido = !estaVacio(correo) && correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");
        if (!valido) {
            JOptionPane.showMessageDialog(null, "Correo electrónico no válido");
        }
        marcarCampo(campo, valido);
        return valido;
    }

    /**
     * Valida que el número telefónico tenga exactamente 10 dígitos.
     * 
     * @param telefono Teléfono a validar
     * @param campo Campo asociado para marcar
     * @return true si tiene 10 dígitos, false si no
     */
    public static boolean telefonoValido(String telefono, JTextField campo) {
        boolean valido = !estaVacio(telefono) && telefono.matches("\\d{10}");
        if (!valido) {
            JOptionPane.showMessageDialog(null, "El teléfono debe tener 10 dígitos");
        }
        marcarCampo(campo, valido);
        return valido;
    }

    /**
     * Valida el formato de una CURP.
     * 
     * @param curp CURP a validar
     * @param campo Campo asociado para marcar
     * @return true si el formato es válido, false si no
     */
    public static boolean curpValida(String curp, JTextField campo) {
        boolean valido = !estaVacio(curp) && curp.matches("^[A-Z]{4}\\d{6}[HM][A-Z]{5}[A-Z0-9]{2}$");
        if (!valido) {
            JOptionPane.showMessageDialog(null, "CURP no válida");
        }
        marcarCampo(campo, valido);
        return valido;
    }

    /**
     * Valida el formato de un RFC.
     * 
     * @param rfc RFC a validar
     * @param campo Campo asociado para marcar
     * @return true si el formato es válido, false si no
     */
    public static boolean rfcValido(String rfc, JTextField campo) {
        boolean valido = !estaVacio(rfc) && rfc.matches("^([A-ZÑ&]{3,4})\\d{6}[A-Z0-9]{3}$");
        if (!valido) {
            JOptionPane.showMessageDialog(null, "RFC no válido");
        }
        marcarCampo(campo, valido);
        return valido;
    }

    /**
     * Valida una fecha ingresada en tres campos separados: día, mes y año.
     * 
     * @param txtDia Campo de día
     * @param txtMes Campo de mes
     * @param txtAnio Campo de año
     * @return true si la fecha es válida, false si no
     */
    public static boolean fechaValida(JTextField txtDia, JTextField txtMes, JTextField txtAnio) {
        String diaStr = txtDia.getText();
        String mesStr = txtMes.getText();
        String anioStr = txtAnio.getText();

        if (estaVacio(diaStr) || estaVacio(mesStr) || estaVacio(anioStr)) {
            marcarCampo(txtDia, false);
            marcarCampo(txtMes, false);
            marcarCampo(txtAnio, false);
            JOptionPane.showMessageDialog(null, "Debe completar día, mes y año");
            return false;
        }

        try {
            int dia = Integer.parseInt(diaStr);
            int mes = Integer.parseInt(mesStr);
            int anio = Integer.parseInt(anioStr);

            boolean valido = dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12 && anio >= 1900 && anio <= 2010;

            marcarCampo(txtDia, valido);
            marcarCampo(txtMes, valido);
            marcarCampo(txtAnio, valido);

            if (!valido) {
                JOptionPane.showMessageDialog(null, "Fecha fuera de rango válido");
            }

            return valido;
        } catch (NumberFormatException e) {
            marcarCampo(txtDia, false);
            marcarCampo(txtMes, false);
            marcarCampo(txtAnio, false);
            JOptionPane.showMessageDialog(null, "Los campos de fecha deben ser numéricos");
            return false;
        }
    }

    /**
     * Evalúa el nivel de seguridad de una contraseña.
     * 
     * @param contraseña Contraseña a evaluar
     * @return "Fuerte", "Media", "Débil" o "Vacía"
     */
    public static String nivelContraseña(String contraseña) {
        if (estaVacio(contraseña)) return "Vacía";

        boolean mayus = contraseña.matches(".*[A-Z].*");
        boolean minus = contraseña.matches(".*[a-z].*");
        boolean num = contraseña.matches(".*\\d.*");
        boolean especial = contraseña.matches(".*[!@#$%^&*().?¿¡].*");

        if (contraseña.length() >= 10 && mayus && minus && num && especial) return "Fuerte";
        if (contraseña.length() >= 8 && ((mayus && num) || (minus && especial))) return "Media";
        return "Débil";
    }

    /**
     * Valida que las contraseñas no estén vacías, coincidan y que sea segura.
     * 
     * @param pass1 Primera contraseña
     * @param pass2 Segunda contraseña (confirmación)
     * @param campo1 Campo de la primera contraseña
     * @param campo2 Campo de la segunda contraseña
     * @return true si ambas contraseñas son válidas y coinciden
     */
    public static boolean validarContraseñas(String pass1, String pass2, JTextField campo1, JTextField campo2) {
        if (estaVacio(pass1)) {
            marcarCampo(campo1, false);
            JOptionPane.showMessageDialog(null, "Debe ingresar una contraseña");
            return false;
        }

        String nivel = nivelContraseña(pass1);
        if (nivel.equals("Débil")) {
            marcarCampo(campo1, false);
            JOptionPane.showMessageDialog(null, "Contraseña débil: agrega mayúsculas, números o símbolos");
            return false;
        }

        if (estaVacio(pass2)) {
            marcarCampo(campo2, false);
            JOptionPane.showMessageDialog(null, "Debe confirmar la contraseña");
            return false;
        }

        if (!pass1.equals(pass2)) {
            marcarCampo(campo1, false);
            marcarCampo(campo2, false);
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
            return false;
        }

        marcarCampo(campo1, true);
        marcarCampo(campo2, true);
        return true;
    }

    /**
     * Marca los campos vacíos y devuelve si todos están llenos.
     * 
     * @param campos Campos a verificar
     * @return true si todos los campos tienen contenido, false si alguno está vacío
     */
    public static boolean marcarCamposVacios(JTextField... campos) {
        boolean todosLlenos = true;

        for (JTextField campo : campos) {
            String texto = campo.getText().trim();
            boolean lleno = !estaVacio(texto);
            marcarCampo(campo, lleno);
            if (!lleno) {
                todosLlenos = false;
            }
        }

        return todosLlenos;
    }
}
