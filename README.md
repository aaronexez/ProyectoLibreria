
# Proyecto Libreria

Proyecto orientado a la gestión de una Libreria, con libre acceso para guardar, actualizar, consultar todos y dar de baja libros, autores o editoriales.

## Dependencias

- Lombok `DEVELOPER TOOLS`
- Spring Web `WEB`
- PostgreSQL Driver `SQL`
- Spring Data JPA `SQL`

## Instalación

1. Clonar el proyecto: `git clone https://github.com/aaronexez/ProyectoLibreria.git`
2. Crear una base de datos en PostgreSQL con el nombre de `Libreria`
3. Cambiar el archivo "application.properties" dentro de la carpeta main para así configurar las credenciales necesarias.
4. Agregar `server.port=` con el numero de puerto que deseas que use el proyecto en caso que tengas ocupado el puerto 8080 (por defecto).
5. cambiar los valores de la linea `spring.jpa.hibernate.ddl-auto=create` de acuerdo a tus necesidades, una vez creada las tablas podrás cambiar el valor por `update` para que así los valores cargados en tus tablas no se pierdan.

#### Java Version
Es compatible con `Java 17`, en caso de contar con otra versión deberás acceder al archivo 'build.gradle' y modificar la versión de Java en su respectivo bloque (ten en cuenta que esto puede generar problemas dependiendo la versión de spring boot, actualiza esta versión de ser necesario).

```groovy
plugins {
    id 'java'
    id 'org.springframework.boot' version '3.1.5'
    id 'io.spring.dependency-management' version '1.1.3'
}

group = 'com.example'
version = '0.0.1-SNAPSHOT'

java {
    sourceCompatibility = '17'
}
```


## Endpoints

#### Libro

- **Guardar Libro**: Permite registrar un nuevo libro asignando los atributos mediante el cuerpo (JSON). Si no se rellenan todos los atributos, el libro se generará con los atributos proporcionados, y los no rellenados serán nulos. Luego, se pueden actualizar si es necesario.

    - **URL**: `http://localhost:8080/libros/guardar`
    - **Método**: POST

    ```JSON
    {
      "isbn": 9781234567890,
      "titulo": "Libro 1",
      "anio": 2023,
      "ejemplares": 100,
      "ejemplaresPrestados": 20,
      "ejemplaresRestantes": 80,
      "alta": true,
      "autores": [
        {
          "nombre": "Autor 1",
          "alta": true
        },
        {
          "nombre": "Autor 2",
          "alta": true
        }
      ],
      "editorial": {
        "nombre": "Editorial 1",
        "alta": true
      }
    }
    ```

- **Mostrar Libros**: Muestra los libros almacenados en la base de datos.
    - **URL**: `http://localhost:8080/libros/mostrar`
    - **Método**: GET

- **Actualizar Libro**: Permite actualizar un libro existente proporcionando su ID en la URL y los atributos a modificar en el cuerpo del JSON.
    - **URL**: `http://localhost:8080/libros/actualizar/1`
    - **Método**: PUT

    ```JSON
    {
      "titulo": "Título Actualizado"
    }
    ```

- **Dar de Baja Libro**: Permite marcar un libro como "baja" proporcionando su ID en la URL.
    - **URL**: `http://localhost:8080/libros/baja/1`
    - **Método**: PUT

#### Autor

- **Guardar Autor**: Permite registrar un nuevo autor asignando los atributos mediante el cuerpo (JSON). Si no se rellenan todos los atributos, el autor se generará con los atributos proporcionados, y los no rellenados serán nulos. Luego, se pueden actualizar si es necesario.

    - **URL**: `http://localhost:8080/autores/guardar`
    - **Método**: POST

    ```JSON
    {
    "nombre": "Autor 1",
    "alta": true
    }
    ```

- **Mostrar Autores**: Muestra los autores almacenados en la base de datos.
    - **URL**: `http://localhost:8080/autores/mostrar`
    - **Método**: GET

- **Actualizar Autor**: Permite actualizar un autor existente proporcionando su ID en la URL y los atributos a modificar en el cuerpo del JSON.
    - **URL**: `http://localhost:8080/autores/actualizar/1`
    - **Método**: PUT

    ```JSON
    {
    "nombre": "Autor 1 actualizado"
    }
    ```

- **Dar de Baja Autor**: Permite marcar un autor como "baja" proporcionando su ID en la URL.
    - **URL**: `http://localhost:8080/autores/baja/1`
    - **Método**: PUT
    
#### Editorial

- **Guardar Editorial**: Permite registrar una nueva editorial asignando los atributos mediante el cuerpo (JSON). Si no se rellenan todos los atributos, la editorial se generará con los atributos proporcionados, y los no rellenados serán nulos. Luego, se pueden actualizar si es necesario.

    - **URL**: `http://localhost:8080/editoriales/guardar`
    - **Método**: POST

    ```JSON
    {
      "nombre": "Editorial 1",
      "alta": true
    }
    ```

- **Mostrar Editoriales**: Muestra las editoriales almacenadas en la base de datos.
    - **URL**: `http://localhost:8080/editoriales/mostrar`
    - **Método**: GET

- **Actualizar Editorial**: Permite actualizar una editorial existente proporcionando su ID en la URL y los atributos a modificar en el cuerpo del JSON.
    - **URL**: `http://localhost:8080/editoriales/actualizar/1`
    - **Método**: PUT

    ```JSON
    {
      "nombre": "Editorial 1 actualizada"
    }
    ```

- **Dar de Baja Editorial**: Permite marcar una editorial como "baja" proporcionando su ID en la URL.
    - **URL**: `http://localhost:8080/editoriales/baja/1`
    - **Método**: PUT
