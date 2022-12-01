package huawei.hj031;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    /**
     * 单词倒排
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        String[] split = line.split("[^A-Za-z]");
        List<String> words = Arrays.asList(split);
        Collections.reverse(words);
        System.out.println(String.join(" ", words));
    }
}
