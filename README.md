# Elevators

Ejemplo de una API REST desarrollada con Spring Boot. La API administra tres ascensores (cuyos ids son "A","B","C") que pueden ser modificados (dirección, piso actual, piso destino) y permite simular un llamado a un ascensor desde un piso de un edificio con 20 pisos. La respuesta a ese llamado es el ascensor que gataría menos energia al atender ese llamado.

Por "ahorro de energía" se entiende que cuando una persona llama a un ascensor, el sistema debe enviar aquel que llegue a ese piso en la menor cantidad de movimientos (pero no necesariamente en la menor cantidad de tiempo). Se entiende que si el ascensor ya está viajando a un piso, la cantidad de movimientos a hacer se considera como energía ya “consumida". Por ejemplo, si el ascensor está yendo del piso 4 al 18 y lo llaman del 10, el costo es cero porque el ascensor ya tiene asumido un costo de 14 para llegar al piso 18.

## Instrucciones para ejecutar la aplicación.

Antes de comenzar, se requiere tener instalado.
* Maven (3.6.0 o superior).
* Java 8.

1. Clonar la rama 'develop' del repositorio.

  ```
  git clone -b develop https://github.com/hamburguesa66/elevators.git
  ```

2. Instalar las dependencias del proyecto.

  ```
  mvn install
  ```

3. Ejecutar la aplicación (debería estar disponible en el puerto 8080).

  ```
  mvn spring-boot:run
  ```

## Endpoints

1. GET "/elevators"

> Retorna los ascensores definidos en el sistema.

2. POST "/elevators"

> Permite modificar los atributos de un ascensor.
> Ejemplo de una request:
> 
 ```
{
    "id": "B",
    "direction": "STOPPED",
    "currentFloor": 1,
    "targetFloor": null
}
 ```

3. GET "/control/dispatch/{floor}"

> Dado un piso entre 1 y 2, retorna el ascensor que debería responder la llamada al piso especificado con el paráemtro {floor}.
> El valor de {floor} debe estar entre en el rango [1,20].
