import java.util.Scanner;

/**
 * Lindsey Olson
 * WMC @ RIT
 * 2019
 * Version 1.0 5.27.19
 */

public class Character
{
    String name;
    int stamina;
    int fireSkill;
    int woodSkill;
    int fishingSkill;
    int buildingSkill;
    int charisma;
    int wood;
    int food;
    int rawFood;
    int rock;

    public void Character()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name ");
        this.name = sc.nextLine();

        fireSkill = (int)(Math.random() * 101);
        woodSkill = (int)(Math.random() * 101);
        fishingSkill = (int)(Math.random() * 101);
        buildingSkill = (int)(Math.random() * 101);
        charisma = (int)(Math.random() * 101);

        wood = 0;
        food = 0;
        rawFood = 0;
        rock = 0;
        stamina = 100;
    }

    public String getName()
    {
        return this.name;
    }

    public int getFireSkill()
    {
        return fireSkill;
    }

    public int getStamina()
    {
        return stamina;
    }

    public void setStamina(int x)
    {
        stamina += x;
    }

    public int getWoodSkill()
    {
        return woodSkill;
    }

    public int getFishingSkill()
    {
        return fishingSkill;
    }

    public int getBuildingSkill()
    {
        return buildingSkill;
    }

    public int getCharisma()
    {
        return charisma;
    }

    public int getWood()
    {
        return wood;
    }

    public void setWood(int i)
    {
        wood = wood + i;
    }

    public int getFood()
    {
        return food;
    }

    public int getRawFood() { return rawFood; }

    public void setFood(int i)
    {
        food += i;
    }

    public void setRawFood(int i)
    {
        rawFood += i;
    }

    public int getRock()
    {
        return rock;
    }

    public void setRock(int i)
    {
        rock = rock + i;
    }


}
