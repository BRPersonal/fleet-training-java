//TODO - try out these fp exercises
https://medium.com/@ujjawalr/10-java-stream-power-moves-java-8-to-17-that-instantly-make-you-look-like-a-pro-4ef836f51c4a



#compile Java classes
gradle clean compileJava compileTestJava
gradle clean build

#run junits
gradle clean test

#run the program passing some command line arguments
#gradle --console plain run --args="one two 'three four'"

#run the program without command line arguments
gradle --console plain run

Enter package (1 - fp 2 - generics 3 - optional 4 - concurrent 5 - misc):1 or 2 or 3 or 4 or 5
Enter class name to run in console


01-Aug-26
-----------
Upgrading to Java 25
Gradle daemon → pinned to JDK 21 via gradle.properties (Gradle 8.14 doesn't run on JDK 25 yet)
Lombok → bumped 1.18.30 → 1.18.46 (old version didn't know JDK 21's javac internals)
Your java { toolchain { languageVersion = 25 } } block stayed untouched — that's still handling compiling/running your actual code on 25


