public final class PeopleCounter {
    private final int max;
    private int count;

    public PeopleCounter(int max) {
        if (max < 0) {
            throw new IllegalArgumentException("Max must be >=0");
        }

        this.max = max;
        this.count = 0;
    }

    public boolean increment() {
        if (count == max) {
            return false;
        }
        count++;
        return true;
    }

    // Note: What should happen if count is 0 here?
    // Not doing anything *seems* like the right choice;
    // but in the real-world, confirm these decisions with the customer!
    public void decrement() {
        if (count > 0) {
            count--;
        }
    }

    public void reset() {
        count = 0;
    }

    public int count() {
        return count;
    }
}
