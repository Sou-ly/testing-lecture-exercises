import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class PizzaTests {
    // Note: IDEs may or may not display branch coverage.
    // Generating a report with gradle's "build" task is the easiest way to get it.

    @Test
    public void cannotHaveNullName() {
        assertThrows(IllegalArgumentException.class, () -> new Pizza(null, false, new String[0]));
    }

    @Test
    public void cannotHaveBlankName() {
        assertThrows(IllegalArgumentException.class, () -> new Pizza(" ", false, new String[0]));
    }

    @Test
    public void cannotHaveNullToppingsArray() {
        assertThrows(IllegalArgumentException.class, () -> new Pizza("MyPizza", false, null));
    }

    @Test
    public void printPizzaReturnsDocumentedFormat() {
        // Arrange
        var pizza = new Pizza("MyPizza", false, new String[]{"cheese"});
        // Act
        var str = pizza.toString();
        // Assert
        assertThat(str, is("Pizza MyPizza, cheese"));
    }

    @Test
    public void printCalzoneReturnsDocumentedFormat() {
        // Arrange
        var pizza = new Pizza("KindaAPizza", true, new String[]{"ham"});
        // Act
        var str = pizza.toString();
        // Assert
        assertThat(str, is("Calzone KindaAPizza, ham"));
    }

    @Test
    public void badToppingChoiceShouldBeChided() {
        // Arrange
        var pizza = new Pizza("Wrong", false, new String[]{"ham", "ketchup"});
        // Act
        var str = pizza.toString();
        // Assert
        assertThat(str, is("Pizza Wrong, ham, ketchup (Mamma mia, why would you do this?)"));
    }

    // This test is not necessary for 100% branch coverage, but if you uncomment it...

    /*@Test
    public void cannotHaveNullTopping() {
        assertThrows(IllegalArgumentException.class, () -> new Pizza("Weird", false, new String[]{"ham", null}));
    }*/
}
