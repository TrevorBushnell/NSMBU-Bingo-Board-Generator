# run 'make java' to compile Java code and run the Main program

java:
	javac *.java
	java Main
	

clean:
	rm -r *.class
