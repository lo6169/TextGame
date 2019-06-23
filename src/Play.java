import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * Lindsey Olson
 * WMC @ RIT
 * 2019
 * Version 1.0 6.23.19
 */

public class Play
{
    /**
     * Call the beginning() function
     * so that the journey may begin.
     * @param args
     */
    public static void main(String[] args)
    {
        beginning();
    }

    /**
     * Begin the world, and show the traveller how
     * their fates landed them here. Then, build
     * their life and watch them travel.
     */
    public static void beginning()
    {
        String expl = "It began years ago - you came out here seeking refuge " +
                "from the everyday monotonies of work and life. However, you " +
                "lost your ways. \n Now, you live in this humble shack. What " +
                "you choose to do with this life is yours, but be warned, " +
                "life is fleeting, and a life in the woods is dangerous. " +
                "Stray wisely, young one. I hope we shall meet again. ";


        Scanner s = new Scanner(System.in);
        System.out.println("Welcome, young traveller. \nWould you like to hear " +
                "how your fate landed you here? (y/n)");
        String ans = s.nextLine();
        if (ans.equals("y") || ans.equals("Y"))
        {
            System.out.println(expl);
            buildLife();
        }
        else if (ans.equals("n") || ans.equals("N"))
        {
            buildLife();
        }
        else
        {
            System.out.println("I'm sorry, young traveller. I did not understand your request.");
            beginning();
        }
    }

    /**
     * Begin by creating a character and setting their
     * name, then go to their homeChoices().
     */
    public static void buildLife()
    {
        Character ch = new Character();
        ch.Character();
        System.out.println("Welcome to your cabin, " + ch.getName());
        System.out.println("You have begun with stats - would you like to see them? (y/n)");
        Scanner s = new Scanner(System.in);
        String ans = s.nextLine();
        if (ans.equals("y") || ans.equals("Y"))
        {
            printInitStats(ch);
        }
        else if (!(ans.equals("n") || ans.equals("N")))
        {
            System.out.println("I am sorry, I do not understand your" +
                    "answer.");
            buildLife();
        }
        Home home = new Home();
        Quarry quarry = new Quarry();
        Woods woods = new Woods();
        River river = new River();
        Town town = new Town();
        homeChoices(ch, home, quarry, woods, river, town);
    }

    /**
     * Print the character's statistics.
     * This will be the first time they are shown,
     * where the skills are all randomly generated
     * but the stamina begins at 100 and all
     * of the materials at 0.
     * @param ch
     */
    public static void printInitStats(Character ch)
    {
        System.out.println("Fire starting skill - " + ch.getFireSkill());
        System.out.println("Wood cutter skill - " + ch.getWoodSkill());
        System.out.println("Fishing skill - " + ch.getFishingSkill());
        System.out.println("Building skill - " + ch.getBuildingSkill());

        System.out.println("Your stamina begins at 100, your" +
                " materials begin at 0. Good luck. ");
    }

    /**
     * Set the choices for the character's home,
     * create their woods, river, quarry, and town,
     * and then see where they decide to go.
     * They can go to different places depending on if
     * they have unlocked the areas or not.
     * They can also sleep, stoke the fire, or cook,
     * as well as see inventory. And when they're
     * done, they are able to exit the game if they
     * so desire.
     * @param ch
     */
    public static void homeChoices(Character ch, Home home,
                                   Quarry quarry, Woods woods, River river, Town town)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("What would you like to do, " + ch.getName() + "?");
        System.out.println("Explore (e), sleep (b), stoke the fire (s), cook (c), or see inventory (i) (x to exit)");
        String ans = s.nextLine();

        //TODO add eat as an option (should make it option in the field?)
        if (ans.equals("e"))
        {
            System.out.println("Where would you like to explore? ");
            home.setFireGoing(false);
            String str = "Press w for woods";
            if (river.isUnlocked())
            {
                str += ", r for river";
                //System.out.print(", r for river");
            }
            if (quarry.isUnlocked())
            {
                str += ", q for quarry";
                //System.out.print(", q for quarry");
            }
            if (town.isUnlocked())
            {
                str += ", t for town";
                //System.out.print(", t for town");
            }
            System.out.println(str);
            String exp = s.nextLine();

            if (exp.equals("w"))
            {
                System.out.println("You have entered the woods, it is dark and eerie.");
                exploreWoods(ch, river, quarry, town, home, woods);
            }
            else if (exp.equals("q"))
            {
                System.out.println("You have entered the quarry, every step you take echoes.");
                exploreQuarry(ch, river, quarry, town, home, woods);
            }
            else if (exp.equals("r"))
            {
                System.out.println("You have entered the river, the rushing waves spray chilly water.");
                exploreRiver(ch, river, quarry, town, home, woods);
            }
            else if (exp.equals("t"))
            {
                System.out.println("You have entered the town, the bustling whispers feel aimed at the new stranger.");
                exploreTown(ch, river, quarry, town, home, woods);
            }
        }
        else if (ans.equals("b"))
        {
            ch.setStamina(100-ch.getStamina());
            home.setFireGoing(false);
            System.out.println("You had a restful night's sleep, your stamina has replenished. " +
                            "However, your fire went out while you slept");
            homeChoices(ch, home, quarry, woods, river, town);
        }
        else if (ans.equals("s"))
        {
            if (ch.getWood() >= 1)
            {
                ch.setWood(-1);
                ch.setStamina(-1);
                System.out.println("You have successfully stoked the fire.");
                home.setFireGoing(true);
                homeChoices(ch, home, quarry, woods, river, town);
            }
            else
            {
                System.out.println("You have no wood - go gather some.");
                homeChoices(ch, home, quarry, woods, river, town);
            }

        }
        else if (ans.equals("c"))
        {
            if (ch.getRawFood() >= 1 && home.isFireGoing())
            {
                ch.setRawFood(-1);
                ch.setFood(1);
                ch.setStamina(-1);
                System.out.println("Would you like to eat your cooked food? (y/n)");
                String fo = s.nextLine();
                if (fo.equals("y"))
                {
                    ch.setStamina(10);
                    ch.setFood(-1);
                    System.out.println("That was delicious, and it gave you +10 stamina!");
                }
            }
            else if (ch.getRawFood() >= 1 && !home.isFireGoing())
            {
                System.out.println("You need to stoke the fire - would you like to?");
                String answer = s.nextLine();
                if (answer.equals("y"))
                {
                    if (ch.getWood() >= 1)
                    {
                        ch.setRawFood(-1);
                        ch.setWood(-1);
                        ch.setFood(1);
                        ch.setStamina(-2);
                    }
                    else
                    {
                        System.out.println("You have no wood, go gather some.");
                    }
                }
            }
            else
            {
                System.out.println("You have no raw food, go gather some.");
            }
            homeChoices(ch, home, quarry, woods, river, town);
        }
        else if (ans.equals("i"))
        {
            System.out.println("Inventory: ");
            System.out.println("Food: " + ch.getFood());
            System.out.println("Stone: " + ch.getRock());
            System.out.println("Wood: " + ch.getWood());
            System.out.println("Stamina: " + ch.getStamina());

            homeChoices(ch, home, quarry, woods, river, town);
        }
        else if (ans.equals("x"))
        {
            System.out.println("Goodbye.");
            exit();
        }
    }

    /**
     * Print the character's (ch) statistics,
     * including how much food, rock, and wood
     * they have, and include their stamina.
     * @param ch - the character
     */
    public static void printStats(Character ch)
    {
        System.out.println("Inventory: ");
        System.out.println("Food: " + ch.getFood());
        System.out.println("Stone: " + ch.getRock());
        System.out.println("Wood: " + ch.getWood());
        System.out.println("Stamina: " + ch.getStamina());
    }

    /**
     * Have the character (ch) explore the woods.
     * Along the way, the character has a chance
     * to discover new places, as well as finding
     * goods for their home. They can find the river,
     * the quarry, and then the town in that order.
     * In the woods, they can collect wood for their home.
     * From the woods, they can only find the river.
     * From the river, they'll be able to find the
     * quarry, and from the quarry, they'll be able
     * to find the town.
     * @param ch
     * @param river
     * @param quarry
     * @param town
     */
    public static void exploreWoods(Character ch, River river,
                                    Quarry quarry, Town town, Home home, Woods woods)
    {
        Scanner c = new Scanner(System.in);
        System.out.println("What would you like to do, " + ch.getName() + "?");
        System.out.println("w to wander, h for home, s for stats, x to exit.");
        String str = c.nextLine();

        if (str.equals("w"))
        {
            int findWood = (int)(Math.random() * 101);
            int encounter = (int)(Math.random() * 101);
            int findNew = (int)(Math.random() * 101);

            if (findWood <= ch.getWoodSkill())
            {
                wood(ch);
                exploreWoods(ch, river, quarry, town, home, woods);
            }
            else if (encounter <= 15)
            {
                wolf(ch);
            }
            else if (findNew <= 10)
            {
                if (!river.isUnlocked())
                {
                    Scanner sc = new Scanner(System.in);
                    river.setUnlocked(true);
                    System.out.println("You found the river! Would you like to explore? (y/n)");
                    String scs = sc.nextLine();
                    if (scs.equals("y") || scs.equals("Y"))
                    {
                        System.out.println("You have entered the river, the rushing waves spray chilly water.");
                        exploreRiver(ch, river, quarry, town, home, woods);
                    }
                    else if (scs.equals("n") || scs.equals(("N")))
                    {
                        exploreWoods(ch, river, quarry, town, home, woods);
                    }
                    else
                    {
                        System.out.println("I'm sorry young traveller, I do not understand your request.");
                    }
                }
            }
            exploreWoods(ch, river, quarry, town, home, woods);
        }
        else if (str.equals("h"))
        {
            homeChoices(ch, home, quarry, woods, river, town);
        }
        else if (str.equals("s"))
        {
            printStats(ch);
            exploreWoods(ch, river, quarry, town, home, woods);
        }
        else if (str.equals("x"))
        {
            System.out.println("Goodbye");
            exit();
        }
    }

    /**
     * This is the function that happens when a wolf is encountered
     * @param ch the character
     */
    public static void wolf(Character ch)
    {
        System.out.println("You have encountered a wolf!");
        System.out.println("Would you like to hide (h), run (r), or fight (f)?");
        Scanner scann = new Scanner(System.in);
        String scn = scann.nextLine();
        if (scn.equals("h"))
        {
            int hide = (int)(Math.random() * 101);
            System.out.println("You run and duck behind a bush, but is it effective?");
            if (hide <= 50)
            {
                System.out.println("The wolf walks right past you, never even noticing you.");
            }
            else
            {
                System.out.println("The wolf sees you and bites, leaving you drenched in your own blood.");
                int damage = (int) (Math.random() * 51);
                ch.setStamina(-damage);
            }
        }
        else if (scn.equals("r"))
        {
            int run = (int) (Math.random() * 101);
            System.out.println("You make a run for it, but does the creature notice you?");
            if (run <= 25)
            {
                System.out.println("You ran quietly but quickly, the wolf does not see you until it's too late.");
            }
            else
            {
                System.out.println("The wolf sees you and outruns you, tackling you to the ground.");
                int damage = (int) (Math.random() * 71);
                ch.setStamina(-damage);
            }
        }
        else if (scn.equals("f"))
        {
            int fight = (int) (Math.random() * 101);
            System.out.println("You decide there's only one option - to fight. You launch towards the beast.");
            if (fight <= 75)
            {
                System.out.println("Success! You poked the beast in its eye and it ran away, whimpering.");
            }
            else
            {
                System.out.println("But it was no use - the beast was too strong and bit your throat.");
                ch.setStamina(-ch.getStamina());
            }
        }
        else
        {
            System.out.println("You did not enter a valid request, " +
                    "you took too long to decide and the wolf attacks," +
                    "taking away 50 stamina.");
            ch.setStamina(-50);
        }
    }

    /**
     * This is the function that happens
     * when the character comes across wood that
     * can be chopped
     * @param ch the character
     */
    public static void wood(Character ch)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("You found wood! Would you like to chop it? (y/n)");
        String strw = s.nextLine();
        if (strw.equals("y"))
        {
            ch.setStamina(-2);
            ch.setWood(1);
        }
        else if (strw.equals("n"))
        {

        }
        else
        {
            System.out.println("You did not enter a valid command, young one.");
            wood(ch);
        }
    }

    /**
     * Explore the riverbed, teeming with
     * plentiful fish for eating, but also,
     * filled with ferocious alligators, waiting
     * to eat you.
     * @param ch - the character
     * @param river - the river
     * @param quarry - the quarry
     * @param town - the town
     * @param home - the home
     * @param woods - the woods
     */
    public static void exploreRiver(Character ch, River river,
                                    Quarry quarry, Town town, Home home, Woods woods)
    {
        Scanner c = new Scanner(System.in);
        System.out.println("What would you like to do, " + ch.getName() + "?");
        System.out.println("w to wander, h for home, s for stats, x to exit.");
        String str = c.nextLine();

        if (str.equals("w"))
        {
            int findFish = (int)(Math.random() * 101);
            int encounter = (int)(Math.random() * 101);
            int findNew = (int)(Math.random() * 101);

            if (findFish <= ch.getFishingSkill())
            {
                fish(ch);
                exploreRiver(ch, river, quarry, town, home, woods);
            }
            else if (encounter <= 15)
            {
                alligator(ch);
            }
            else if (findNew <= 10)
            {
                if (!quarry.isUnlocked())
                {
                    Scanner sc = new Scanner(System.in);
                    quarry.setUnlocked(true);
                    System.out.println("You found the quarry! Would you like to explore? (y/n)");
                    String scs = sc.nextLine();
                    if (scs.equals("y") || scs.equals("Y"))
                    {
                        System.out.println("You have entered the quarry, every step you take echoes.");
                        exploreQuarry(ch, river, quarry, town, home, woods);
                    }
                    else if (scs.equals("n") || scs.equals(("N")))
                    {
                        exploreRiver(ch, river, quarry, town, home, woods);
                    }
                    else
                    {
                        System.out.println("I'm sorry young traveller, I do not understand your request.");
                    }
                }
            }
            exploreRiver(ch, river, quarry, town, home, woods);
        }
        else if (str.equals("h"))
        {
            homeChoices(ch, home, quarry, woods, river, town);
        }
        else if (str.equals("s"))
        {
            printStats(ch);
            exploreRiver(ch, river, quarry, town, home, woods);
        }
        else if (str.equals("x"))
        {
            System.out.println("Goodbye");
            exit();
        }
    }

    /**
     * Create the function that occurs when a
     * character encounters an alligator in
     * the river.
     * @param ch the character
     */
    public static void alligator(Character ch)
    {
        System.out.println("An alligator has spotted you!");
        System.out.println("Would you like to go to land (l), swim away (s), or fight (f)?");
        Scanner scann = new Scanner(System.in);
        String scn = scann.nextLine();
        if (scn.equals("l"))
        {
            int land = (int)(Math.random() * 101);
            System.out.println("You run to land, but will the alligator follow you?");
            if (land <= 50)
            {
                System.out.println("The alligator sees you as too difficult, and swims away.");
            }
            else
            {
                System.out.println("The alligator follows you and grabs you by the leg.");
                int damage = (int) (Math.random() * 51);
                ch.setStamina(-damage);
            }
        }
        else if (scn.equals("s"))
        {
            int run = (int) (Math.random() * 101);
            System.out.println("You decide to swim away as fast as you can, but is it fast enough?");
            if (run <= 25)
            {
                System.out.println("You swim quickly enough that the alligator does not follow.");
            }
            else
            {
                System.out.println("You swim fast, but not nearly fast enough, and the alligator catches you.");
                int damage = (int) (Math.random() * 71);
                ch.setStamina(-damage);
            }
        }
        else if (scn.equals("f"))
        {
            int fight = (int) (Math.random() * 101);
            System.out.println("You decide there's only one option - to fight. You straddle the alligator from the back.");
            if (fight <= 75)
            {
                System.out.println("Success! You hold its gaping maw shut, and it cannot fight.");
            }
            else
            {
                System.out.println("Your bravery did you no good, as the alligator holds you under, drowning you.");
                ch.setStamina(-ch.getStamina());
            }
        }
        else
        {
            System.out.println("You did not enter a valid request, " +
                    "you took too long to decide and the alligator attacks," +
                    "taking away 50 stamina.");
            ch.setStamina(-50);
        }
    }

    /**
     * The character encounters a fish in the
     * river - will they catch it?
     * @param ch
     */
    public static void fish(Character ch)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("You found a fish! Would you like to catch it? (y/n)");
        String strw = s.nextLine();
        if (strw.equals("y"))
        {
            ch.setStamina(-3);
            ch.setRawFood(1);
        }
        else if (strw.equals("n"))
        {

        }
        else
        {
            System.out.println("You did not enter a valid command, young one.");
            fish(ch);
        }
    }

    /**
     * Allow the user to explore the quarry and
     * gather rocks and other materials.
     * What will happen when the find the next place to
     * explore? What will it be?
     * @param ch
     * @param river
     * @param quarry
     * @param town
     * @param home
     * @param woods
     */
    public static void exploreQuarry(Character ch, River river,
                                     Quarry quarry, Town town, Home home, Woods woods)
    {
        Scanner c = new Scanner(System.in);
        System.out.println("What would you like to do, " + ch.getName() + "?");
        System.out.println("w to wander, h for home, s for stats, x to exit.");
        String str = c.nextLine();

        if (str.equals("w"))
        {
            int findRocks = (int)(Math.random() * 101);
            int encounter = (int)(Math.random() * 101);
            int findNew = (int)(Math.random() * 101);

            if (findRocks <= ch.getMiningSkill())
            {
                rocks(ch);
                exploreQuarry(ch, river, quarry, town, home, woods);
            }
            else if (encounter <= 10)
            {
                fallingRocks(ch);
            }
            else if (findNew <= 2)
            {
                if (!quarry.isUnlocked())
                {
                    Scanner sc = new Scanner(System.in);
                    town.setUnlocked(true);
                    System.out.println("You found a small town! Would you like to explore? (y/n)");
                    String scs = sc.nextLine();
                    if (scs.equals("y") || scs.equals("Y"))
                    {
                        System.out.println("You have entered the town, the bustling whispers feel aimed at the new stranger.");
                        exploreTown(ch, river, quarry, town, home, woods);
                    }
                    else if (scs.equals("n") || scs.equals(("N")))
                    {
                        exploreQuarry(ch, river, quarry, town, home, woods);
                    }
                    else
                    {
                        System.out.println("I'm sorry young traveller, I do not understand your request.");
                    }
                }
            }
            exploreQuarry(ch, river, quarry, town, home, woods);
        }
        else if (str.equals("h"))
        {
            homeChoices(ch, home, quarry, woods, river, town);
        }
        else if (str.equals("s"))
        {
            printStats(ch);
            exploreQuarry(ch, river, quarry, town, home, woods);
        }
        else if (str.equals("x"))
        {
            System.out.println("Goodbye");
            exit();
        }
    }

    /**
     * What happens when the character encounters
     * falling rocks? Will they dodge left,
     * right, or stay exactly where they are?
     * What will the fates offer them?
     * @param ch
     */
    public static void fallingRocks(Character ch)
    {
        System.out.println("You hear a distant rumble, meaning only one thing - rocks are falling.");
        System.out.println("Would you like to go to left (l), go right (r), or stay where you are (s)?");
        Scanner scann = new Scanner(System.in);
        String scn = scann.nextLine();
        if (scn.equals("l"))
        {
            int left = (int)(Math.random() * 101);
            System.out.println("You run to your left, but will it save you?");
            if (left <= 35)
            {
                System.out.println("The boulder flies past you on your right - you're safe... for now");
            }
            else
            {
                System.out.println("The boulder comes down your path and pieces of debris hit you.");
                int damage = (int) (Math.random() * 51);
                ch.setStamina(-damage);
            }
        }
        else if (scn.equals("r"))
        {
            int right = (int) (Math.random() * 101);
            System.out.println("You decide to go to your right, but where will the boulder go?");
            if (right <= 35)
            {
                System.out.println("As you dive to your right, boulder and debris fly to your left. You're safe.");
            }
            else
            {
                System.out.println("The boulder hurdles towards you, pieces of it hitting you.");
                int damage = (int) (Math.random() * 51);
                ch.setStamina(-damage);
            }
        }
        else if (scn.equals("s"))
        {
            int stay = (int) (Math.random() * 101);
            System.out.println("You judge that the rocks will go around you, so you stay in place.");
            if (stay <= 75)
            {
                System.out.println("Your calculations were correct, the boulder avoids you.");
            }
            else
            {
                System.out.println("You're bad at math and the boulder hits you head on.");
                ch.setStamina(-ch.getStamina());
            }
        }
        else
        {
            System.out.println("You did not enter a valid request, " +
                    "you took too long to decide and the alligator attacks," +
                    "taking away 50 stamina.");
            ch.setStamina(-50);
        }
    }

    /**
     * Have the character collect rocks
     * once they come upon them.
     * @param ch - the character
     */
    public static void rocks(Character ch)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("You found minerals! Would you like to mine them? (y/n)");
        String strw = s.nextLine();
        if (strw.equals("y"))
        {
            ch.setStamina(-5);
            ch.setRock(1);
        }
        else if (strw.equals("n"))
        {

        }
        else
        {
            System.out.println("You did not enter a valid command, young one.");
            rocks(ch);
        }
    }

    /**
     * Explore the most difficult to find area, the town.
     * Here, you will encounter all sorts of new things,
     * such as trading, and people who you can talk to,
     * and maybe eventually woo. Should you woo someone,
     * you will need to visit the carpenter to build you a
     * bigger house which will cost
     *      100 wood
     *      100 stone
     *      50 food
     * @param ch
     * @param river
     * @param quarry
     * @param town
     * @param home
     * @param woods
     */
    public static void exploreTown(Character ch, River river,
                                   Quarry quarry, Town town, Home home, Woods woods)
    {

        Scanner c = new Scanner(System.in);
        System.out.println("What would you like to do, " + ch.getName() + "?");
        //TODO finish
        System.out.println("w to wander, h for home, s for stats, x to exit.");
        String str = c.nextLine();

        if (str.equals("w"))
        {
            // Here we will be able to find the following:
                // Shops (trading)
                // Merchants can be evil and steal stuff
                // People (wooing)
                // People can also be evil and be murderers
                // Carpenter (should someone be wooed)
            int findSeller = (int)(Math.random() * 101);
            int findPerson = (int)(Math.random() * 101);
            int findCarpenter = (int)(Math.random() * 101);

            if (findSeller >= 75)
            {
                Merchants merchant = new Merchants();
                if (merchant.getGoodness() >= 4)
                {
                    foundMerchant(ch, river, quarry, town, home, woods, merchant);
                }
                else
                {
                    foundBadMerchant(ch, river, quarry, town, home, woods, merchant);
                }

            }
        }
        else if (str.equals("h"))
        {
            homeChoices(ch, home, quarry, woods, river, town);
        }
        else if (str.equals("s"))
        {
            printStats(ch);
            exploreQuarry(ch, river, quarry, town, home, woods);
        }
        else if (str.equals("x"))
        {
            System.out.println("Goodbye");
            exit();
        }
    }

    /**
     * This is the function that will be called
     * upon the discovery of a merchant. If a merchant
     * is found, they will be given the option to barter with them,
     * and then following that, if they say yes, they will
     * be given an option to buy or sell. Then, they will have
     * the opportunity to do so for a certain price.
     * @param ch
     * @param river
     * @param quarry
     * @param town
     * @param home
     * @param woods
     * @param merchant
     */
    public static void foundMerchant(Character ch, River river, Quarry quarry,
                                     Town town, Home home, Woods woods, Merchants merchant)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("You found a merchant! Would you like to buy or sell? (y/n)");
        String str1 = s.nextLine();
        if (str1.equals("y") || str1.equals("Y"))
        {
            System.out.println(merchant.getName() + " " +
                    "says hello.");
            Scanner sc = new Scanner(System.in);
            System.out.println("You inspect the merchant warily. Would you " +
                    "like to buy or sell? (b/s)");
            String str2 = sc.nextLine();
            if (str2.equals("b") || str2.equals("B"))
            {
                Scanner sca = new Scanner(System.in);
                System.out.println("You decide to buy something. Would you like to buy" +
                        " rocks(r), raw food (f), cooked food (c), or wood(w)? (e to escape)");
                String str3 = sca.nextLine();

                if (str3.equals("r") || str3.equals("R"))
                {
                    System.out.println(merchant.getName() + "'s price for rocks is " +
                            merchant.getGreedRock() + " items per rock.");
                    int price = merchant.getGreedRock();
                    Scanner scan = new Scanner(System.in);
                    System.out.println("What would you like to trade for that? wood(w), raw food (r)," +
                            " cooked food (c)?");
                    String stri = scan.nextLine();
                    if (stri.equals("w") || stri.equals("W"))
                    {
                        ch.setWood((-1 * price));
                        ch.setRock(1);
                        foundMerchant(ch, river, quarry, town, home, woods, merchant);
                    }
                    else if (stri.equals("r") || stri.equals("R"))
                    {
                        ch.setRawFood((-1 * price));
                        ch.setRock(1);
                        foundMerchant(ch, river, quarry, town, home, woods, merchant);
                    }
                    else if (stri.equals("c") || stri.equals("C"))
                    {
                        ch.setFood((-1 * price));
                        ch.setRock(1);
                        foundMerchant(ch, river, quarry, town, home, woods, merchant);
                    }
                    else
                    {
                        System.out.println("I'm sorry, young one, I do not know what you mean.");
                        foundMerchant(ch, river, quarry, town, home, woods, merchant);
                    }
                }
                else if (str3.equals("f") || str3.equals("F"))
                {
                    System.out.println(merchant.getName() + "'s price for raw food is " +
                            merchant.getGreedFood() + " items per raw fish.");
                    System.out.println("What would you like to trade for that? wood(w), rocks(r)?");
                    int price = merchant.getGreedFood();
                    Scanner scan = new Scanner(System.in);
                    String stri = scan.nextLine();
                    if (stri.equals("w") || stri.equals("W"))
                    {
                        ch.setWood((-1 * price));
                        ch.setRawFood(1);
                        foundMerchant(ch, river, quarry, town, home, woods, merchant);
                    }
                    else if (stri.equals("r") || stri.equals("R"))
                    {
                        ch.setRock((-1 * price));
                        ch.setRawFood(1);
                        foundMerchant(ch, river, quarry, town, home, woods, merchant);
                    }
                    else
                    {
                        System.out.println("I'm sorry, young one, I do not know what you mean.");
                        foundMerchant(ch, river, quarry, town, home, woods, merchant);
                    }
                }
                else if (str3.equals("c") || str3.equals("C"))
                {
                    System.out.println(merchant.getName() + "'s price for cooked food is " +
                            merchant.getGreedFood() + " items per cooked fish.");
                    System.out.println("What would you like to trade for that? wood(w), rocks(r)?");
                    int price = merchant.getGreedFood();
                    Scanner scan = new Scanner(System.in);
                    String stri = scan.nextLine();
                    if (stri.equals("w") || stri.equals("W"))
                    {
                        ch.setWood((-1 * price));
                        ch.setFood(1);
                        foundMerchant(ch, river, quarry, town, home, woods, merchant);
                    }
                    else if (stri.equals("r") || stri.equals("R"))
                    {
                        ch.setRock((-1 * price));
                        ch.setFood(1);
                        foundMerchant(ch, river, quarry, town, home, woods, merchant);
                    }
                    else
                    {
                        System.out.println("I'm sorry, young one, I do not know what you mean.");
                        foundMerchant(ch, river, quarry, town, home, woods, merchant);
                    }
                }
                else if (str3.equals("w") || str3.equals("W"))
                {
                    System.out.println(merchant.getName() + "'s price for wood is " +
                            merchant.getGreedWood() + " items per wood.");
                    System.out.println("What would you like to trade for that? raw food(f), cooked food(c)" +
                            ", rocks(r)?");
                    int price = merchant.getGreedWood();
                    Scanner scan = new Scanner(System.in);
                    String stri = scan.nextLine();
                    if (stri.equals("c") || stri.equals("C"))
                    {
                        ch.setFood((-1 * price));
                        ch.setFood(1);
                        foundMerchant(ch, river, quarry, town, home, woods, merchant);
                    }
                    else if (stri.equals("f") || stri.equals("F"))
                    {
                        ch.setRawFood((-1 * price));
                        ch.setFood(1);
                        foundMerchant(ch, river, quarry, town, home, woods, merchant);
                    }
                    else if (stri.equals("r") || stri.equals("R"))
                    {
                        ch.setRock((-1 * price));
                        ch.setFood(1);
                        foundMerchant(ch, river, quarry, town, home, woods, merchant);
                    }
                    else
                    {
                        System.out.println("I'm sorry, young one, I do not know what you mean.");
                        foundMerchant(ch, river, quarry, town, home, woods, merchant);
                    }
                }
                else if (str3.equals("e") || str3.equals("E"))
                {
                    System.out.println("The merchant thanks you for your time.");
                }
                else
                {
                    System.out.println("Deepest apologies, young one, " + merchant.getName() +
                            " couldn't understand your request.");
                    foundMerchant(ch, river, quarry, town, home, woods, merchant);
                }
            }
            else if (str2.equals("s") || str2.equals("S"))
            {
                Scanner sca = new Scanner(System.in);
                System.out.println("You choose to sell your goods. What would you like" +
                        " to sell?  rocks(r), raw food (f), cooked food (c), or wood(w)?" +
                        " (e to escape)");
                String str3 = sca.nextLine();

                if (str3.equals("r") || str3.equals("R"))
                {
                    System.out.println("You choose to offer rocks. " + merchant.getName() + " will offer" +
                            "you one item for " + merchant.getGreedRock() + " rocks.");
                    int price = merchant.getGreedRock();
                    Scanner scan = new Scanner(System.in);
                    System.out.println("What would you like to trade for that? wood(w), raw food (r)," +
                            " cooked food (c)?");
                    String stri = scan.nextLine();
                    if (stri.equals("w") || stri.equals("W"))
                    {
                        ch.setWood(1);
                        ch.setRock((-1 * price));
                        foundMerchant(ch, river, quarry, town, home, woods, merchant);
                    }
                    else if (stri.equals("r") || stri.equals("R"))
                    {
                        ch.setRawFood(1);
                        ch.setRock((-1 * price));
                        foundMerchant(ch, river, quarry, town, home, woods, merchant);
                    }
                    else if (stri.equals("c") || stri.equals("C"))
                    {
                        ch.setFood(1);
                        ch.setRock((-1 * price));
                        foundMerchant(ch, river, quarry, town, home, woods, merchant);
                    }
                    else
                    {
                        System.out.println("I'm sorry, young one, I do not know what you mean.");
                        foundMerchant(ch, river, quarry, town, home, woods, merchant);
                    }
                }
                else if (str3.equals("f") || str3.equals("F"))
                {
                    System.out.println("You choose to offer raw food. " + merchant.getName() + " will offer" +
                            "you one item for " + merchant.getGreedFood() + " raw fish.");
                    System.out.println("What would you like to trade for that? wood(w), rocks(r)?");
                    int price = merchant.getGreedFood();
                    Scanner scan = new Scanner(System.in);
                    String stri = scan.nextLine();
                    if (stri.equals("w") || stri.equals("W"))
                    {
                        ch.setWood(1);
                        ch.setRawFood((-1 * price));
                        foundMerchant(ch, river, quarry, town, home, woods, merchant);
                    }
                    else if (stri.equals("r") || stri.equals("R"))
                    {
                        ch.setRock(1);
                        ch.setRawFood((-1 * price));
                        foundMerchant(ch, river, quarry, town, home, woods, merchant);
                    }
                    else
                    {
                        System.out.println("I'm sorry, young one, I do not know what you mean.");
                        foundMerchant(ch, river, quarry, town, home, woods, merchant);
                    }
                }
                else if (str3.equals("c") || str3.equals("C"))
                {
                    System.out.println("You choose to offer cooked food. " + merchant.getName() + " will offer" +
                            "you one item for " + merchant.getGreedFood() + " cooked fish.");
                    System.out.println("What would you like to trade for that? wood(w), rocks(r)?");
                    int price = merchant.getGreedFood();
                    Scanner scan = new Scanner(System.in);
                    String stri = scan.nextLine();
                    if (stri.equals("w") || stri.equals("W"))
                    {
                        ch.setWood(1);
                        ch.setFood((-1 * price));
                        foundMerchant(ch, river, quarry, town, home, woods, merchant);
                    }
                    else if (stri.equals("r") || stri.equals("R"))
                    {
                        ch.setRock(1);
                        ch.setFood((-1 * price));
                        foundMerchant(ch, river, quarry, town, home, woods, merchant);
                    }
                    else
                    {
                        System.out.println("I'm sorry, young one, I do not know what you mean.");
                        foundMerchant(ch, river, quarry, town, home, woods, merchant);
                    }
                }
                else if (str3.equals("w") || str3.equals("W"))
                {
                    System.out.println(merchant.getName() + "'s price for wood is " +
                            merchant.getGreedWood() + " items per wood.");
                    System.out.println("What would you like to trade for that? raw food(f), cooked food(c)" +
                            ", rocks(r)?");
                    int price = merchant.getGreedWood();
                    Scanner scan = new Scanner(System.in);
                    String stri = scan.nextLine();
                    if (stri.equals("c") || stri.equals("C"))
                    {
                        ch.setFood(1);
                        ch.setFood((-1 * price));
                        foundMerchant(ch, river, quarry, town, home, woods, merchant);
                    }
                    else if (stri.equals("f") || stri.equals("F"))
                    {
                        ch.setRawFood(1);
                        ch.setFood((-1 * price));
                        foundMerchant(ch, river, quarry, town, home, woods, merchant);
                    }
                    else if (stri.equals("r") || stri.equals("R"))
                    {
                        ch.setRock(1);
                        ch.setFood((-1 * price));
                        foundMerchant(ch, river, quarry, town, home, woods, merchant);
                    }
                    else
                    {
                        System.out.println("I'm sorry, young one, I do not know what you mean.");
                        foundMerchant(ch, river, quarry, town, home, woods, merchant);
                    }
                }
                else if (str3.equals("e") || str3.equals("E"))
                {
                    System.out.println("The merchant thanks you for your time.");
                }
                else
                {
                    System.out.println("Deepest apologies, young one, " + merchant.getName() +
                            " couldn't understand your request.");
                    foundMerchant(ch, river, quarry, town, home, woods, merchant);
                }
            }
            else
            {
                System.out.println("Deepest apologies, young one, " + merchant.getName() +
                        " couldn't understand your request.");
                foundMerchant(ch, river, quarry, town, home, woods, merchant);
            }
        }
        else if (str1.equals("n") || str1.equals("N"))
        {
            System.out.println("You eye the merchant down, and decide not to buy or sell." +
                    " Instead, you leave, saying your appreciations under your breath.");
        }
        else
        {
            System.out.println("I'm sorry, I didn't understand your request.");
            foundMerchant(ch, river, quarry, town, home, woods, merchant);
        }
    }

    /**
     * If the unfortunate player happens
     * to come across a merchant with
     * a goodness level lower than 4,
     * they may end up being robbed.
     * They have an opportunity to fight
     * back, however, they may face injury.
     * @param ch
     * @param river
     * @param quarry
     * @param town
     * @param home
     * @param woods
     * @param merchant
     */
    public static void foundBadMerchant(Character ch, River river, Quarry quarry,
                                        Town town, Home home, Woods woods, Merchants merchant)
    {
        System.out.println(merchant.getName() + " does not like the way you look, and tells you very" +
                "carefully, ");
        System.out.println("  \" Listen closely, I am going to take what I want. There is nothing you" +
                "can do about it. \" ");
        Scanner s = new Scanner(System.in);
        System.out.println("Do you choose to give " + merchant.getName() + " your goods (g) or fight (f)?");
        String st = s.nextLine();
        if (st.equals("g") || st.equals("G"))
        {
            int whatGood = (int)(Math.random() * 5);
            if (whatGood == 1)
            {
                int takeWood = (int) (Math.random() * ch.getWood());
                ch.setWood(-takeWood);
                System.out.println(merchant.getName() + " takes " + takeWood + " of your wood.");
            }
            else if (whatGood == 2)
            {
                int takeFish = (int) (Math.random() * ch.getFood());
                ch.setWood(-takeFish);
                System.out.println(merchant.getName() + " takes " + takeFish + " of your cooked fish.");
            }
            else if (whatGood == 3)
            {
                int takeFish = (int) (Math.random() * ch.getRawFood());
                ch.setWood(-takeFish);
                System.out.println(merchant.getName() + " takes " + takeFish + " of your raw fish.");
            }
            else if (whatGood == 4)
            {
                int takeRock = (int) (Math.random() * ch.getRock());
                ch.setWood(-takeRock);
                System.out.println(merchant.getName() + " takes " + takeRock + " of your rock.");
            }
            else
            {
                System.out.println("Upon further inspection, he decides to take it easy on you and lets you go.");
            }
        }
        else if (st.equals("f") || st.equals("F"))
        {
            System.out.println("You refuse to give up your hard-earned goods and decide to fight back.");
            Scanner sc = new Scanner(System.in);
            System.out.println("Your options are: run(r), punch the merchant(p), or knock their stuff down (k)");
            String str = sc.nextLine();
            if (str.equals("r") || str.equals("R"))
            {
                //TODO here is where you left off
            }
            else if (str.equals("p") || str.equals("P"))
            {

            }
            else if (str.equals("k") || str.equals("K"))
            {

            }
            else
            {
                System.out.println("You took too long to decide and the merchant hits you, taking away 50 stamina.");
                ch.setStamina(-50);
            }
        }
    }

    public static void exit()
    {
        System.exit(0);
    }
}