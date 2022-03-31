package com.scd.exercise.m11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code690 {

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee() {

        }

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, List<Integer>> idMap = new HashMap<>();
        Map<Integer, Employee> idEmployeeMap = new HashMap<>();
        for (Employee employee : employees) {
            List<Integer> ids = idMap.computeIfAbsent(employee.id, k -> new ArrayList<>());
            ids.addAll(employee.subordinates);
            idEmployeeMap.put(employee.id, employee);
        }
        Set<Integer> allIds = new HashSet<>();
        findId(idMap, id, allIds);
        int importNum = 0;
        for (int eId : allIds) {
            Employee employee = idEmployeeMap.get(eId);
            if (employee != null) {
                importNum = importNum + employee.importance;
            }
        }
        return importNum;
    }

    private void findId(Map<Integer, List<Integer>> idMap, int id, Set<Integer> allIds) {
        if (!allIds.contains(id)) {
            List<Integer> list = idMap.get(id);
            allIds.add(id);
            if (list != null && list.size() > 0) {
                for (Integer newId : list) {
                    findId(idMap, newId, allIds);
                }
            }
        }
    }

    public static void main(String[] args) {
        Code690 code690 = new Code690();
        Employee employee1 = new Employee(1, 10, Arrays.asList(2,3));
        Employee employee2 = new Employee(2, 5, Arrays.asList(1,4));
        List<Employee> list = new ArrayList<>();
        list.add(employee1);
        list.add(employee2);
        code690.getImportance(list, 1);
    }
}
