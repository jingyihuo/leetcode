public class GetHappyString {
    private StringBuffer record = new StringBuffer("");
    private int n, k;
    private int curk;
    private String result = "";
    private String[] arr = {"a", "b", "c"};

    public String getHappyString(int n, int k) {
        this.n = n;
        this.k = k;

        doSelect1(-1, 0);

        return result;
    }


    public void doSelect1(int curIndex, int curN) {
        System.out.println("curIndex : " + curIndex + "  curN: " + curN + " curk: " + curk + " record: " + record);
        if (curk >= k) return; // 后续没必要再尝试了

        if (curN == n) { // 长度为n时
            curk++;
            if (curk == k) result = record.toString();
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (curIndex == i) continue; // 不取当前选过的
            record.append(arr[i]);
            doSelect1(i, curN + 1);
            record.deleteCharAt(record.length() - 1);
        }
    }

    public static void main(String[] args) {
        GetHappyString p = new GetHappyString();
        p.getHappyString(2, 3);

    }

}
