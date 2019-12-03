### Escuela Colombiana de Ingeniería
### Ciclos de Vida del desarrollo de Software – CVDS

# ServicioBiblioteca

#Descripcion del producto

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

![](model2.PNG)

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/444e45577adb4614bcfa9bb1a789c155)](https://www.codacy.com/gh/CVDSProyecto20192/Biblioteca?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=CVDSProyecto20192/Biblioteca&amp;utm_campaign=Badge_Grade)

[![CircleCI](https://circleci.com/gh/CVDSProyecto20192/Biblioteca.svg?style=svg)](https://circleci.com/gh/CVDSProyecto20192/Biblioteca)

HEROKU LINKS:

https://serviciobiblioteca.herokuapp.com/

https://proyecto-biblioteca.herokuapp.com/

