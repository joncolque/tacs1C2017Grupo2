# TACS1C2017Grupo2

Pasos para ejecutar en consola:

1. Ubicarse en el directorio del proyecto git.
2. Escribir *mvn clean install*
3. Escribir *mvn spring-boot:run*
4. El servidor REST se encuentra en *http://localhost:8080*

Lista de endpoints: 
Se adjunta "listaEndpoints.txt", que contiene los path.
Se adjunta una coleccion v2 de PostMan con todos los requests correspondientes.

Observacion Login:
Para realizar el login de un usuario o adminitrador, se debe ingresar a traves del browser.
	
*http://localhost:8080/home*

usuario
	userName: user
	password: password

admin
	userName: admin
	password: 1234