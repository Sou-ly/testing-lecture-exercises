import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

final class IsolatedFunctionsTests {
    // Nested classes are a convenient way to group tests (but not necessary)
    final static class Fibonacci {
        // Note how fibonacci returns a long, so we need to qualify the expected
        // return value as a long; a bit annoying here, but can prevent mistakes in the real-world

        @Test
        public void zero() {
            assertThat(IsolatedFunctions.fibonacci(0), is(0L));
        }

        @Test
        public void one() {
            assertThat(IsolatedFunctions.fibonacci(1), is(1L));
        }

        @Test
        public void two() {
            assertThat(IsolatedFunctions.fibonacci(2), is(1L));
        }

        @Test
        public void six() {
            assertThat(IsolatedFunctions.fibonacci(6), is(8L));
        }
    }

    final static class Split {
        @Test
        public void noSeparator() {
            assertThat(IsolatedFunctions.splitString("abc", 'x'), contains("abc"));
        }

        @Test
        public void separatorInMiddle() {
            assertThat(IsolatedFunctions.splitString("axc", 'x'), contains("a", "c"));
        }

        // The following tests do not pass because the code is buggy: it should not yield empty strings!
        // Fixing the code is left as an exercise for the reader. :-)

        @Test
        public void separatorAtBeginning() {
            assertThat(IsolatedFunctions.splitString("xabc", 'x'), contains("abc"));
        }

        @Test
        public void separatorAtEnd() {
            assertThat(IsolatedFunctions.splitString("abcx", 'x'), contains("abc"));
        }
    }

    final static class Shuffle {
        // This one is trickier because it doesn't have an exact result, by definition.
        // Instead we test a property that should hold regardless of the random result.
        // Also, it mutates its parameter instead of returning it, so we need a test that is more than one line

        @Test
        public static void sameItems() {
            // Arrange
            var array = new Integer[]{1, 2, 3, 4};
            // Act
            IsolatedFunctions.randomShuffle(array);
            // Assert
            assertThat(array, arrayContainingInAnyOrder(1, 2, 3, 4));
        }
    }
}
