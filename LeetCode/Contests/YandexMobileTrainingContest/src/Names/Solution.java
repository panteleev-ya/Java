package Names;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        PersonsContainer a = new PersonsContainer(console.nextLine());
        PersonsContainer b = new PersonsContainer(console.nextLine());

        System.out.println(a.equals(b) ? "YES" : "NO");
    }

    private static class PersonsContainer {
        private final List<List<String>> data;
        public PersonsContainer(String container) {
            data = new ArrayList<>();
            String[] people = container.split("\\.")[0].split(", ");
            for (String person: people) {
                String[] info = person.split(" ");
                List<String> firstNameAndSecondName = new ArrayList<>();
                if (info[0].compareTo(info[1]) <= 0) {
                    firstNameAndSecondName.add(info[0]);
                    firstNameAndSecondName.add(info[1]);
                } else {
                    firstNameAndSecondName.add(info[1]);
                    firstNameAndSecondName.add(info[0]);
                }
                data.add(firstNameAndSecondName);
            }
            data.sort(new NamesComparator());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PersonsContainer that = (PersonsContainer) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }
    }

    private static class NamesComparator implements Comparator<List<String>> {

        @Override
        public int compare(List<String> o1, List<String> o2) {
            int firstNameComparison = o1.get(0).compareTo(o2.get(0));
            if (firstNameComparison != 0) {
                return firstNameComparison;
            } else {
                return o1.get(1).compareTo(o2.get(1));
            }
        }
    }
}
