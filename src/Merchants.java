import java.util.Random;

/**
 * Lindsey Olson
 * WMC @ RIT
 * 2019
 * Version 1.0 6.24.19
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

    public String name;
    //These will be a multiplier to decide
    // how greedy the merchant is
    int greedWood;
    int greedFood;
    int greedRock;

    int goodness; //this will be changed sometimes
    // and will determine if the merchant will steal from the character

    boolean merchantFound = false; // this will be set to true IFF a merchant has been found

    /**
     * The constructor for merchant,
     * this will automatically set
     * the different greed levels.
     */
    public Merchants()
    {
        setName(randomName());

        setGreedFood((int)(Math.random() * 10));
        setGreedRock((int)(Math.random() * 10));
        setGreedWood((int)(Math.random() * 10));

        setGoodness((int)(Math.random() * 10));
    }

    /**
     * Here we will create a randomized name for the merchant,
     * including first and last. There are a substantial amount of
     * potential combinations that could occur, so it is unlikely
     * that it would create the same one, over and over.
     * So, hypothetically, for each merchant created, it will have
     * a unique name. A similar function (if not the same) will be
     * used in NPC.
     * @return
     */
    public String randomName()
    {
        String[] beginning = {"Ba", "Be", "Bi", "Bo", "Bu", "Ca", "Ce", "Ci", "Co", "Cu",
            "Da", "De", "Di", "Do", "Du", "Fa", "Fe", "Fi", "Fo", "Fu", "Ga", "Ge", "Gi",
            "Go", "Gu", "Ha", "He", "Hi", "Ho", "Hu", "Ja", "Je", "Ji", "Jo", "Ju", "Ka",
            "Ke", "Ki", "Ko", "Ku", "La", "Le", "Li", "Lo", "Lu", "Ma", "Me", "Mi", "Mo",
            "Mu", "Na", "Ne", "Ni", "No", "Nu", "Pa", "Pe", "Pi", "Po", "Pu", "Ra", "Re",
            "Ri", "Ro", "Ru", "Sa", "Se", "Si", "So", "Su", "Ta", "Te", "Ti", "To", "Tu",
            "Va", "Ve", "Vi", "Vo", "Vu", "Wa", "We", "Wi", "Wo", "Wu", "Ya", "Ye", "Yi",
            "Yo", "Yu", "Za", "Ze", "Zi", "Zo", "Zu"};
        String[] middle = {"lori", "land", "misor", "cred", "darc", "sey", "lex",
            "zem", "ed", "gari", "ry", "ston", "stin", "son", "ran", "vek", "ney",
            "yan", "maj", "jit", "muel"};

        String[] lastEnd = {"zire", "mire", "tor", "dun", "nad", "trip", "man", "zon",
            "tar", "trite", "san", "jit", "tri", "patters", "tterson", "tinson", "cobson",
            "yin"};

        Random rand = new Random();
        return beginning[rand.nextInt(beginning.length)] + middle[rand.nextInt(middle.length)] + " " +
                beginning[rand.nextInt(beginning.length)] + lastEnd[rand.nextInt(lastEnd.length)];
    }

    /**
     * Get the merchant's name
     * @return their name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set the merchant's name.
     * @param s = the string to
     *          set their name to
     */
    public void setName(String s)
    {
        name = s;
    }

    /**
     * Get the merchant's
     * greed level when it comes to wood
     * which will be measured on a
     * scale of 1-10, which is how
     * many items they desire
     * in return for wood.
     * @return - their greed
     * level
     */
    public int getGreedWood()
    {
        return greedWood;
    }

    /**
     * Set the merchant's greed level
     * for wood
      * @param i
     */
    public void setGreedWood(int i)
    {
        greedWood = i;
    }

    /**
     * Get the merchant's
     * greed level when it comes to food
     * which will be measured on a
     * scale of 1-10, which is how
     * many items they desire
     * in return for food, cooked or raw.
     * @return - their greed
     * level
     */
    public int getGreedFood()
    {
        return greedFood;
    }

    /**
     * set the merchant's greed
     * level for food, cooked or
     * raw
     * @param i
     */
    public void setGreedFood(int i)
    {
        greedFood = i;
    }

    /**
     * Get the merchant's
     * greed level when it comes to rock
     * which will be measured on a
     * scale of 1-10, which is how
     * many items they desire
     * in return for rock.
     * @return - their greed
     * level
     */
    public int getGreedRock()
    {
        return greedRock;
    }

    /**
     * set the merchant's greed level
     * for rocks
     * @param i
     */
    public void setGreedRock(int i)
    {
        greedRock = i;
    }

    /**
     * set the merchant's
     * level of goodness or
     * evil. If it's above a 5,
     * they will do no harm.
     */
    public void setGoodness(int i)
    {
        goodness = i;
    }

    /**
     * Get the merchant's goodness
     * to determine whether or not
     * they will do harm to the character
     * @return
     */
    public int getGoodness()
    {
        return goodness;
    }

    /**
     * Check to see if this
     * merchant has been found
     * @return
     */
    public boolean isMerchantFound()
    {
        return merchantFound;
    }

    /**
     * Set this to decide if
     * the character has found a
     * merchant or not.
     * @param b
     */
    public void foundMerchant(boolean b)
    {
        merchantFound = b;
    }

}
