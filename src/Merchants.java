/**
 * Lindsey Olson
 * WMC @ RIT
 * 2019
 * Version 1.0 6.21.19
 */

public class Merchants
{
    /**
     * This class, Merchant, will be used to create
     * merchants that the character will encounter
     * if they discover the town. Here, they will
     * end up determining a barter price for each good,
     * and then the character can decide if they want to
     * trade or not.
     * However, not all of them will be good, and some
     * will steal some of the character's goods.
     * This class will also be used for carpentry.
     * This class will only be used in Town.
     */

    String name;
    int greed; // this will be used to determine how
    // easily they will sell goods
    boolean good = true; //this will be changed sometimes
    // and will determine if the merchant will steal from the character

    public void Merchant()
    {

    }

    public String getName()
    {
        return name;
    }

    public void setName(String s)
    {
        name = s;
    }

}
