package huawei.hj068;

import java.util.*;

public class Main {
    /**
     * 成绩排序
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = Integer.parseInt(in.nextLine());
        int type = Integer.parseInt(in.nextLine());

        List<Score> scores = new ArrayList<>(count);
        for (int i=0; i<count; i++) {
            scores.add(new Score(in.nextLine()));
        }

        Collections.sort(scores, (o1, o2) -> {
            if (o1.score > o2.score) {
                return (type == 1) ? 1 : -1;
            }
            else if (o1.score < o2.score) {
                return (type == 1) ? -1 : 1;
            }
            else {
                return 0;
            }
        });

        for (Score s: scores) {
            System.out.println(s);
        }
    }

    static class Score {
        String name;
        int score;

        public Score(String line) {
            String[] s = line.split(" ");
            name = s[0];
            score = Integer.parseInt(s[1]);
        }

        @Override
        public String toString() {
            return String.format("%s %d", name, score);
        }
    }
}
