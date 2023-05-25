# INDITEXT BACKEND


## Enunciado

Dado un listado de productos que se muestra en una categoría de camisetas se
necesita implementar un algoritmo que permita ordenar ese listado en base a una serie
de criterios de ordenación. Cada criterio de ordenación tendrá un peso asociado de
manera que la puntuación de cada producto a ordenar vendrá dada por la suma
ponderada de los criterios.
Los criterios de ordenación definidos serán el criterio de ventas por unidades y el
criterio de ratio de stock, puede que a futuro se añadan nuevos criterios.  
El criterio de ventas por unidades dará una puntuación a cada producto basado en el
número de unidades vendidas.  
El criterio de ratio de stock dará una puntuación en función de las tallas que contengan
stock en ese momento.

La funcionalidad debe exponerse a través de un servicio REST de manera que recibirá
los pesos para cada criterio.
Queda a libre elección el lenguaje y frameworks a utilizar para la implementación.

## Base de datos

Para la realicación de la prueba se ha implementado según los requisitos una persistencia de datos basada en MongoDB. Se puede tener desplegada en local o se puede usar el servicio levantado en docker. 

## Testing

Para lanzar la ejecución de los test se puede lanzar el siguiente comando: 

    ./mvnw test
Se ha de tener en cuenta que se necesita el servicio de mongo levantado ya que los tests e2e como los de integración con mongo necesitan de dicho servicio. Los tests están estructurados de manera que repliquen la estructura de directorios del proyecto. Dentro de los tests se encuentras los tests unitarios, los test de integración y los tests e2e.
Los test e2e tiran contra una base de datos de tests.

## Docker

Se ha añadido en el proyecto un `DockerFile` y la configuración de `docker-compose` para permitir el desarrollo en un entorno limpio usando los servicios dentro del docker. Para levantar el `docker-compose`con los servicios de api y mongo lanzar el comando de: 

    docker-compose up --build

## Estructura

El proyecto ha sido desarrollado siguiendo una arquitectura hexagonal y siguiendo los principios del DDD tanto tácticos como estratégicos. 

Para la creación del dominio se ha estudiado la información del dominio del cliente (enunciado). A partir de dicho análisis se puede empezar a modelar el lenguaje ubicuo. Por el tamaño de la prueba y la relación de los elementos se observa un único `bounder context` donde reside la aplicación. En dicho contexto además se observa que el agragado principal es el del producto. 
También se observa la existencia de Variantes que por la información del dominio solo se sabe que contienen tallaje y stock, sin embargo es una entidad que facilmente puede crecer. Las variantes en este dominio y por los casos de uso que tiene ahora mismo el problema no son referenciados desde fuera y no interesa la identificación única de una variante sin tener en cuenta su producto por lo que se podría considerar también un `valueObject`. Sin embargo, se ha decidido tomarlo como entidad por escalabilidad a futuro y posibles casos de uso que quieran hacer referencia a todas las variantes. 

Para la aplicación del DDD y su combinación con la arquitectura hexagonal se ha añadido una carpeta propia por agregado, donde contendrá las carpetas de `application`, `domain` e `infrastructure`. 


