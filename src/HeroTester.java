import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HeroTester {

    private Hero hero1;
    private Hero hero2;

    public void setUp() {
        hero1 = new Hero("Karl Marx");
        hero2 = new Hero("Adam Smith");
    }

    public void tearDown() {
        hero1 = null;
        hero2 = null;
    }

    @Test
    public void TestConstructorName() {
        setUp();
        assertEquals("Ensure that your constructor has been implemented correctly!", hero1.getName(), "Andrew Tate");
        tearDown();
    }

    @Test
    public void TestConstructorHitPoints() {
        setUp();
        assertEquals("Ensure that your constructor has been implemented correctly!", hero1.getHitPoints(), 100);
        tearDown();
    }

    @Test
    public void TestAttack() {
        setUp();
        hero1.attack(hero2);
        assertEquals("Ensure that your attack method has been implemented correctly!", hero1.getHitPoints() == hero2.getHitPoints(), false );
        tearDown();
    }

    @Test
    public void TestFightToTheDeath() {
        setUp();
        hero1.fightUntilTheDeath(hero2);
        assertTrue("Ensure that your duelToTheDeath method has been implemented correctly!", hero1.getHitPoints() != hero2.getHitPoints());
        tearDown();
    }

    @Test
    public void TestFightToTheDeathHpZero() {
        setUp();
        hero1.fightUntilTheDeath(hero2);
        if (hero1.getHitPoints() < hero2.getHitPoints()) assertTrue("Ensure that your duelToTheDeath method has been implemented correctly!", hero1.getHitPoints() == 0);
        else assertTrue("Ensure that your duelToTheDeath method has been implemented correctly!", hero2.getHitPoints() == 0);
        tearDown();
    }

    @Test
    public void TestFightToTheDeathNTimes() {
        setUp();

        int numberOfFights = 100;

        String result = hero1.nFightsToTheDeath(hero2, numberOfFights);
        int indexOfFirstColon = result.indexOf(":");
        int indexOfFirstColonEnd = result.indexOf("wins", indexOfFirstColon);
        int indexOfSecondColon = result.indexOf(":", indexOfFirstColon+1);
        int indexOfSecondColonEnd = result.indexOf("wins", indexOfSecondColon);

        int winsHero1 = Integer.parseInt(result.substring(indexOfFirstColon+2, indexOfFirstColonEnd-1));
        int winsHero2 = Integer.parseInt(result.substring(indexOfSecondColon+2, indexOfSecondColonEnd-1));

        assertEquals("Ensure that your nFightsToTheDeath method has been implemented correctly!", numberOfFights, winsHero1+winsHero2);

        tearDown();
    }

    @Test
    public void TestToString() {
        setUp();
        String expected = "Hero{" +
                "name='" + hero1.getName() + '\'' +
                ", hitPoints=" + hero1.getHitPoints() +
                '}';
        assertEquals("Ensure that your toString method returns a String that is formatted like the document specifies!", expected, hero1.toString());
        tearDown();
    }

    @Test
    public void TestSenzuBean() {
        setUp();
        hero1.fightUntilTheDeath(hero2);
        hero1.fightUntilTheDeath(hero2);
        hero1.fightUntilTheDeath(hero2);
        tearDown();
    }

    @Test
    public void TestAllMethodsHaveBeenImplemented() {
        setUp();
        Method[] methods = hero1.getClass().getDeclaredMethods();
        assertEquals("Ensure that you have implemented all of the methods that are included in the description!", 10,methods.length);
        tearDown();
    }

    @Test
    public void TestSenzuBeanMethodHasBeenImplemented() {
        setUp();
        Method[] methods = hero1.getClass().getDeclaredMethods();
        boolean containsSenzuBean = false;
        for (Method method: methods) if (method.getName().equals("senzuBean")) containsSenzuBean = true;
        assertTrue("Ensure that you have implemented the senzuBean method!", containsSenzuBean);
        tearDown();
    }

    @Test
    public void TestFightUntilTheDeathHelperHasBeenImplemented() {
        setUp();
        Method[] methods = hero1.getClass().getDeclaredMethods();
        boolean containsFightUntilTheDeathHelper = false;
        for (Method method: methods) if (method.getName().equals("fightUntilTheDeathHelper")) containsFightUntilTheDeathHelper = true;
        assertTrue("Ensure that you have implemented the fightUntilTheDeathHelper method!", containsFightUntilTheDeathHelper);
        tearDown();
    }

    @Test
    public void TestFightUntilTheDeathNTimesHelperHasBeenImplemented() {
        setUp();
        Method[] methods = hero1.getClass().getDeclaredMethods();
        boolean containsNFightsToTheDeathHelper = false;
        for (Method method: methods) if (method.getName().equals("nFightsToTheDeathHelper")) containsNFightsToTheDeathHelper = true;
        assertTrue("Ensure that you have implemented the nFightsUntilTheDeathHelper method!", containsNFightsToTheDeathHelper);
        tearDown();
    }

}
