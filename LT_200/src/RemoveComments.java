import java.util.ArrayList;
import java.util.List;

public class RemoveComments {
    public List<String> removeComments(String[] source) {
        List<String> ans = new ArrayList<>();

        boolean multiComment = false;
        boolean singleComment = false;

        for (String str : source) {
            StringBuilder sb = new StringBuilder();
            int single = str.indexOf("//");
            int multi = str.indexOf("/*");
            System.out.println("str: " + str);
            System.out.println("\tsingle: " + single + " multi: " + multi);
            if (!multiComment) {
                if (single == -1 && multi == -1) {
                    ans.add(str);
                } else if (single == -1) {
                    multiComment = true;
                    sb.append(str.substring(0, multi));
                } else if (multi == -1) {
                    ans.add(str.substring(0, single));
                } else {
                    if (single < multi) {
                        ans.add(str.substring(0, single));
                    } else {
                        multiComment = true;
                        sb.append(str.substring(0, multi));
                    }
                }
            }
            System.out.println("\tsb: " + sb.toString());
            int endComment = str.indexOf("*/");
            if (multiComment) {
                if ((multi != -1 && multi + 1 < endComment) || (multi == -1 && endComment != -1)) {
                    sb.append(str.substring(endComment + 2));
                    ans.add(sb.toString());
                    multiComment = false;
                }
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        RemoveComments p = new RemoveComments();
        String[] source = {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;",
                "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
        p.removeComments(source);
    }
}
