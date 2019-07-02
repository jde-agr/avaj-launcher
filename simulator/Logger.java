package simulator;

import java.io.*;

public class Logger {
    private static Logger logger = new Logger("simulation.txt");
    private FileWriter fr = null;

    public Logger(String file) {
        try {
            this.fr = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getLogger() {
        return Logger.logger;
    }

    public void writeToFile(String data) {
        try {
            fr.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeFile() {
        try {
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}