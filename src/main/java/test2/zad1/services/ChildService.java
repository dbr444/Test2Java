package test2.zad1.services;

import test2.zad1.models.Child;
import test2.zad1.models.Mother;
import test2.zad1.models.TallestBoyAndGirlResult;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChildService {

    private static Child getTallestBoy(List<Child> children) {
        Child tallestBoy = null;

        for (Child child : children) {
            if (child.getGender().equals("s")) {
                if (tallestBoy == null || child.getHeight() > tallestBoy.getHeight()) {
                    tallestBoy = child;
                }
            }
        }

        return tallestBoy;
    }

    private static Child getTallestGirl(List<Child> children) {
        Child tallestGirl = null;

        for (Child child : children) {
            if (child.getGender().equals("c")) {
                if (tallestGirl == null || child.getHeight() > tallestGirl.getHeight()) {
                    tallestGirl = child;
                }
            }
        }

        return tallestGirl;
    }
    public static TallestBoyAndGirlResult findTallestBoyAndGirl(List<Child> children) {
        Child tallestBoy = getTallestBoy(children);
        Child tallestGirl = getTallestGirl(children);
        return new TallestBoyAndGirlResult(tallestBoy, tallestGirl);
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

    public static List<Mother> findYoungMothersWithHeavyChildren(List<Mother> mothers) {
        List<Mother> youngMothersWithHeavyChildren = new ArrayList<>();

        for (Mother mother : mothers) {
            if (mother.getAge() < 25) {
                for (Child child : mother.getChildren()) {
                    if (child.getWeight() > 4000) {
                        youngMothersWithHeavyChildren.add(mother);
                        break;
                    }
                }
            }
        }
        return youngMothersWithHeavyChildren;
    }

    public static List<Child> findGirlsWithInheritedNames(List<Child> children) {
        List<Child> girlsWithInheritedNames = new ArrayList<>();

        for (Child child : children) {
            if (child.getGender().equals("c") && child.getName().equals(child.getMother().getName())) {
                girlsWithInheritedNames.add(child);
            }
        }

        return girlsWithInheritedNames;
    }

    public static List<Mother> findMothersOfTwins(List<Mother> mothers) {
        List<Mother> mothersOfTwins = new ArrayList<>();

        for (Mother mother : mothers) {
            List<Child> children = mother.getChildren();
            Set<LocalDate> localDateSet = new HashSet<>();
            for (Child child : mother.getChildren()) {
                localDateSet.add(child.getBirthDate());
            }
            if (children.size() != localDateSet.size()) {
                mothersOfTwins.add(mother);
            }
        }

        return mothersOfTwins;
    }

}
