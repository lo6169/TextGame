/**
 * Lindsey Olson
 * WMC @ RIT
 * 2019
 * Version 1.0 5.27.19
 */

public class Quarry
{
    public boolean unlocked = false;
    public double chance = 0.10;

    public boolean isUnlocked()
    {
        return unlocked;
    }

    public void setUnlocked(boolean boo)
    {
        unlocked = boo;
    }

    public double getChance()
    {
        return chance;
    }
}
