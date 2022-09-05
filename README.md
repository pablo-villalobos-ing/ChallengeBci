# ChallengeBci
Challenge para vacante Java Dev

## _Detalles del Proyecto_
- Leguaje :Java 8
- FrameWork Spring - SpringBoot 2.7.3
- Packaging jar

## _Dependecias_
- starter-data-jpa
- starter-security
- starter-web
- starter-validation
- jjwts 0.9.1
- lombok
- mysql connector
- starter-test
- spring-security-test
- groovy
- spock


## _Instalación_
Al importar el proyecto al IDE debe de ejecturar "Gradle Refresh Project" para la instalación de dependencias.

## _Configuración_
los datos a considerar estan en "application properties"
- puerto de salida por defecto configurado :server.port=3030
- debe de existir una base de datos llamada bcichallenge o configurar esta property con el nombre de base de datos a especificar: 
spring.datasource.url=jdbc:mysql://localhost:3306/bcichallenge
- Especificar usuario base de datos: spring.datasource.username=userBci
- Especificar clave de usuario base de datos:spring.datasource.password=clave123
- Después de la primera ejecución este campo se sugiere pasarlo a "validate": spring.jpa.hibernate.ddl-auto=update
- por seguridad se puede considerar cambiar el secret de jwt: jwt.secret=ChallengeBci

## _Sobre el microservicio_
microservicio que contiene 2 rutas endpoint, para crear un usuario en base al contrato de entrada y su login mediante token 
- ## _CreateUser_
     - sobre el contrato de entrada se le aplica inmediatamente en el controller la validación de los campos recibidos en el Json, se valida que el correo corresponda a un formato de tipo email.
    - Clave debe de cumplir las reglas: 
        - largo entre 8 y 12 caracteres.
        - Solo una mayuscula.
        - Solo 2 digitos.
    - Contrato de salida específica datos de creación del usuario, id de la persistencia, fecha de creación, estado activo, última vez que hizo login y su token.
- ## _Login_
    - Sobre el contrato de entrada se recibe un Json con el token anidado en el(campo token de tipo Strng").
    - la validación del token se realiza en capa de servicio para ocultar lógica del negocio, mediante el provider del JWT, dentro me método del servicio se construye el DTO que retorna el enpoint.

## _Requisitos del Challenge_
- Caracteristicas Java 8 utilizada:
    - HashMap.
    - Stream().Map().
    - list<>.forEarch(predicate).
- Pruebas unitarias kit basico de pruebas. clase jwt y authservice.
- Validación contrato de entrada sing-up campos correo y clave.
- Persistencia en base de datos con clave encriptada.
- "Exception" devueltas en objeto Json.
- Generar login mediante Token entregado en endpoint sign-up

## _Documentación_
Dentro del repositorio se encuentra el folder UML que contiene los diagramas de componentes y diagrama de secuencia para cada endponit

## _Comentarios del programador_
- En contrato de salida se solicita fecha del último login, esto en el servicio considera una consulta a la base de datos que se sabe sera nula, ya que al registar un nuevo usuario este nunca tuvo record de login anterior. Por lo que a mí parecer, es un campo que no deberia de ser devuelto, al menos en este endpoint. Ya que siempre sera fecha null. Pero se incluyo por ser parte del requerimiento.

- En contrato de salida para login se solicita devolver dentro del objeto la clave del usuario, esto a mi parecer genera una vulnerabilidad, sería una mejor práctica no devolver la clave, pero por cumplir con el requerimiento del endpoint se agrego lo solicitado.


