PROJ=rest
all:
	javac `find $(PROJ) pt -name "*.java"`
run:
	java $(PROJ).Manager
swing:
	java -Dui=swing $(PROJ).Manager
clean:
	rm -f `find $(PROJ) pt -name "*.class"`
