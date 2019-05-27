/**
 * Lindsey Olson
 * WMC @ RIT
 * 2019
 * Version 1.0 5.27.19
 */

public class Quarry
{
    /**
     * This is a boolean to
     * determine whether or not
     * this area has been unlocked.
     * Chance might be deleted.
     */
    public boolean unlocked = false;
    public double chance = 0.10;

    /**
     * Return true or false
     * to determine whether or
     * not this area is unlocked
     * @return - if it's unlocked
     */
    public boolean isUnlocked()
    {
        return unlocked;
    }

    /**
     * Set the boolean unlocked
     * to be the param boo, so that
     * when someone unlocks this area,
     * it resets the boolean to be true
     * @param boo - whether unlocked
     *            or not
     */
    public void setUnlocked(boolean boo)
    {
        unlocked = boo;
    }

    /**
     * Return the chances of being found
     * This might be deleted
     * @return
     */
    public double getChance()
    {
        return chance;
    }
}
