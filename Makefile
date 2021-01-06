run: compile
	java --module-path '/Users/Alt/Desktop/javafx-sdk-11.0.2/lib' --add-modules javafx.controls Main

compile:
	javac --module-path '/Users/Alt/Desktop/javafx-sdk-11.0.2/lib' --add-modules javafx.controls,javafx.graphics Main.java
	javac Backend.java
	javac CourseNode.java
	javac DegreeNode.java
	javac GraphADT.java
	javac HashNode.java
	javac HashTableMap.java
	javac MajorGraph.java
	javac MajorMaker.java
	javac MapADT.java

test: compile
	javac -cp .:junit5.jar PrimTest.java
	javac -cp .:junit5.jar testBackend.java
	javac -cp .:junit5.jar testGraph.java
	java -jar junit5.jar --classpath . --scan-classpath --details tree --include-classname='.*test.*|.*Test.*'

clean:
	$(RM) *.class
