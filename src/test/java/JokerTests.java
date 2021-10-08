import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

final class JokerTests {
    @Test
    public void jokerUsesCorrectUrl() {
        // Arrange
        var client = new HttpClient() {
            @Override
            public String getText(String url) throws IOException {
                // Assert
                assertThat(url, is("https://icanhazdadjoke.com/"));
                return "ha ha";
            }
        };
        // Act
        Joker.getJokes(1, client);
    }

    @Test
    public void jokerFetchesAsManyJokesAsRequested() {
        // AtomicInteger, besides being atomic, is a convenient way to hold an int
        AtomicInteger counter = new AtomicInteger();
        // Arrange
        var client = new HttpClient() {
            @Override
            public String getText(String url) throws IOException {
                return "J" + counter.getAndIncrement();
            }
        };
        // Act
        var jokes = Joker.getJokes(2, client);
        // Assert
        assertThat(jokes, contains("J0", "J1"));
    }
}
