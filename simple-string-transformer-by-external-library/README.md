# simple-string-transformer-by-external-library

## compile project from cmd and build jar

The only difference when performing 2 procedures above \
if we included external library, \
is that we need to point classloader to external library (.jar) file too \
on Windows directories separated by a semicolon (;) \
on Unix and MAC OS X separated by a colon (:)


>**javac -d ./classes -cp ./src/main/java;commons-lang3-3.0.jar ./src/main/java/com/leverx/course/\*.java**

>**java -cp ./classes;commons-lang3-3.0.jar com.leverx.course.Main Happy New Year**

>**cd classes** \
>**jar cvfe StringTransformer.jar com.leverx.course.Main  com/leverx/course/\*.class ../commons-lang3-3.0.jar**

>**jar tf StringTransformer.jar**

>**jar xf StringTransformer.jar META-INF/MANIFEST.MF**

>**java -cp StringTransformer.jar;../commons-lang3-3.0.jar com.leverx.course.Main Happy New Year**

>**javap -c ./com/leverx/course/\*.class**
