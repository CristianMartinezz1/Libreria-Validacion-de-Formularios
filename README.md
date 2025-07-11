# 📦 Librería de Validación de Formularios en Java
## 👥 Colaboradores
- Cristian Martinez Pacheco – [@CristianMartinezz1](https://github.com/CristianMartinezz1) 
- Angel Eduardo Velasco Vasquez - [@Angel-Eduardo-Velasco-Vasquez] (https://github.com/Angel-Eduardo-Velasco-Vasquez).


Esta librería facilita la validación de formularios en interfaces gráficas desarrolladas con Java y Swing. Su objetivo es ofrecer una forma rápida, reutilizable y visualmente clara de validar campos como nombres, correos, teléfonos, contraseñas, CURP, RFC y fechas, mostrando mensajes y resaltando campos inválidos automáticamente.

---

## ✅ Propósito

Ayudar a desarrolladores Java a:
- Validar entradas en formularios gráficos de forma centralizada.
- Mejorar la experiencia del usuario con mensajes claros.
- Reutilizar código para validaciones comunes.
- Aplicar retroalimentación visual automática a los campos (`JTextField`).

---

## 🧠 Estructura del código

### 📁 Clase principal: `LibreriaValidacion`

- Es **final** y tiene un constructor **privado**: no se puede instanciar.
- Todos los métodos son **estáticos** (`static`), por lo que se llaman directamente desde el nombre de la clase.

### 🧪 Principales métodos

| Método | Propósito |
|-------|-----------|
| `estaVacio(String texto)` | Verifica si el texto está vacío o solo contiene espacios. |
| `marcarCampo(JTextField campo, boolean valido)` | Colorea el fondo del campo: verde si es válido, rojo si no. |
| `soloNumeros(String texto, JTextField campo)` | Acepta solo dígitos numéricos. |
| `soloLetras(String texto, JTextField campo)` | Acepta solo letras, incluyendo tildes y ñ. |
| `validarLongitud(String texto, JTextField campo, int min, int max)` | Verifica si el texto tiene longitud dentro de un rango. |
| `correoValido(String texto, JTextField campo)` | Valida el formato de email. |
| `telefonoValido(String texto, JTextField campo)` | Valida que el teléfono tenga 10 dígitos. |
| `curpValida(String texto, JTextField campo)` | Valida el formato de la CURP (México). |
| `rfcValido(String texto, JTextField campo)` | Valida el formato del RFC (México). |
| `fechaValida(JTextField dia, mes, año)` | Valida fecha compuesta ingresada en 3 campos. |
| `nivelContraseña(String contraseña)` | Evalúa seguridad: Débil, Media o Fuerte. |
| `validarContraseñas(pass1, pass2, campo1, campo2)` | Compara dos contraseñas, revisa que coincidan y sean fuertes. |
| `marcarCamposVacios(JTextField... campos)` | Marca todos los campos vacíos en rojo. |

---

## 🧩 Instrucciones para importar el `.jar` en otro proyecto

1. **Genera el `.jar`** en NetBeans o tu IDE:
   - Botón derecho sobre el proyecto → `Clean and Build`.
   - El archivo `.jar` estará en la carpeta `/dist`.

2. **Importa en tu nuevo proyecto**:
   - En NetBeans: botón derecho sobre tu proyecto → `Propiedades` → `Libraries` → `Agregar JAR/Folder` → Selecciona tu archivo `.jar`.

3. **Usa los métodos directamente**:

```java
import libreriavalidacion.LibreriaValidacion;

boolean valido = LibreriaValidacion.soloLetras(txtNombre.getText(), txtNombre);
```
## 🖼️ Uso práctico en JFrame

A continuación se muestra un ejemplo del funcionamiento de la librería en una interfaz gráfica (`JFrame`), validando campos de texto y mostrando retroalimentación visual:

![Validación en JFrame](https://i.imgur.com/qf3ZpXN.png)


### ✅ Ejemplo 2: Campos resaltados y mensajes de error

![Validación en JFrame 2](https://i.imgur.com/SsOjEci.png)

## 📄 Documentación (Javadoc)

Puedes consultar la documentación técnica generada automáticamente con Javadoc en el siguiente enlace:

🔗 [Ver Javadoc en GitHub Pages](https://cristianmartinezz1.github.io/Libreria-Validacion-de-Formularios/)

## 🎥 Video explicativo (YouTube)

En este video se muestra:

- Cómo importar el archivo `.jar` de la librería en un nuevo proyecto Java.
- Un ejemplo práctico de uso dentro de una interfaz gráfica (`JFrame`).
- Duración: menos de 1 minuto.

🔗 [Ver video en YouTube](https://youtu.be/dkA_H2i4oCM)
