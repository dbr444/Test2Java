package test2.zad1.app;

import test2.zad1.services.ChildService;
import test2.zad1.models.Child;
import test2.zad1.models.Mother;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class ChildrenAndMotherRunner {


    public static void main(String[] args) {
        DataLoader dataLoader = new DataLoader();
        List<Mother> mothers = new ArrayList<>();
        List<Child> children = new ArrayList<>();

        try {
            mothers = dataLoader.loadMothers("mamy.txt");
            children = dataLoader.loadChildren("noworodki.txt", mothers);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // a) Najwyższy chłopiec i dziewczynka
        List<Child> tallestChildren = ChildService.findTallestBoyAndGirl(children);
        if (tallestChildren.get(0) != null) {
            System.out.println("Tallest boy: " + tallestChildren.get(0).getName() +
                    ", height: " + tallestChildren.get(0).getHeight() + " cm");
        }
        if (tallestChildren.get(1) != null) {
            System.out.println("Tallest girl: " + tallestChildren.get(1).getName() +
                    ", height: " + tallestChildren.get(1).getHeight() + " cm");
        }

        // b) Dzień tygodnia z największą liczbą urodzeń + ta liczba
        DayOfWeek info = ChildService.findDayOfWeekWithMostBirths(children);
        System.out.println("Most common day of birth: " + info);


        // c) Matki poniżej 25 lat z dziećmi powyżej 4000g
        List<String> youngMothers = ChildService.findYoungMothersWithHeavyChildren(mothers);
        System.out.println("Mothers under 25 with children over 4000g: " + youngMothers);

        // d) Dziewczynki, które odziedziczyły imię
        List<String> inheritedNames = ChildService.findGirlsWithInheritedNames(children);
        System.out.println("Girls who inherited names from their mothers: " + inheritedNames);

        // e) Matki blizniakow
        List<String> twinMothers = ChildService.findMothersOfTwins(mothers);
        System.out.println("Mothers of twins: " + twinMothers);
    }

}
