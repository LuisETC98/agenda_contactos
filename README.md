# Proyecto de Agenda de Contactos

Aplicación de consola que permite guardar con persistencia de datos los contactos personales del usuario. Se estructura en tres diferentes capas, cada una con una responsabilidad específica: dominio, presentación y datos.
La capa de persistencia (datos) utiliza un patrón de diseño DAO (data access object), a través del cual se gestionan los métodos CRUD para interactuar con base de datos MySQL de forma simplificada, haciendo uso de objetos de clase
"Contacto". Los atributos de esta última están representados en la tabla relacional.

## Tecnologías
- **Lenguaje de programación**: Java 21
- **Entorno de uso**: consola (terminal)
- **Gestor de dependencias**: Maven.
- **IDE**: Intellij
- **Base de datos**: MySQL

## Requisitos
- Tener instalado Java Development Kit 21 (Java 21).
- Tener instalado MySQL.
- Tener instalada interfaz MySQL Workbench para gestionar base de datos.

## Instalación
1. Descarga el archivo `.zip` o clona este repositorio.
2. Navega hasta la carpeta `src`.
3. Compila el programa con Maven para ejecutar dependencia MySQL y JDBC.
4. Ejecútalo.

## Autor
**Luis Tapia** - [GitHub](https://github.com/LuisETC98)
