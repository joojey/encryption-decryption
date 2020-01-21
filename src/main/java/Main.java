import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        String mode = "enc";
        int key = 0;
        String data = "";
        String out = "";
        String in = "";
        String output = "";
        String alg = "";

        for (int i = 0; i < args.length; i ++) {
            if (args[i].equals("-mode")) {
                mode = args[i + 1];
            } else if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
            } else if (args[i].equals("-data")) {
                data = args[i + 1];
            } else if (args[i].equals("-out")) {
                out = args[i + 1];
            } else if (args[i].equals("-in")) {
                in = args[i + 1];
            } else if (args[i].equals("-alg")) {
                alg = args[i + 1];
            }
        }

        if (data.equals("") && !in.equals("")) {
            try {
                readFile(in);
                data = readFile(in);
            } catch (IOException e) {
                System.out.println("Cannot read file: " + e.getMessage());
            }
        }

        Algorithm algorithm;
        switch (alg) {
            case "unicode":
                algorithm = new Unicode();
                break;
            default:
                algorithm = new Shift();
                break;
        }

        switch (mode) {
            case "dec":
                if (out.equals("")) {
                    System.out.println(algorithm.decrypt(data, key, output, out, alg));
                    break;
                } else {
                    writeFile(algorithm.decrypt(data, key, output, out, alg), out);
                    break;
                }
            default:
                if (out.equals("")) {
                    System.out.println(algorithm.encrypt(data, key, output, out, alg));
                    break;
                } else {
                    writeFile(algorithm.encrypt(data, key, output, out, alg), out);
                    break;
                }
        }
    }

    public static String readFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static void writeFile(String output, String out) {
        File filewrite = new File(out);

        try (FileWriter writer = new FileWriter(filewrite)) {
            writer.write(output);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}