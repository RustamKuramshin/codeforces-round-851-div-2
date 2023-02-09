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
        int result = 0;
        List<Integer> list = new ArrayList<>();
        for (int mask = 0; mask < (1 << n); mask++) { // перебор масок
            for (int j = 0; j < n; j++) { // перебор индексов массива
                if((mask & (1 << j)) != 0) { // поиск индекса в маске
                    list.add(points[j]); // yield
                }
            }
            result += calcResult(list);
            list.clear(); // перевод строки для вывод следующего подмножества
        }
        int delimiter = (int) 1e9 + 7;
        out.println(result % delimiter);
        out.close();
    }

    private static int calcResult(List<Integer> list) {
        int size = list.size();
        if (size == 0 || size == 1) {
            return 0;
        }
        if (size == 2 || size == 3) {
            return 1;
        }
        int coef = 0;
        if (list.get(1) - list.get(0) <= list.get(2) - list.get(1)) {
            if (list.get(2) - list.get(1) > list.get(3) - list.get(2)) {
                coef = 1;
            }
        }
        list.remove(0);
        return calcResult(list) + coef;
    }
}