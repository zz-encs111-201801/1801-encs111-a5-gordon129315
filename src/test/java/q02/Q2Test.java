package q02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Knapsack Problem Test")
public class Q2Test {

    private Solution slt = new Solution();

    @Test
    public void test0() {
        int items[][] = {{23, 92}, {31, 57}, {29, 49}, {44, 68}, {53, 60}, {38, 43}, {63, 67},
                {85, 84}, {89, 87}, {82, 72}};
        int res = slt.solve(items, 165);
        assertEquals(309, res);
    }

    @Test
    public void test1() {
        int items[][] = {{12, 24}, {7, 13}, {11, 23}, {8, 15}, {9, 16}};
        int res = slt.solve(items, 26);
        assertEquals(51, res);
    }

    @Test
    public void test2() {
        int items[][] = {{56, 50}, {59, 50}, {80, 64}, {64, 46}, {75, 50}, {17, 5}};
        int res = slt.solve(items, 190);
        assertEquals(150, res);
    }

    @Test
    public void test3() {
        int items[][] = {{31, 70}, {10, 20}, {20, 39}, {19, 37}, {4, 7}, {3, 5}, {6, 10}};
        int res = slt.solve(items, 50);
        assertEquals(107, res);
    }

    @Test
    public void test4() {
        int items[][] = {{25, 350}, {35, 400}, {45, 450}, {5, 20}, {25, 70}, {3, 8}, {2, 5}, {2,
                5}};
        int res = slt.solve(items, 104);
        assertEquals(900, res);
    }

    @Test
    public void test5() {
        int items[][] = {{41, 442}, {50, 525}, {49, 511}, {59, 593}, {55, 546}, {57, 564}, {60,
                617}};
        int res = slt.solve(items, 170);
        assertEquals(1735, res);
    }

    @Test
    public void test6() {
        int items[][] = {{70, 135}, {73, 139}, {77, 149}, {80, 150}, {82, 156}, {87, 163}, {90,
                173}, {94, 184}, {98, 192}, {106, 201}, {110, 210}, {113, 214}, {115, 221}, {118,
                229}, {120, 240}};
        int res = slt.solve(items, 750);
        assertEquals(1458, res);
    }

    @Test
    public void test7() {
        int items[][] = {{382745, 825594}, {799601, 1677009}, {909247, 1676628}, {729069,
                1523970}, {467902, 943972}, {44328, 97426}, {34610, 69666}, {698150, 1296457},
                {823460, 1679693}, {903959, 1902996}, {853665, 1844992}, {551830, 1049289},
                {610856, 1252836}, {670702, 1319836}, {488960, 953277}, {951111, 2067538},
                {323046, 675367}, {446298, 853655}, {931161, 1826027}, {31385, 65731}, {496951,
                901489}, {264724, 577243}, {224916, 466257}, {169684, 369261}};
        int res = slt.solve(items, 6404180);
        assertEquals(13549094, res);
    }

    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    // test data from: https://people.sc.fsu.edu/~jburkardt/datasets/knapsack_01/knapsack_01.html
    private String urlPre = "https://people.sc.fsu.edu/~jburkardt/datasets/knapsack_01/p0";
    private String urlWPost = "_w.txt";
    private String urlPPost = "_p.txt";
    private String urlSPost = "_s.txt";
    private String urlCPost = "_c.txt";

    //    @Test
    public void generateTestCode() throws IOException {
        final int LEN = 8;
        BufferedReader reader;
        List<Bag> bags = new ArrayList<>();

        // allocate three data lists
        List<Integer> wList = new ArrayList<>();
        List<Integer> pList = new ArrayList<>();
        List<Integer> sList = new ArrayList<>();

        for (int i = 1; i <= LEN; i++) {
            String line;
            URL url;

            int capacity = 0;
            int maxProfit = 0;
            wList.clear();
            pList.clear();
            sList.clear();

            url = new URL(urlPre + i + urlWPost);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            while ((line = reader.readLine()) != null) {
                wList.add(Integer.parseInt(line.trim()));
            }

            url = new URL(urlPre + i + urlPPost);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            while ((line = reader.readLine()) != null) {
                pList.add(Integer.parseInt(line.trim()));
            }

            url = new URL(urlPre + i + urlSPost);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            while ((line = reader.readLine()) != null) {
                sList.add(Integer.parseInt(line.trim()));
            }

            url = new URL(urlPre + i + urlCPost);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            line = reader.readLine();
            if (line != null)
                capacity = Integer.parseInt(line.trim());
            else {
                System.err.println("capacity error");
                System.exit(-1);
            }

            if (!sList.isEmpty()) {
                maxProfit = 0;
                for (int m = 0; m < pList.size(); m++) {
                    if (sList.get(m) == 1)
                        maxProfit += pList.get(m);
                }
            } else {
                System.err.println("solution error");
                System.exit(-1);
            }

            Bag bag = new Bag(wList, pList, sList, capacity, maxProfit);
            bags.add(bag);
        }

        System.out.println(Bag.code(bags));
    }

    static class Bag {

        List<Integer[]> items;
        int capacity;
        int maxProfit;

        public Bag(List<Integer> wl, List<Integer> pl, List<Integer> sl, int cap, int mp) {
            this.capacity = cap;
            this.maxProfit = mp;

            if (wl.size() == pl.size() && pl.size() == sl.size()) {
                this.items = new ArrayList<>(wl.size());
                for (int i = 0; i < wl.size(); i++) {
                    Integer[] item = new Integer[2];
                    item[0] = wl.get(i);
                    item[1] = pl.get(i);
                    this.items.add(item);
                }
            } else {
                System.err.println("size not match");
                System.exit(-1);
            }
        }

        @Override
        public String toString() {
            StringBuilder stb = new StringBuilder();
            stb.append("{");
            for (int i = 0; i < items.size(); i++) {
                Integer[] item = items.get(i);
                stb.append("{")
                        .append(item[0]).append(", ").append(item[1])
                        .append("}");
                if (i != items.size() - 1)
                    stb.append(", ");
            }
            stb.append("}");
            return stb.toString();
        }

        static String code(List<Bag> bags) {
            int capPH = -1, expectedPH = -1;
            StringBuilder stb = new StringBuilder();
            for (int i = 0; i < bags.size(); i++) {
                stb.append("public void test");
                Bag b = bags.get(i);
                capPH = b.capacity;
                expectedPH = b.maxProfit;
                stb.append(i).append("() {\n");
                String line1 = "int items[][] = " + b.toString() + ";\n";
                String line2 = "int res = slt.solve(items, " + capPH + ");\n";
                String line3 = "assertEquals(" + expectedPH + ", res);\n";
                stb.append(line1).append(line2).append(line3);
                stb.append("}\n");
            }
            return stb.toString();
        }
    }
}
