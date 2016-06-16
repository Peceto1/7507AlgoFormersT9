[![Build Status](https://travis-ci.org/fpenovi/7507AlgoFormersT9.svg?branch=master)](https://travis-ci.org/fpenovi/7507AlgoFormersT9)

### **EJECUCIÓN JUEGO**: ###

        $ ant jugar


### **Instrucciones y como usar GIT**: ###

1. Siempre al prender la PC realizar un **PULL**, de ésta manera se actualiza tu versión local del TP por si algún compañero hizo algún avance. Esto se hace de la siguiente manera:

        $ git pull origin master

2. Luego se puede empezar a trabajar en el código. Documentar bien las clases y algún método medio fantasma para que el que lo lea pueda entender como funciona. Siempre testeen el código que trabajaron antes de subirlo. **Traten de no subir código que no anda o sin terminar**. **IMPORTANTE:** *Trataremos de evitar tener a más de una persona trabajando sobre el mismo código (mismo archivo) para evitar la mayor cantidad de MERGE CONFLICTS posibles.*

3. Finalmente una vez que terminaron con su código. Hacen un **PULL** por si cambió algo en ese lapso *(obligatorio, si no lo hacen GIT se va a quejar)* y luego hacen un **PUSH** de la siguiente manera:

        $ git status # muestra en rojo los archivos modificados
        $ git add <archivo o carpeta> # hacer tantas veces como n° de files
        $ git status # ésta vez mostrará en verde los ya agregados
        $ git commit -m "<Comentario Obligatorio>" # prepara para el push
        $ git push origin master # realiza el push

Siempre que hagan un **PULL** o un **PUSH** les pedirá su contraseña de bitbucket.


### **Sección "ME MANDÉ UNA CAGADA" :** ###
Ante cualquier cagada grande que se "rompa" su repositorio local, **NUNCA HACER UN PUSH**. La idea es mantener el mainline (repo online) lo más prolijo y siempre funcionando.

En caso de que se les llegara a romper, hagan una copia de los archivos nuevos en los que trabajaron y borren toda la carpeta. Después abren la terminal y se hacen un **CLONE** del mainline en su máquina haciendo lo siguiente:

        $ git clone https://github.com/fpenovi/7507AlgoFormersT9.git

Luego pegan los archivos en los que trabajaron y hacen un **PUSH**

.

* *¿Qué pasa si hice add de un archivo que no quiero?*

        $ git status # aparece en verde los agregados
        $ git reset HEAD <carpeta o archivo> # saca el "add"
        $ git status # aparece en rojo el que sacaste.

.

* *Hice un commit y me salió una pantalla rara de* **GNU NANO** *o* **VIM** *pidiéndome que escriba un mensaje.*

Te olvidaste de ponerle el comando -m "<Comentario>" al commit!! **Los comentarios son obligatorios para subir algo!!**

Podés escribir en esa pantalla tu comentario, después apretar **CTRL+X** después **Y** (yes) y por último **ENTER** y se habrá realizado el commit. Ya podes hacer **PUSH**
