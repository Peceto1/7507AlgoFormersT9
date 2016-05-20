README by Francisco Penovi

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