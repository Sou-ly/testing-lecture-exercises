import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface HttpClient {
    String getText(String url) throws IOException;
}

public final class Joker {
    // The Joker now returns strings and takes in an HTTP client
    public static List<String> getJokes(int count, HttpClient client) {
        var result = new ArrayList<String>();
        for (int n = 0; n < count; n++) {
            try {
                result.add(client.getText("https://icanhazdadjoke.com/"));
            } catch (IOException e) {
                throw new RuntimeException("Cannot fetch jokes.", e);
            }
        }
        return result;
    }
}
