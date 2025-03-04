import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class MainTest {

    private List<Programmer> programmers;

    @BeforeEach
    void setUp() {
        programmers = Main.getProgrammers();
    }

    @Test
    @DisplayName("Test1")
    void listFromAllTasks() {

        var allTasks = programmers.stream()
                .flatMap(p -> p.tasks().stream())
                .toList();

        assertNotNull(allTasks);
        assertEquals(35, allTasks.size());
    }

    @Test
    @DisplayName("Test2")
    void filteredListFromAllTasks() {
        var filteredTasks = programmers.stream()
                .filter(p -> p.city().equalsIgnoreCase("Berlin"))
                .flatMap(p -> p.tasks().stream())
                .filter(t -> t.daysInProcessing() > 5 && !t.status().equalsIgnoreCase("done"))
                .toList();

        assertNotNull(filteredTasks);
        assertEquals(3, filteredTasks.size());
    }
}