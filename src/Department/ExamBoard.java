package Department;

public class ExamBoard {
    private final String name;

    /**
     * Constructs a new exam board with the specified name.
     *
     * @param name The name of the exam board.
     */
    public ExamBoard(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the exam board.
     *
     * @return The name of the exam board.
     */
    public String getName() {
        return name;
    }
}
