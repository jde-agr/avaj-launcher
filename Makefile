all: clean
	find . -depth -name "*.java" >> sources.txt
	javac ./weather/Coordinates.java
	javac -d . -sourcepath @sources.txt
clean:
	rm -rf sources.txt simulation.txt
	find . -depth -name "*.class" -delete