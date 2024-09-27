package test2.zad1.services;

import test2.zad1.models.Child;
import test2.zad1.models.Mother;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class ChildService {
    public static List<Child> findTallestBoyAndGirl(List<Child> children) { //zakladamy, ze lista nie bedzie posiadala nullowych elementow, poniewaz pliki, ktore sa odczytywane, sa ustandaryzowane
        Child tallestBoy = null;
        Child tallestGirl = null;

        for (Child child : children) {
            if (child.getGender().equals("s")) {
                tallestBoy = child;
                break;
            }
        }

        for (Child child : children) {
            if (child.getGender().equals("c")) {
                tallestGirl = child;
                break;
            }

        }

        for (Child child : children) {
            if (child.getGender().equals("s")) {
                if (child.getHeight() > tallestBoy.getHeight()) {
                    tallestBoy = child;
                }
            } else if (child.getGender().equals("c")) {
                if (child.getHeight() > tallestGirl.getHeight()) {
                    tallestGirl = child;
                }
            }
        }

        return List.of(tallestBoy, tallestGirl);
    }

    public static DayOfWeek findDayOfWeekWithMostBirths(List<Child> children) {
        DayOfWeek[] dayOfWeeksArray = DayOfWeek.values();
        int[] dayBirthCounterArray = new int[dayOfWeeksArray.length];

        for (Child child : children) {
            DayOfWeek dayOfWeek = child.getBirthDate().getDayOfWeek();
            dayBirthCounterArray[dayOfWeek.ordinal()]++;
        }

        int mostBirthIndex = 0;
        for (int i = 1; i < dayBirthCounterArray.length; i++) {
            if (dayBirthCounterArray[i] > dayBirthCounterArray[mostBirthIndex]) {
                mostBirthIndex = i;
            }
        }

        return dayOfWeeksArray[mostBirthIndex];
    }

    public static List<String> findYoungMothersWithHeavyChildren(List<Mother> mothers) {
        List<String> youngMothersWithHeavyChildren = new ArrayList<>();

        for (Mother mother : mothers) {
            if (mother.getAge() < 25) {
                for (Child child : mother.getChildren()) {
                    if (child.getWeight() > 4000) {
                        youngMothersWithHeavyChildren.add(mother.getName());
                        break;
                    }
                }
            }
        }
        return youngMothersWithHeavyChildren;
    }

    public static List<String> findGirlsWithInheritedNames(List<Child> children) {
        List<String> girlsWithInheritedNames = new ArrayList<>();

        for (Child child : children) {
            if (child.getGender().equals("c") && child.getName().equals(child.getMother().getName())) {
                girlsWithInheritedNames.add(child.getName() + " - " + child.getBirthDate());
            }
        }

        return girlsWithInheritedNames;
    }

    public static List<String> findMothersOfTwins(List<Mother> mothers) {
        List<String> mothersOfTwins = new ArrayList<>();

        for (Mother mother : mothers) {
            if (mother.getChildren().size() > 1) {
                mothersOfTwins.add(mother.getName());
            }
        }

        return mothersOfTwins;
    }

}
