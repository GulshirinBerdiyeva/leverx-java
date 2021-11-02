# simple-string-transformer
## compile project from cmd and build jar

Change current directory to project absolute path
>**cd D:/work/StringTransformer**

Generate source code (.java) 
to bytecode (platform independent, intermediate language between source and machine languages) 
and save compiled (.class) by given path
>**javac -d ./classes -cp ./src/main/java ./src/main/java/com/leverx/course/\*.java**

Run bytecode (.class) with arguments
>**java -cp ./classes com.leverx.course.Main Happy New Year**

Create (.jar) file \
cvfe: v - verbose output while file is being built, e - entrypoint com.leverx.course.Main \
in META-INF/MANIFEST.MF will be written as\
Main-Class: com.leverx.course.Main
>**cd classes** \
>**jar cvfe StringTransformer.jar com.leverx.course.Main com/leverx/course/\*.class**

Print (.jar) file content
>**jar tf StringTransformer.jar**

Save meta-file to see content
>**jar xf StringTransformer.jar META-INF/MANIFEST.MF**

Run bytecode from jar file with arguments
>**java -jar StringTransformer.jar Happy New Year**

Example output
>**Converted to lower case: happy new year \
Converted to upper case: HAPPY NEW YEAR \
Replaced spaces with underscore: Happy_New_Year \
Reversed: raeY weN yppaH**

Disassemble bytecode (.class)
>**javap -c ./com/leverx/course/\*.class**
