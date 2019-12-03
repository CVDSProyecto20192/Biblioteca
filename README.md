### Escuela Colombiana de Ingeniería
### Ciclos de Vida del desarrollo de Software – CVDS

## Proyecto

ServicioBiblioteca
Team2019-2-PROYCVDS-EQUIPO_DINAMITA
CVDS 2019-2


## Roles

- Product owner: Santiago Alzate
- Scrum Master-Team: Natalia Durán Vivas
- Scrum Master-Team: Julián David Gutierrez Vanegas
- Scrum Master-Team: Andrés Ricardo Martínez Día
- Scrum Master-Team: Miguel Ángel Rivera Rojas


## Descripcion del producto

El producto realizado es una herramienta hecha pensada en las necesidades de la biblioteca de realizar un control y gestión de sus recursos, para así llevarles de manera sencilla y rápida sus servicios a los estudiantes de la Escuela

La aplicación cuenta con una pantalla de inicio en la cual el usuario podrá llenar sus credenciales e ingresar a la aplicación, o podrá ingresar a esta como invitado:
![](Imagenes/PantallaDeInicio.PNG)

Cuando el usuario que ingresa pertenece a la comunidad de estudiates, se desplegará en la pantalla el siguiente menú 
![](Imagenes/MenuCom.PNG)

Allí podrá elegir entre dos opciones: ver reservas y ver recursos. 

Cuando el usuario da click en el icono amarrilloz, correspondiente a visualizar recursos, se desplegará en la pantalla el siguiente cuadro:
![](Imagenes/VerRecursos.PNG)

Allí, el usuario podrá observar todos los recursos disponibles con que cuenta la biblioteca y tendrá la posibilidad de filtrar por: nombre, ubicación, capacidad o tipo.
Una vez el usuario ha encontrado el recurso que quiere, podrá dar click sobre el y luego oprimier el botón "Disponibilidad" para observar los horarios del recurso.
Una vez el usuario oprimido el botón de "Disponibilidad", aparecerá en la pantalla un calendario con la información del recurso. En este se podrá observar las horas en que el recursos está libre y en las que no.
Este calendario cuenta con tres vistas:
- Mensual
![](Imagenes/disponibilidadMensual.PNG)
- Semanal
![](Imagenes/DisponibilidadDeLaSemana.PNG)
- Del día
![](Imagenes/DisponibilidadDelDia.PNG)

Además, esta vista también le permite al usuario obtener información de las reservas con que cuenta el recurso. Para esto, basta que el usuario oprima click sobre cualquier reserva mostrada en el horario, e inmediatamente, aparecerá toda la información de esta de la siguiente manera:
![](Imagenes/VerInfoDisponibilidad.PNG)

Y como último elemento en esta vista, el usuario podrá realizar sus reservas allí. Basta con que oprima un espacio en el horario, o el día en que prefiera realizar la reserva. Cuando el usuario selecciona el día, esto en la vista de "disponibilidad mensual", se desplegará el siguiente formulario, solicitandole que digite: la hora, duración y si desea hacer una reserva concurrente:
![](Imagenes/reservarDesdeElMes.PNG)

Mientras que si el usuario realiza esta selección en una hora específica, ya sea que lo haga desde la vista de "disponibilidad semanal" o "disponibilidad diaría", el usuario no tendrá que digitar la hora, ya que esta tomará el valor de la franja donde realizó el click
![](Imagenes/reservarDesdeLaSemana.PNG)

Mientras que si el usuario realiza esta selección en una hora específica, ya sea que lo haga desde la vista de "disponibilidad semanal" o "disponibilidad diaría", el usuario no tendrá que digitar la hora, ya que esta tomará el valor de la franja donde realizó el click
![](Imagenes/reservarDesdeLaSemana.PNG)

Una vez el usuario haya hecho sus reservas o consultado las mismas, podrá abandonar la aplicación volviendo al menú incial y oprimiendo el ícono rojo.

Cuando el que ingresa a la aplicación es un usuario administrador, el menú a desplegar será el siguiente:
![](Imagenes/menuAdmin.PNG)

Allí el admin, oprimiendo el primer ícon de izquierda a derecha, podrá registrar un nuevo usuario a la aplicación llenando el siguiente formulario:
![](Imagenes/RegistrarUsuario.PNG)

Oprimiendo el segundo, el administrador se encontrará con una información detallada de cada una de las reservas hechas en la aplicación:
![](Imagenes/verReservas.PNG)

Si el administrador desea obtener información más detallada sobre el recurso reservado, bastará con que oprima el ícono de la lupa e inmediatamente se desplegará en un cuadro toda la información sobre dicho recurso:
![](Imagenes/informacionRecursoReservas.PNG)

Por otra parte, si desea ver una información detallada del usuario al cual pertenece la reserva, bastará con oprimir el muñeco de usuario:
![](Imagenes/informacionUsuariosReservas.PNG)

Finalmente, si se tratase de una reserva recurrente, el administrador podrá ver la próxima fecha y la fecha final de esta oprimiento el último ícono:
![](Imagenes/informacionRecurrenciaReservas.PNG)

Otra de las funcionalidades que ofrece este menú de administrador es la de gestionar los recursos. Para esto, el administrador deberá oprimir en el ícono verde del menú principal, allí se desplegará la siguiente pantalla, la cual le permitirá al administrador ingresar un nuevo recurso a la aplicación:
![](Imagenes/registroDERecursos.PNG)
 
Allí mismo, oprimiendo el botón de "ver recursos", podrá gestionar los recursos actuales, bloqueandolos si es necesario:
![](Imagenes/administracionDeRecursos.PNG)

Por último, el administrado podrá gestionar los tipos de recurso de la aplicación. Esto oprimiendo el cuarto ícono de izquierda a derecha. Haciendo esto, se desplegará la siguiente vista, donde podrá ver los tipos existentes y agregar un nuevo tipo si lo desea:
![](Imagenes/manejoDeTiposDeRecurso.PNG)

Cuando un usuario elige la opción de ingresar como invitado, se topará con la tabla de recursos disponibles vista anteriormente. Allí, de igual forma que el usuario de la comunidad, podrá elegir el recurso que desee y observar su disponibilidad, además, de obtener una pequeña información de las reservas de este. 
La gran diferencia en esta vista, radica en que, si el usuario invitado oprime una hora o día en el calendario para realizar una reserva, aparecerá ante él el siguiente cuadro solicitandole iniciar sesión para poder realizar esta reserva:
![](Imagenes/solicitarIniciarSesionInvitado.PNG)

## Arquitectura y Diseño

# Modelo Entidad-Relación

![](model2.PNG)

# Diagrama de Clases

![](Diagramas/DiagramaClasesPrin.png)

# Arquitectura del proyecto

Este proyecto está basado en la comunicación a través de inyecciones; a continuación se mencionarán las capas desde la más baja hasta la más alta:

- Mappers (xml)
- Entidades 
- MyBatisMappers
- DAOs (DAO.MyBatis es su implementación)
- Servicios (ServiciosImpl es su implementación)
- Vistas

# Tecnologías utilizadas

PrimeFaces: Para el diseño de las páginas web (tablas, eventos, botones).
Guice: Para poder crear y manejar las inyecciones. 
QuickTheories: Ayudas en internet (GitHub, StackOverFlow)
PostgreSQL: Motor de base de datos utilizada.
Shiro: Para la seguridad de la aplicación.
Heroku: Para el despliegue web de la aplicación.
Circle CI y Codacy: Para la contante revisión del estado de la aplicación (Integración).

# Enlaces de Integración Continua

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/444e45577adb4614bcfa9bb1a789c155)](https://www.codacy.com/gh/CVDSProyecto20192/Biblioteca?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=CVDSProyecto20192/Biblioteca&amp;utm_campaign=Badge_Grade)

[![CircleCI](https://circleci.com/gh/CVDSProyecto20192/Biblioteca.svg?style=svg)](https://circleci.com/gh/CVDSProyecto20192/Biblioteca)

# Enlaces de Heroku

https://serviciobiblioteca.herokuapp.com/

https://proyecto-biblioteca.herokuapp.com/


### Descripción del proceso

## Integrantes

- Natalia Durán Vivas
- Julián David Gutierrez Vanegas
- Andrés Ricardo Martínez Día
- Miguel Ángel Rivera Rojas

## Descripción de la Metodología

Para desarrollar los tasks de los springs, tuvimos en cuenta lo que cada uno quería realizar en el proyecto, de modo que para que solo uno no hiciera lo mismo siempre, a medida que ibamos avanzando nos turnábamos los roles y tareas generales de diseño.

### Taiga 

2019-2-PROYCVDS-EQUIPO_DINAMITA
https://tree.taiga.io/project/nduran06-1-gestion-de-recursos-biblioteca/backlog

### Release-burndown chart

Spring 1

![](Imagenes/sp1.png)

Spring 2

![](Imagenes/sp2.png)

Spring 3

![](Imagenes/sp3.png)

### Tareas Springs

Spring 1

![](Imagenes/spt1.png)

Spring 2

![](Imagenes/sp2.png)

Spring 3

![](Imagenes/sp3.png)

### Backlogs

Spring 1

![](Imagenes/bc1.png)

Spring 2

![](Imagenes/bc2_1.png)

![](Imagenes/bc2_2.png)

![](Imagenes/bc2_3.png)

![](Imagenes/bc2_4.png)

Spring 3

![](Imagenes/sp3_1.png)

![](Imagenes/sp3_2.png)


### Problemas

- No siempre teníamos suficiente tiempo para las tareas ya que nos demorábamos averiguando sobre algunos temas.

- En ocasiones realizabamos cambios descoordinadamente, así que al subirlo al repositorio se hacía con errores.

### Pruebas

![](Imagenes/pruebas.png)

### Análisis Estático (Codacy)

![](Imagenes/cod1.png)

![](Imagenes/cod2.png)

(Los errores son por la escritura en el ReadMe)

