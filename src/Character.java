import java.util.Scanner;

/**
 * Lindsey Olson
 * WMC @ RIT
 * 2019
 * Version 1.0 5.27.19
 */

public class Character
{
    /**
     * Here are all of the parts to a character
     * We have their name, which will end up being
     * entered by the user.
     * We have their fireSkill, woodSkill, fishingSkill,
     * and buildingSkill, which will all determine how
     * frequently they find goods and are able to use them.
     * We have their charisma, a random number which they will
     * never see but will come in handy come the day they meet
     * the town. Then they have their wood, food, rawFood,
     * and rock, all of which begin at 0 and are counters.
     */
    String name;
    int stamina;
    int fireSkill;
    int woodSkill;
    int fishingSkill;
    int miningSkill;
    int buildingSkill;
    int charisma;
    int wood;
    int food;
    int rawFood;
    int rock;

    /**
     * The constructor for the Character,
     * which will get the name and then
     * randomly set the skills. It will also set
     * all the counters to 0 except stamina,
     * which will begin at 100.
     */
    public void Character()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name ");
        this.name = sc.nextLine();

        fireSkill = (int)(Math.random() * 101);
        woodSkill = (int)(Math.random() * 101);
        fishingSkill = (int)(Math.random() * 101);
        buildingSkill = (int)(Math.random() * 101);
        miningSkill = (int)(Math.random() * 101);
        charisma = (int)(Math.random() * 101);

        wood = 0;
        food = 0;
        rawFood = 0;
        rock = 0;
        stamina = 100;
    }

    /**
     * This is a getter for the character's name
     * @return the name
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * This is a getter for the character's
     * fire skill
     * @return their fire skill
     */
    public int getFireSkill()
    {
        return fireSkill;
    }

    /**
     * This is a getter for the character's
     * stamnia, which, if it hits low numbers,
     * means bad things for the user.
     * @return their stamina
     */
    public int getStamina()
    {
        return stamina;
    }

    /**
     * This is a setter for the character's stamina
     * This will allow stamina points to be
     * taken away if doing something strenuous
     * or added if doing something beneficial
     * @param x - the integer by which
     *          the stamina changes
     */
    public void setStamina(int x)
    {
        stamina += x;
        if (stamina > 100)
        {
            stamina = 100;
        }
        if (stamina <= 0)
        {
            System.out.println("You have died. Your game is over.");
            System.exit(0);
        }
    }

    /**
     * This is a getter for the character's
     * wood skill
     * @return their wood skill
     */
    public int getWoodSkill()
    {
        return woodSkill;
    }

    /**
     * This is a getter for the character's
     * fishing skill
     * @return their fishing skill
     */
    public int getFishingSkill()
    {
        return fishingSkill;
    }

    /**
     * This is a getter for the character's
     * building skill
     * @return their building skill
     */
    public int getBuildingSkill()
    {
        return buildingSkill;
    }

    /**
     * This is a getter for the character's
     * mining skill
     * @return their mining skill
     */
    public int getMiningSkill()
    {
        return miningSkill;
    }

    /**
     * This is a getter for the character's
     * charisma
     * @return their charisma
     */
    public int getCharisma()
    {
        return charisma;
    }

    /**
     * This is a getter for the
     * amount of wood the user has
     * currently
     * @return their wood count
     */
    public int getWood()
    {
        return wood;
    }

    /**
     * This is a setter for the
     * amount of wood the user
     * gains or loses
     * @param i - the integer by
     *          which the wood count
     *          changes
     */
    public void setWood(int i)
    {
        wood = wood + i;
    }

    /**
     * This is a getter for the
     * amount of food the user has
     * @return their food
     */
    public int getFood()
    {
        return food;
    }

    /**
     * This is a getter for the
     * amount of raw food the user has
     * @return their raw food
     */
    public int getRawFood()
    {
        return rawFood;
    }

    /**
     * This is how the amount of
     * food will change
     * @param i the integer amount
     *          the food count changes by
     */
    public void setFood(int i)
    {
        food += i;
        if (food < 0)
        {
            System.out.println("You have no food - go cook some.");
            food = 0;
        }
    }

    /**
     * This is a setter of how
     * to change the raw food
     * count
     * @param i the integer amount
     *          the raw food count
     *          will change by
     */
    public void setRawFood(int i)
    {
        rawFood += i;
        if (rawFood < 0)
        {
            System.out.println("You have no fish - go gather some.");
            rawFood = 0;
        }
    }

    /**
     * This is the getter for
     * the amount of rock that
     * the character has at
     * the moment
     * @return their rock count
     */
    public int getRock()
    {
        return rock;
    }

    /**
     * Set the user's rock
     * count to increase or
     * decrease by the variable i
     * @param i - the integer
     *          amount that the
     *          rock count will
     *          change by
     */
    public void setRock(int i)
    {
        rock = rock + i;
    }


}
