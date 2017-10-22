package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'s', 'd', 'e', 'r', 'l', 'k'},
                {'a', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'u', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> words = detectAllWords(crossword, "same", "home");
        for (Word word :
                words) {
            System.out.println(word);
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        ArrayList<Word> resWords = new ArrayList<>();
        ArrayList<String> verifyWord = new ArrayList<>();
        for (String word :
                words) {
            verifyWord.clear();
            Word resWord = new Word(word);
            resWord.setStartPoint(-1, -1);
            resWord.setEndPoint(-1, -1);
            char[] arrWord = word.toCharArray();
            int countFindLiter = 0;
            for (int k = 0; k < arrWord.length; k++) {
                int ii = 0, jj = 0, stepLiterX = 1, stepLiterY = 1;
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 6; j++) {
                        int element = crossword[i][j];
                        if (resWord.endX == -1 && resWord.endY == -1) {
                            if (element == (int) arrWord[k]) {//найдена буква
                                if (resWord.startY < 0 && resWord.startX < 0) {//первая буква
                                    if (verifyWord.contains("" + j + i)) {
                                        continue; // смотрим в мапе, варианты не законченный слов.
                                    }
                                    resWord.setStartPoint(j, i);
                                    ii = i;
                                    jj = j;
                                    k = k >= 3 ? 3 : k + 1;
                                    countFindLiter++;
                                    i = j = 0;
                                } else {
                                    if ((i == ii - 1 && j == jj - 1) ||
                                            (i == ii + 1 && j == jj + 1) ||
                                            (i == ii - 1 && j == jj) ||
                                            (i == ii && j == jj - 1) ||
                                            (i == ii + 1 && j == jj) ||
                                            (i == ii && j == jj + 1) ||
                                            (i == ii + 1 && j == jj - 1) ||
                                            (i == ii - 1 && j == jj + 1)
                                            ) {

                                        if (countFindLiter == 1) { //Если найдена вторая буква, запоминаем направление слова
                                            stepLiterY = i - ii;
                                            stepLiterX = j - jj;
                                            ii = i;
                                            jj = j;
                                            i = j = 0;
                                            k = k >= 3 ? 3 : k + 1;
                                            countFindLiter++;
                                        } else if (i == ii + stepLiterY && j == jj + stepLiterX) {
                                            countFindLiter++;
                                            if (countFindLiter == arrWord.length) { // если последняя буква, запоминаем конечные координаты слова
                                                resWord.setEndPoint(j, i);
                                                break;
                                            }
                                            // последующие буквы по направлению слова
                                            ii = i;
                                            jj = j;
                                            k = k >= 3 ? 3 : k + 1;
                                            i = j = 0;
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
                if (resWord.startY > -1 && resWord.startX > -1 && resWord.endY > -1 && resWord.endX > -1 && k == arrWord.length - 1) {
                    resWords.add(resWord);
                } else {
                    if (resWord.startY > -1 && resWord.startX > -1 && resWord.endY == -1 && resWord.endX == -1 && k == arrWord.length - 1) {
                        verifyWord.add("" + resWord.startX + resWord.startY);
                        resWord.setStartPoint(-1, -1);
                        k = -1;
                        countFindLiter = 0;
                    }
                }
            }
        }
        return resWords;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
