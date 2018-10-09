
Curso Spring ATsistemas
Autor: Pedro Ganga Tenorio
Nombre Aplicación: Proyecto carreras

Comenzaremos definiendo cada entidad y las operaciones que podemos realizar:

1. Club

Representa cada uno de los equipos que forman la competición.

CRUD:

Operación GET:

path: /club

Obtiene una lista con todos los clubs

path: /club/{id}

Obtiene un objeto Club según el {id} indicado.

Operación POST:

path: /club

Crea un objeto Club

Ejemplo Body: {"name":"hrc"}

Operación PUT:

path: /club/{id}

Actualiza el objeto Club del {id} indicado

Ejemplo Body: {"name":"HRC"}

Operación DELETE:

path: /club/{id}

Elimina el objeto Club del {id} indicado

2. Corredor

Representa cada uno de los corredores que contratados por cada Club.

CRUD:

Operación GET:

path: /corredor

Obtiene una lista con todos los corredores

path: /corredor/{id}

Obtiene un objeto Corredor según el {id} indicado.

path: /corredor?name=""&size=2

Paginación de los corredores

Operación POST:

path: /club/{id}/corredor

Crea un objeto Corredor asociado al club del {id} indicado

Ejemplo Body: {"name":"marquez","year":1993}

Operación PUT:

path: /club/{id}/corredor/{idCorredor}

Actualiza el objeto Corredor asociando el {id} del Club y los elementos del Body al corredor del {idCorredor} indicado

Ejemplo Body: {"name":"marquez","year":1994}

Operación DELETE:

path: /corredor/{idCorredor}

Elimina el objeto Corredor del {id} indicado

3. Prueba

Representa cada una de las pruebas que forman la competición.

CRUD:

Operación GET:

path: /prueba

Obtiene una lista con todas los pruebas del campeonato

path: /prueba/{id}

Obtiene un objeto Prueba según el {id} indicado.

Operación POST:

path: /prueba

Crea un objeto Prueba

Ejemplo Body:{"name":"Jerez","date":"2018/04/21"}

Operación PUT:

path: /prueba/{id}

Actualiza el objeto Prueba del {id} indicado

Ejemplo Body: {"name":"Ricardo Tormo","date":"2018/04/21"}

Operación DELETE:

path: /prueba/{id}

Elimina el objeto Prueba del {id} indicado

4. Resultado

Representa los resultados de los corredores en las distintas pruebas del campeonato.

CRUD:

Operación GET:

path: /resultado

Obtiene una lista con todos los resultados

path: /resultado/{id}

Obtiene un objeto Resultado según el {id} indicado.

Operación POST:

path: /prueba/{id}/resultado

Crea un objeto Resultado asociado a la prueba del {id} indicado

Ejemplo Body: {"idRunner":7,"seconds":2543}

Operación PUT:

path: /prueba/{id}/resultado/{idResultado}

Actualiza el objeto Resultado actualizando el {id} de la prueba y los elementos del Body al resultado del {idResultado} indicado

Ejemplo Body: {"idRunner":8,"seconds":3000}

Operación DELETE:

path: /resultado/{id}

Elimina el objeto Resultado del {id} indicado

MÉTODOS DE CONSULTA:

4.1 Dada una prueba, obtener la puntuación de los distintos Clubs y escribir dichos resultados en un fichero. (Método Complejo)

Operación GET:

path: /prueba/{id}/resultado

Obtenemos un Map<String,Integer> cuya clave será el nombre del Club y su Valor será la acumulación de puntos de los corredores
asociados a cada club, según la puntuación establecida a la Prueba dada.

El path donde se descarga el archivo puede configurarse en el application.properties

4.2 Dada una prueba y una categoría obtener la clasificación de pilotos según los tiempos en realizar dicha prueba (QUERY)

Operación GET:

path: /prueba/{id}/categoria/{categoria}

Obtenemos una List<ClasificacionDTO>, he creado la clase ClasificacionDTO y el método mapToDTOC en ResultadoMapperImpl, para obtener
una lista de objetos ClasificacionDTO, con los atributos:
	- name (nombre del Corredor)
	- seconds (segundos empleados en dicha prueba)
	- age (edad del corredor)

La variable {categoria} del path establece las distintas categorías por edad, es decir, si queremos obtener la clasificación de los 
corredores mayores de 30 años (Máster30) de la prueba con {id} igual a 1, definiremos el path:

path: /prueba/1/categoria/30

5. Puntuación

No hemos implementado las operaciones CRUD a esta entidad.

