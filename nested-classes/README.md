# nested-classes-compilation

After compilation nested classes(static nested, non-static inner) \
separated from enclosing class by (dollar) sign \
Local classes in addition being separated by (dollar) sign they're also numbered \
to avoid a repetition in case a same local class name

>**javac -d ./classes ./src/main/java/com/leverx/course/\*.java**

>**java -cp ./classes com.leverx.course.Main**

>**dir ./classes/com/leverx/course/**

>**jar cvfe NestedClasses.jar com.leverx.course.Main com/leverx/course/\*.class**

>**jar tf NestedClasses.jar**

>**jar xf NestedClasses.jar META-INF/MANIFEST.MF**

>**java -cp NestedClasses.jar com.leverx.course.Main**

>**javap -c ./classes/com/leverx/course/\*.class** 
