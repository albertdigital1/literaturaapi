# literaturaapi

<h1>Proyecto: Gestión de Libros y Autores</h1>
<p align="left">
   <img src="https://img.shields.io/badge/STATUS-TERMINADO-green">
   <img src="https://img.shields.io/badge/Ver-1.0-blue">
</p>
Este proyecto consiste en una aplicación interactiva que permite gestionar libros y autores, con integración a una base de datos PostgreSQL y una API externa para obtener información de libros. El sistema ofrece un menú con múltiples opciones que incluyen la búsqueda de libros, la visualización de libros registrados, y la consulta de autores, entre otras funcionalidades.

<h2>Características principales</h2>

La aplicación está diseñada para interactuar con el usuario mediante un menú en bucle que ofrece las siguientes opciones:

- **Buscar libro por título**  
  Permite al usuario buscar un libro por su título. El sistema solicitará al usuario el nombre del libro, consumirá la API Gutendex para obtener información sobre el libro (título, autor, idioma, y número de descargas), y almacenará esta información en una base de datos PostgreSQL.

- **Listar libros registrados**  
  Consulta los libros almacenados en la base de datos y los muestra en pantalla, incluyendo los campos de título, autor, idioma y número de descargas.

- **Listar autores registrados**  
  Muestra la lista de autores registrados en el sistema, junto con su fecha de nacimiento, fecha de fallecimiento y los libros que han escrito.

- **Listar autores vivos en un determinado año**  
  El usuario puede ingresar un año y el sistema mostrará los autores que estaban vivos en ese año, junto con su fecha de nacimiento, fecha de fallecimiento y los libros que han escrito.

- **Listar libros por idioma**  
  Muestra los libros registrados en el sistema, filtrados por idioma. El usuario podrá elegir entre los idiomas: español, inglés, francés o portugués, y el sistema mostrará los libros correspondientes.

- **Salir de la aplicación**  
  Finaliza la ejecución de la aplicación.

<h2>Componentes</h2>

- **Clases principales**: Se han creado las clases correspondientes para representar libros y autores, con sus propiedades y métodos.
- **Conexión a base de datos**: La aplicación está conectada a una base de datos PostgreSQL que almacena la información de los libros y autores. Las consultas se realizan mediante JDBC.
- **API Gutendex**: Se integra la API Gutendex para la búsqueda de libros. Esta API permite obtener información detallada sobre libros, que luego se almacena en la base de datos.

<h2>Reglas de negocio</h2>

- **Búsqueda y almacenamiento de libros**: Al buscar un libro, el sistema consulta la API Gutendex usando el título del libro. Si se encuentra el libro, se guardan los datos del mismo en la base de datos (título, autor, idioma y número de descargas).
  
- **Listar libros registrados**: Los libros almacenados en la base de datos se muestran con su título, autor, idioma y número de descargas.

- **Listar autores registrados**: Se muestran los autores con su fecha de nacimiento, fecha de fallecimiento y los libros que han escrito.

- **Autores vivos en un determinado año**: El sistema pregunta al usuario por el año y luego filtra los autores que estaban vivos en ese año, mostrando su información junto con sus libros.

- **Listar libros por idioma**: El sistema permite filtrar los libros por idioma, ofreciendo las opciones: español, inglés, francés o portugués.

<h2>Desafíos</h2>

Este proyecto ha sido un gran reto, especialmente en términos de integración con la API externa y el manejo de la base de datos PostgreSQL. Superar los problemas de conexión y garantizar la correcta actualización de la base de datos fue una parte crucial del desarrollo. Sin embargo, la experiencia ha sido muy enriquecedora y el proyecto está completo y funcional.
