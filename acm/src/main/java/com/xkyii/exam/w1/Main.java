package com.xkyii.exam.w1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        // 获取输入,并转换为自定义Word列表
        String[] splits = line.split(" ");
        List<Word> words = new ArrayList<>(splits.length);
        for (int i = 0; i < splits.length; i++) {
            merge(words, splits[i]);
        }

        // 排序
        words.sort((w1, w2) -> {
            // 比较单词出现次数
            if (w1.count > w2.count) {
                return -1;
            }
            if (w1.count < w2.count) {
                return 1;
            }

            // 比较单词长度
            if (w1.length > w2.length) {
                return 1;
            }
            if (w1.length < w2.length) {
                return -1;
            }

            // 按单词字典升序
            return w1.original.compareTo(w2.original);
        });

        for (Word w: words) {
            for (int i = 0; i < w.count; i++) {
                System.out.print(w.reordered);
                System.out.print(" ");
            }
        }
    }

    private static void merge(List<Word> words, String s) {
        for (Word word: words) {
            // 如果已经在列表里,加一下数量
            if (word.original.equals(s)) {
                word.count++;
                return;
            }
        }
        // 否则添加为新的Word
        words.add(new Word(s));
    }

    static class Word {
        /**
         * 出现次数
         */
        int count;

        /**
         * 单词长度
         */
        int length;

        /**
         * 原始单词
         */
        String original;

        /**
         * 重排之后
         */
        String reordered;

        public Word(String s) {
            this.original = s;
            this.length = s.length();
            this.count = 1;
            // 重排
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            this.reordered = new String(chars);
        }
    }
}
