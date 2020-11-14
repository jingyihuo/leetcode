import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    private EasyPrint ep = new EasyPrint();

    public List<String> fullJustify(String[] words, int maxWidth) {
        //
        List<String> res = new ArrayList<>();

        int numOfWds = words.length;
        int curLen = 0;     // 当前行的长度
        int curStart = 0;   // 当前行第一个单词在words里的位置

        for (int i = 0; i <= numOfWds; ++i) {

            // 第一个判断：是否此行还能加入单词 i
            // 不能的话开始处理 curStart 到 i - 1这些单词的对齐
            // 然后将 curStart 和 curLen 还原
            if (i == numOfWds || curLen + words[i].length() + i - curStart > maxWidth) {
                int spaceTotal = maxWidth - curLen;
                int spaceSlot = i - 1 - curStart;
                StringBuilder sb = new StringBuilder();
                if (spaceSlot == 0) {
                    // i == numOfWds已经没有单词可以加入，处理i-1也就是最后一个单词
                    sb.append(words[i - 1]);
                    addSpace(sb, spaceTotal);
                } else if (i == numOfWds) {
                    for (int j = curStart; j <= i - 1; ++j) {
                        sb.append(words[j]);
                        if (j != i - 1) {
                            addSpace(sb, 1);
                        } else {
                            addSpace(sb, spaceTotal - spaceSlot);
                        }
                    }
                } else {
                    int spaceEach = spaceTotal / spaceSlot;     // 5 / 3 = 1
                    int spaceExtra = spaceTotal % spaceSlot;    // 5 % 3 = 2
                    for (int j = curStart; j <= i - 1; ++j) {
                        // 最后一个单词后面不需要加空格
                        if (j != i - 1) {
                            sb.append(words[j]);
                            int count = spaceEach + (j < curStart + spaceExtra ? 1 : 0);
                            addSpace(sb, count);
                        } else {
                            sb.append(words[j]);
                        }
                    }
                }
                curLen = 0;
                curStart = i;
                res.add(sb.toString());
            }
            // 第二个判断是否可以加入单词：如果当前单词没超过总量，处理当前单词
            //      第一个判断如果没通过， 即当前行仍然可以加入单词：则在第二个判断里处理当前单词
            //      第一个判断如果通过， 则已完成换行，仍然在第二个判断里处理当前单词 i
            if (i < numOfWds) {
                curLen = curLen + words[i].length();
            }
        }
        ep.printList(res);
        return res;
    }

    private void addSpace(StringBuilder sb, int numOfSpaces) {
        for (int i = 0; i < numOfSpaces; ++i) {
            sb.append(" ");
        }
    }

    public static void main(String[] args) {
        TextJustification p = new TextJustification();
        String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};
        int maxWidth = 16;
        p.fullJustify(words, maxWidth);
    }
}
