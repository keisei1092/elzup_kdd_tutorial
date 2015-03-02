package env;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println("Yahello world!!");
        System.out.println("this is test program");


        String[] values = {"your", "en[BUG]vironment", "environment", "is", "i[BUG]s", "good"};
        List<String> list = new ArrayList<>(Arrays.asList(values));
        List<String> messageWords = new ArrayList<>();
        list.stream()
                .filter(e -> e.indexOf("[BUG]") == -1) // "[BUG]" が含まれない文字列のみ
                .forEach(e -> messageWords.add(e));

        System.out.println(String.join(" ", messageWords));
    }
}
