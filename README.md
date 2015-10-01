#Ejercicios
Ejercicios MySQL

-Previamente hay que importar el proyecto a un path local.
-En el MySQL crearemos una database con nombre PiecesandProviders.
-Después cargamos en esta Database (con comando Source) el fichero Base.sql del directorio raiz del proyecto al MySQL para crear las tablas y datos de ejemplo.

Para ejecutar las soluciones (Terminal):
-Ir al path del proyecto.
cd [path_to_dsa_projects]
-Con el maven clean limpiamos el proyecto.
mvn clean
-Con el maven package creamos el paquete jar ejecutable
mvn package
-Probamos el paquetes por terminal:
java -jar [NombrePaquete].jar

También se puede realizar con en el IDEA con clic derecho en el APP de cada Package --> Run.

## License
[MIT](./LICENSE).
