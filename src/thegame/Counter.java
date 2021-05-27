// ID: 314987926
package thegame;

/**
 * The type Counter.
 */
public class Counter {
    private int count;

    /**
     * Instantiates a new Counter.
     *
     * @param theCount the count
     */
    public Counter(int theCount) {
        this.count = theCount;
    }

    /**
     * Sets count.
     *
     * @param theCount the count
     */
    public void setCount(int theCount) {
        this.count = theCount;
    }

    /**
     * add number to current count.
     *
     * @param number the number
     */

    public void increase(int number) {
        this.setCount(this.getValue() + number);
    }

    /**
     * subtract number from current count.
     *
     * @param number the number
     */

    public void decrease(int number) {
        this.setCount(this.getValue() - number);
    }

    /**
     * get current count.
     *
     * @return the int
     */

    public int getValue() {
        return this.count;
    }
}
