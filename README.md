# TFGFinal
Això és un projecte d'IntelliJ Idea del meu treball de fi de grau sobre la Monitorització automàtica de bases de dades NoSQL per entorns batch.

Aquest projecte només es pot probar en un entorn que tingui accés a un node de minerva (BD de Cassandra del DAC FIB) o directament desde un dels
seus nodes.

A la carpeta out, a artifacts es troba l'execuable .jar i el .yaml que serbeix per configurar l'aplicació.

A la carpeta scr/TFGPkg es troben tots els fitxers .java i el .form per a consultar el codi font o fer-li modificacións.

En cas de voler compilar un mateix es recomana:
   - Importar el projecte a IntelliJ Idea
   
   - Anar a File --> Project Structure --> Artifacts
   - Donar-li al + --> JAR --> From modules with dependencies 
   - En Main Class seleccionar Principal.java
   - Seleccionar extract to the target JAR --> OK
   
   - Anar a File --> Project Structure --> Modules --> Dependencies
   - Donar-li a + --> JARs or Directories --> importar SnakeYaml-1.30.jar (1)
   - Seleccionar la checkbox de Export i l'scope a Compile
    
   - Importar els .jar de les llibreries jcommon-1.0.23.jar (2), jfreechart-1.0.19.jar (3)
   - Finalment anar a  Build --> Build Artifacts --> Build
  
L'arxiu jar apareixera a la carpeta out del projecte

   - (1) https://search.maven.org/search?q=g:org.yaml%20AND%20a:snakeyaml .
   - (2) https://sourceforge.net/projects/jfreechart/files/ --> Descomprimir --> jfreechart-1.0.19/lib/jcommon-1.0.23.jar .
   - (3) https://sourceforge.net/projects/jfreechart/files/ --> Descomprimir --> jfreechart-1.0.19/lib/jfreechart-1.0.19.jar .
