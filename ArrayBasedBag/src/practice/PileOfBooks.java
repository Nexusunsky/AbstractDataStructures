package practice;

public interface PileOfBooks {
    /**
     * Get current number of entries in this bag
     *
     * @return The integer number of entries currently in the pile.
     */
    int getCurrentSize();

    /**
     * Sees whether this book pile is empty.
     *
     * @return True if the book pile is empty or false if not.
     */
    boolean isEmpty();

    /**
     * Put a book into the top of the Book pile.
     *
     * @param book The book put on.
     * @return True if success, False otherwise.
     */
    void put(String book);


    /**
     * Take a book from the top of the book pile
     *
     * @return String The book taken from the book pile.
     */
    String take();
}