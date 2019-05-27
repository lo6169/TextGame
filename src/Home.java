/**
 * Lindsey Olson
 * WMC @ RIT
 * 2019
 * Version 1.0 5.27.19
 */

public class Home
{
    /**
     * This boolean, fireGoing,
     * is used to see if the person
     * needs to stoke the fire
     * in order to cook
     */
    public boolean fireGoing;

    /**
     * The constructor for Home
     */
    public Home()
    {

    }

    /**
     * See if the fire is going or not
     * @return true or false depending
     * on if the fire is going or not
     */
    public boolean isFireGoing()
    {
        return fireGoing;
    }

    /**
     * Set the fire to be going or not
     * depending on if it has been stoked
     * Every time the person leaves their home
     * set this boolean to false
     * @param boo - true or false, if the
     *            fire is going or not.
     */
    public void setFireGoing(boolean boo)
    {
        fireGoing = boo;
    }

}
