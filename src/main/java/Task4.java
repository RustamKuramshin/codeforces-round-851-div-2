import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Task4 {

    public static PrintWriter out;

    public static class Reader {

        static BufferedReader reader;
        static StringTokenizer tokenizer;

        static void init(InputStream input) {
            reader = new BufferedReader(new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }

        static String next() throws IOException {
            while ( ! tokenizer.hasMoreTokens() ) {
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
        final int n = Reader.nextInt();
        int[] points = new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = Reader.nextInt();
        }
        int nn = n * (n - 1);
        int result = nn / 2 + nn * (n - 2) / 6;
        List<Integer> list = new ArrayList<>();
        for (int mask = 0; mask < (1 << n); mask++) { // перебор масок
            for (int j = 0; j < n; j++) { // перебор индексов массива
                if ((mask & (1 << j)) != 0) { // поиск индекса в маске
                    list.add(points[j]); // yield
                }
            }
            if (list.size() > 3) {
                result += calcResult(list);
            }
            list.clear();
        }
        int delimiter = (int) 1e9 + 7;
        out.println(result % delimiter);
        out.close();
    }

    private static int calcResult(List<Integer> list) {
        int result = 1;
        for (int i = 1; i < list.size() - 2; i++) {
            if (list.get(i) - list.get(i - 1) <= list.get(i + 1) - list.get(i)) {
                if (list.get(i + 1) - list.get(i) > list.get(i + 2) - list.get(i + 1)) {
                    result += 1;
                }
            }
        }
        return result;
    }
}