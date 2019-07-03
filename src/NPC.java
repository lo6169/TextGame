import java.util.Random;

/**
 * Lindsey Olson
 * WMC @ RIT
 * 2019
 * Version 1.0 6.25.19
 */

public class NPC
{
    /**
     * This class, NPC, Non-Player Character,
     * will be used to make characters that the player
     * will potentially end up meeting and will have a
     * chance to fall in love with.
     * This class will only be used in Town.
     */

    // These are the characteristics of an NPC
    String name;
    int charisma;

    int goodness; // this will determine if a character is
        // a murderer, a neutral person, or a potential lover

    /**
     * This is the constructor
     * for non-player characters.
     * These will be the friends and lovers
     * of the person playing.
     */
    public NPC()
    {
        name = randomName();
        charisma = (int)(Math.random() * 101);
        goodness = (int)(Math.random() * 11);
    }

    /**
     * This is a random name generator used in both NPC and Merchants
     * classes. I could use a class hierarchy but I didn't. So here are
     * two separate functions.
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
     * A getter for
     * the NPC's goodness
     * level
     * @return
     */
    public int getGoodness()
    {
        return goodness;
    }

    /**
     * A setter for the NPC's
     * goodness level
     * @param i
     */
    public void setGoodness(int i)
    {
        goodness = i;
    }

    /**
     * A getter for the
     * character's name
     * @return
     */
    public String getName()
    {
        return name;
    }

    public int getCharisma()
    {
        return charisma;
    }

    public void setCharisma(int i)
    {
        charisma = i;
    }
}
