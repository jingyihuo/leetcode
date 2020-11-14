import java.util.Map;
import java.util.TreeMap;

public class NumberAtoms {

    public String countOfAtoms(String formula) {
        StringBuilder ans = new StringBuilder();
        int i = 0;
        for (String s : countAtom(formula, i).keySet()) {
            ans.append(s);
            int count = countAtom(formula, i).get(s);
            if (count > 1) {
                ans.append(count);
            }
        }
        return ans.toString();
    }

    private Map<String, Integer> countAtom(String formula, int i) {
        //System.out.println(i);
        Map<String, Integer> map = new TreeMap<>();
        while (i < formula.length()) {
            //System.out.println(i);
            if (formula.charAt(i) == '(') {
                Map<String, Integer> temp = countAtom(formula, ++i); // 这里一定不要写成i++；否则调用countAtom(formula, 2)
                int count = getCount(formula, i);
                for (String s : temp.keySet()) {
                    temp.put(s, temp.get(s) * count);
                }
            } else if (formula.charAt(i) == ')') {
                i++;
                return map;
            } else {
                //System.out.println(i);
                String name = getName(formula, i);
                //System.out.println("name: " + name);
                map.put(name, getCount(formula, i));
                i++;
            }
        }

        return map;
    }

    private String getName(String formula, int i) {
        StringBuilder name = new StringBuilder();
        while ((Character.isUpperCase(formula.charAt(i)) && name.length() == 0) || (name.length() != 0 && Character.isLowerCase(formula.charAt(i)))) {
            name.append(formula.charAt(i++));
        }
        //System.out.println(name.toString());
        return name.toString();
    }

    private int getCount(String formula, int i) {
        System.out.println(i);
        StringBuilder count = new StringBuilder();
        while (Character.isDigit(formula.charAt(i))) {
            count.append(formula.charAt(i++));
        }
        System.out.println("count: " + count.toString());
        return count.length() == 0 ? 1 : Integer.parseInt(count.toString());
    }

    public static void main(String[] args) {
        NumberAtoms p = new NumberAtoms();
        String res = p.countOfAtoms("Mg(OH)2");
        System.out.println("res: " + res);
    }
}
