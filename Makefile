all: clean
	javac ./simulator/WeatherTower.java 
	javac ./simulator/CustomException.java
	find . -depth -name "*.java" >> sources.txt
	javac -d . -sourcepath @sources.txt
clean:
	rm -rf sources.txt simulation.txt
	find . -depth -name "*.class" -delete