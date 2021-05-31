package Exercise.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console implements IConsole {
    @Override
    public int readInteger(String text) {
        while (true) {
            String input = readString(text);
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException nfe) {
                write(String.format("Entered input: %s is not a number", input));
            }
        }
    }

    @Override
    public String readString(String text) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                write(text);
                return br.readLine().trim();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void write(String s) {
        System.out.println(s);
    }
}
