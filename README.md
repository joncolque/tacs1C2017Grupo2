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
Para realizar el login de un usuario, se debe ingresar a traves del browser.
	
*http://localhost:8080/home*

Cuentas:

	user: Alvaro
	password: 1234
	
	user: Guille
	password: 1234
	
	user: Martin
	password: 1234
	
	user: Julio
	password: 1234
	
	user: Jon
	password: 1234

FrontEnd, Setup:

1. Tener instalado el node.js
2. Abrir la terminal
3. Ubicarse en "src/main/webapp/"
4. Ejecutar "npm install"
5. Ejecutar "npm start"
6. Abrira automaticamente el frontend en el browser, sino ir a la siguiente ruta: *http://localhost:3000*
