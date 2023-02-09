import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Task1 {

    public static PrintWriter out;

    public static class Reader {

        static BufferedReader reader;
        static StringTokenizer tokenizer;

        static void init(InputStream input) {
            reader = new BufferedReader(new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }

        static String next() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        static long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        static String nextLine() {
            String str = "";
            try {
                str = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int countTests = Reader.nextInt();
        for (int i = 0; i < countTests; i++) {
            int countNumbers = Reader.nextInt();
            int[] allNumbers = new int[countNumbers + 1];
            for (int j = 1; j <= countNumbers; j++) {
                int currentNumber = Reader.nextInt();
                allNumbers[j] = currentNumber;
            }
            for (int j = 1; j <= countNumbers; j++) {
                int left = 1;
                int right = 1;
                for (int k = 1; k <= j; k++) {
                    left *= allNumbers[k];
                }
                for (int k = j + 1; k <= countNumbers; k++) {
                    right *= allNumbers[k];
                }
                if (j == countNumbers) {
                    out.println(-1);
                    break;
                } else if (left == right) {
                    out.println(j);
                    break;
                }
            }
        }
        out.close();
    }
}