import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class PeopleCounterTests {
    @Test
    public void maximumCannotBeNegaitve() {
        assertThrows(IllegalArgumentException.class, () -> new PeopleCounter(-1));
    }

    @Test
    public void incrementAddsOneToCount() {
        // Arrange
        var counter = new PeopleCounter(50);
        // Act
        counter.increment();
        // Assert
        assertThat(counter.count(), is(1));
    }

    @Test
    public void decrementDecreasesCountByOne() {
        // Arrange
        var counter = new PeopleCounter(50);
        counter.increment();
        // Act
        counter.decrement();
        // Assert
        assertThat(counter.count(), is(0));
    }

    @Test
    public void resetSetsCountToZero() {
        // Arrange
        var counter = new PeopleCounter(50);
        counter.increment();
        counter.increment();
        // Act
        counter.reset();
        // Assert
        assertThat(counter.count(), is(0));
    }

    @Test
    public void cannotIncrementOnceMaximumIsReached() {
        // Arrange
        var counter = new PeopleCounter(2);
        counter.increment();
        counter.increment();
        // Act
        var result = counter.increment();
        // Assert
        assertThat(result, is(false));
    }
}
