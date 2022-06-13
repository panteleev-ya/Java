package Remuneration;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int departmentsCount = console.nextInt() + 1;
        long money = console.nextLong();
        long[] departmentsEfficiency = new long[departmentsCount];
        departmentsEfficiency[0] = -1;
        for (int i = 1; i < departmentsCount; i++) {
            departmentsEfficiency[i] = console.nextLong();
        }
        int[] departmentsParents = new int[departmentsCount];
        departmentsParents[0] = -1;
        for (int i = 1; i < departmentsCount; i++) {
            departmentsParents[i] = console.nextInt();
        }

        // Creating departments
        Department[] allDepartments = new Department[departmentsCount];
        allDepartments[0] = new Department(-1);
        for (int i = 1; i < departmentsCount; i++) {
            allDepartments[i] = new Department(departmentsEfficiency[i]);
        }

        // Looking for departments children
        for (int i = 1; i < departmentsCount; i++) {
            int parentDepartmentNumber = departmentsParents[i];
            allDepartments[parentDepartmentNumber].addSubDepartment(allDepartments[i]);
        }

        allDepartments[0].setMoney(money);

        // Get queue of 0-department's sub departments
        Queue<Department> getMoneyQueue = new LinkedList<>();
        getMoneyQueue.add(allDepartments[0]);
        List<Long> moneyGot = new ArrayList<>(departmentsCount);
        while (!getMoneyQueue.isEmpty()) {
            Department d = getMoneyQueue.poll();
            moneyGot.add(d.money);
            long subDepartmentsSummaryEfficiency = 0;
            for (Department sub : d.subDepartments) {
                subDepartmentsSummaryEfficiency += sub.efficiency;
            }
            long moneyLeft = d.money;
            for (Department sub : d.subDepartments) {
                long moneyRequired = Math.round((d.money * ((double)sub.efficiency / subDepartmentsSummaryEfficiency)));
                sub.setMoney(Math.min(moneyLeft, moneyRequired));
                moneyLeft -= moneyRequired;
            }
            getMoneyQueue.addAll(d.subDepartments);
        }

        for (int i = 1; i < moneyGot.size(); i++) {
            System.out.print(moneyGot.get(i) + " ");
        }
    }

    private static class Department {
        public List<Department> subDepartments;
        public long efficiency;
        public long money;
        public Department(long efficiency) {
            this();
            this.efficiency = efficiency;
        }
        public Department() {
            this.subDepartments = new ArrayList<>();
        }
        public void addSubDepartment(Department subDepartment) {
            subDepartments.add(subDepartment);
        }
        public void setMoney(long money) {
            this.money = money;
        }
    }
}

//5 15
//3 4 1 2 5
//0 0 1 1 2