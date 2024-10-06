package test2.zad1.app;

import test2.zad1.models.TallestBoyAndGirlResult;
import test2.zad1.services.ChildService;
import test2.zad1.models.Child;
import test2.zad1.models.Mother;

import java.time.DayOfWeek;
import java.util.List;

public class ChildrenAndMotherRunner {

    public static void main(String[] args) {
        DataLoader dataLoader = new DataLoader();
        List<Mother> mothers = dataLoader.loadMothers("mamy.txt");
        List<Child> children = dataLoader.loadChildren("noworodki.txt", mothers);

        // a) Najwyższy chłopiec i dziewczynka
        TallestBoyAndGirlResult result = ChildService.findTallestBoyAndGirl(children);

        Child tallestBoy = result.getTallestBoy();
        Child tallestGirl = result.getTallestGirl();

        System.out.println("Tallest boy: " + tallestBoy.getName() + ", height: " + tallestBoy.getHeight() + " cm");
        System.out.println("Tallest girl: " + tallestGirl.getName() + ", height: " + tallestGirl.getHeight() + " cm");

        // b) Dzień tygodnia z największą liczbą urodzeń + ta liczba
        DayOfWeek info = ChildService.findDayOfWeekWithMostBirths(children);
        System.out.println("Most common day of birth: " + info);

        // c) Matki poniżej 25 lat z dziećmi powyżej 4000g
        List<Mother> youngMothers = ChildService.findYoungMothersWithHeavyChildren(mothers);
        System.out.println("Mothers under 25 with children over 4000g: ");
        for (Mother mother : youngMothers) {
            System.out.println(mother.getName());
        }

        // d) Dziewczynki, które odziedziczyły imię
        List<Child> girlsWithInheritedNames = ChildService.findGirlsWithInheritedNames(children);
        System.out.println("Girls with inherited names from their mothers:");
        for (Child child : girlsWithInheritedNames) {
            System.out.println("Name: " + child.getName() + ", Birth Date: " + child.getBirthDate());
        }

        // e) Matki blizniakow
        List<Mother> twinMothers = ChildService.findMothersOfTwins(mothers);
        System.out.println("Mothers of twins: " + twinMothers);
        for (Mother mother : twinMothers) {
            System.out.println(mother.getName());
        }
    }

}
