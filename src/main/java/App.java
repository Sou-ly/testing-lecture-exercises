import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public final class App {
    private static final class RealHttpClient implements HttpClient {
        public String getText(String url) throws IOException {
            URL urlObj;
            try {
                urlObj = new URL(url);
            } catch (MalformedURLException e) {
                throw new IllegalArgumentException("Bad URL");
            }
            var connection = (HttpURLConnection) urlObj.openConnection();

            connection.setRequestProperty("Accept", "text/plain");
            try (var connectionStream = connection.getInputStream();
                 var s = new Scanner(connectionStream).useDelimiter("\\A")) {
                return s.next();
            }
        }
    }

    public static void main(String[] args) {
        System.out.print("Hello! How many times do you want to laugh? ");

        var scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        var jokes = Joker.getJokes(count, new RealHttpClient());
        for (int n = 0; n < jokes.size(); n++) {
            System.out.println("Joke " + n + ": " + jokes.get(n));
        }

        System.out.println("Hope you laughed! Bye!");
    }
}
