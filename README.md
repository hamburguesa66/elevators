# Elevators

## Instrucciones para ejecutar la aplicación.

Antes de comenzar, se requiere tener instalado.
* Maven (3.6.0 o superior).
* Java 8.

1. Clonar la rama 'develop' del repositorio.

>>
git clone -b develop https://github.com/hamburguesa66/elevators.git
>>

2. Instalar las dependencias del proyecto.

mvn install

3. Ejecutar la aplicación (debería estar disponible en el puerto 8080).

mvn spring-boot:run

## Endpoints

1. GET "/elevators"

2. POST "/elevators"

3. GET "/control/dispatch/{floor}"