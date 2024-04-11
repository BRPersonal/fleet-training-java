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



