# Sistema de Sorteo de Equipos - Liga Profesional

##  Descripción del Proyecto

Aplicación de consola desarrollada en Java que gestiona y automatiza el sorteo de partidos para una liga profesional de eliminación directa conformada inicialmente por 16 equipos. El sistema organiza de forma aleatoria y progresiva los enfrentamientos correspondientes a todas las fases del torneo (**Octavos de Final, Cuartos de Final, Semifinales y Final**) utilizando un algoritmo recursivo.

El proyecto integra cuatro pilares fundamentales de la ingeniería de software en Java:
1. **Patrón Arquitectónico MVC (Modelo-Vista-Controlador):** Separación estricta entre la lógica de negocio, la interfaz de usuario por consola y el control de flujo mediante paquetes independientes.
2. **Algoritmo Recursivo:** Emparejamiento aleatorio que garantiza que ningún equipo repita partido en una misma etapa ni sea asignado como competidor y oponente simultáneamente.
3. **Manejo de Excepciones Personalizadas:** Validación de reglas de negocio mediante excepciones propias que heredan de `Exception`, junto con el control de errores de entrada/salida.
4. **Persistencia de Datos (Serialización):** Guardado y reconstrucción del estado completo del torneo en un archivo binario (`torneo.ser`).

##  Uso de la Aplicación (Menú Principal)

Al ejecutar el programa, la vista en consola presenta un menú interactivo con las siguientes opciones:
1. **Cargar 16 equipos predeterminados y realizar sorteo:** Genera automáticamente los 16 equipos iniciales y ejecuta el sorteo recursivo desde Octavos de Final hasta la Final.
2. **Ingresar 16 equipos manualmente y realizar sorteo:** Solicita la cantidad de equipos a registrar (permitiendo comprobar el lanzamiento de `NumeroEquiposInvalidoException` si se ingresa un número distinto de 16) y pide el nombre de cada club para ejecutar el sorteo de todas las etapas.
3. **Mostrar resultados del sorteo actual:** Imprime por consola los enfrentamientos generados organizados por etapa (`Octavos de Final`, `Cuartos de Final`, `Semifinales` y `Final`).
4. **Guardar torneo (Serializar en `torneo.ser`):** Guarda el estado actual del sorteo en un archivo binario.
5. **Cargar torneo guardado (Deserializar de `torneo.ser`):** Recupera los datos almacenados previamente en el archivo `torneo.ser` y muestra los partidos en pantalla.
0. **Salir:** Cierra la aplicación.

## Pasos para clonar:

1. En la barra de menú superior de Eclipse, selecciona `File` > `Import...`.
2. En la ventana emergente, despliega la carpeta `Git`, selecciona la opción `Projects from Git (with smart import)` y haz clic en `Next >`.
3. Selecciona `Clone URI` y presiona `Next >`.
4. En el campo `URI`, pega el enlace de este repositorio:
   `https://github.com/angelesbastidas17-pixel/Bastidas_Angeles_POO_U2.git`
5. Los campos Host y Repository path se autocompletarán automáticamente. Haz clic en `Next >`.
6. Asegúrate de que la rama principal (`master` o `main`) esté marcada con un visto y haz clic en `Next >`.
7. Verifica o elige la carpeta en tu computadora donde se guardará la copia local del proyecto y haz clic en `Next >`.
8. En la ventana Import Projects from File System or Archive, verifica que el proyecto aparezca seleccionado en la casilla Folder y haz clic en `Finish`.

## Pasos para ejecutar localmente:

  1. En el panel `Package Explorer`, despliega el proyecto y navega hasta `src/controlador/Main.java`.
  2. Haz clic derecho sobre `Main.java` y selecciona `Run As` > `1 Java Application`.

## Ejemplo de la salida en la consola:
<img width="210" height="456" alt="image" src="https://github.com/user-attachments/assets/b38d6b5e-cc7f-4d85-8238-5fd496cf730a" />
