import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Task2 {

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
        int countT = Reader.nextInt();
        for (int i = 0; i < countT;i++){
            int num = Reader.nextInt();
            int numDelet = num / 2;
            if (num % 2 == 0){
                out.println(num/2 + " " + num/2);
                continue;
            }
            int first = numDelet + 1;
            int second = numDelet;
            while ((pluser(first) - (pluser(second))) != 1 && (pluser(first) - (pluser(second))) != 0 ){
                first++;
                second--;
            }
            out.println(first + " " + second);
        }
        out.close();
    }

    public static int pluser(int num){
        int sum = 0;
        while(num != 0){
            sum += (num % 10);
            num/=10;
        }
        return sum;
    }
}