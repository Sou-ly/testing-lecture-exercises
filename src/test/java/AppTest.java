import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

final class AppTest {
    @Test
    public void zeroLeadsToNoJokes() {
        var fakeIn = new ByteArrayInputStream("0".getBytes());
        System.setIn(fakeIn);

        var fakeOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(fakeOut, true, StandardCharsets.UTF_8));

        App.main(new String[0]);

        var outString = fakeOut.toString(StandardCharsets.UTF_8);

        assertThat(outString, containsString("Hello!"));
    }

    // No solutions here, we already show you how to do it above :-)
}
