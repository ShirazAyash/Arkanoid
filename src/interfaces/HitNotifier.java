// ID: 314987926
package interfaces;

/**
 * The interface Hit notifier.
 */
public interface HitNotifier {
    /**
     * Add hl as a listener to hit events.
     *
     * @param hl the hitLister
     */
    void addHitListener(HitListener hl);

    /**
     * Remove hl from the list of listeners to hit events.
     *
     * @param hl the hitLister
     */
    void removeHitListener(HitListener hl);
}
