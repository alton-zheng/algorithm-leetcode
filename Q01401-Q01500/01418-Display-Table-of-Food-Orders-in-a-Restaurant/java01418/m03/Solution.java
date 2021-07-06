package java01418.m03;

import java.util.*;

/**
 * @Author: alton
 * @Date: Created in 7/6/21 8:47 AM
 * @Description:
 * 1418. Display Table of Food Orders in a Restaurant #179
 *
 * Given the array orders, which represents the orders that customers have done in a restaurant. More specifically orders[i]=[customerNamei,tableNumberi,foodItemi] where customerNamei is the name of the customer, tableNumberi is the table customer sit at, and foodItemi is the item customer orders.
 *
 * Return the restaurant's “display table”. The “display table” is a table whose row entries denote how many of each food item each table ordered. The first column is the table number and the remaining columns correspond to each food item in alphabetical order. The first row should be a header whose first column is “Table”, followed by the names of the food items. Note that the customer names are not part of the table. Additionally, the rows should be sorted in numerically increasing order.
 *
 *
 *
 * Example 1:
 *
 * Input: orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David","3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]]
 * Output: [["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
 * Explanation:
 * The displaying table looks like:
 * Table,Beef Burrito,Ceviche,Fried Chicken,Water
 * 3    ,0           ,2      ,1            ,0
 * 5    ,0           ,1      ,0            ,1
 * 10   ,1           ,0      ,0            ,0
 * For the table 3: David orders "Ceviche" and "Fried Chicken", and Rous orders "Ceviche".
 * For the table 5: Carla orders "Water" and "Ceviche".
 * For the table 10: Corina orders "Beef Burrito".
 * Example 2:
 *
 * Input: orders = [["James","12","Fried Chicken"],["Ratesh","12","Fried Chicken"],["Amadeus","12","Fried Chicken"],["Adam","1","Canadian Waffles"],["Brianna","1","Canadian Waffles"]]
 * Output: [["Table","Canadian Waffles","Fried Chicken"],["1","2","0"],["12","0","3"]]
 * Explanation:
 * For the table 1: Adam and Brianna order "Canadian Waffles".
 * For the table 12: James, Ratesh and Amadeus order "Fried Chicken".
 * Example 3:
 *
 * Input: orders = [["Laura","2","Bean Burrito"],["Jhon","2","Beef Burrito"],["Melissa","2","Soda"]]
 * Output: [["Table","Bean Burrito","Beef Burrito","Soda"],["2","1","1","1"]]
 *
 *
 * Constraints:
 *
 * 1 <= orders.length <= 5 * 10^4
 * orders[i].length == 3
 * 1 <= customerNamei.length, foodItemi.length <= 20
 * customerNamei and foodItemi consist of lowercase and uppercase English letters and the space character.
 * tableNumberi is a valid integer between 1 and 500.
 *
 * Time Complexity : O(t*f)
 * Space Complexity : O(N)
 * Runtime: 20 ms, faster than 95.63% of Java online submissions for Display Table of Food Orders in a Restaurant.
 * Memory Usage: 65.2 MB, less than 39.89% of Java online submissions for Display Table of Food Orders in a Restaurant.
 */
class Solution {
    class Help {
        String food;
        int cnt;
        Map<String, Integer> foodsCnt;

        public Help() {
            foodsCnt = new HashMap<>();
        }

        public void put(String food) {
            foodsCnt.put(food, get(food) + 1);
        }

        public int get(String food) {
            return foodsCnt.getOrDefault(food, 0);
        }

        public int size() {
            return foodsCnt.size();
        }

    }
    public List<List<String>> displayTable(List<List<String>> orders) {

        Set<String> nameSet = new HashSet<>();
        Help[] foodsCnt = new Help[500 + 1];

        for (int i = 1; i < 501; i++) {
            foodsCnt[i] = new Help();
        }

        for (List<String> order : orders) {
            nameSet.add(order.get(2));
            int id = Integer.parseInt(order.get(1));
            foodsCnt[id].put(order.get(2));
        }

        int n = nameSet.size();
        List<String> names = new ArrayList<>();
        for (String name : nameSet) {
            names.add(name);
        }
        Collections.sort(names);

        List<Integer> ids = new ArrayList<>();
        for (int i = 1; i < 501; i++) {
            if (foodsCnt[i].size() > 0) {
                ids.add(i);
            }
        }

        Collections.sort(ids);

        List<List<String>> table = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Table");
        for (String name : names) {
            header.add(name);
        }

        table.add(header);
        for (int i = 0; i < ids.size(); i++) {
            int id = ids.get(i);
            List<String> row = new ArrayList<>();
            row.add(Integer.toString(id));
            for (int j = 0; j < n; ++j) {
                row.add(Integer.toString(foodsCnt[id].get(names.get(j))));
            }
            table.add(row);
        }
        return table;
    }
}
