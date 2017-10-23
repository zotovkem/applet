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
        List<Word> words = detectAllWords(crossword, "home", "same" );
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
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[0].length; j++) {
                    if (resWord.endX == -1 && resWord.endY == -1) {
                        if (crossword[i][j] == (int) arrWord[0] && resWord.startY < 0 && resWord.startX < 0) {//найдена буква
                            if (verifyWord.contains("" + j + i)) {
                                continue; // смотрим в мапе, варианты не законченный слов.
                            }
                            resWord.setStartPoint(j, i);
                            //определяем направление
                            for (int routeI = -1; routeI < 2; routeI++) {
                                for (int routeJ = -1; routeJ < 2; routeJ++) {
                                    if (j + routeJ < crossword[0].length && i + routeI < crossword.length && j + routeJ >= 0 && i + routeI >= 0) {
                                        if (arrWord[1] == crossword[i + routeI][j + routeJ]) {
                                            int wordI = i + routeI, wordJ = j + routeJ;
                                            for (int k = 2; k < arrWord.length; k++) {
                                                wordI += routeI;
                                                wordJ += routeJ;
                                                if (wordJ < crossword[0].length   && wordI < crossword.length && wordI >= 0 && wordJ >= 0) {
                                                    if (arrWord[k] == crossword[wordI][wordJ]) {
                                                        if (k == arrWord.length-1) { // если последняя буква, запоминаем конечные координаты слова
                                                            resWord.setEndPoint(wordJ,wordI);
                                                            break;
                                                        }
                                                    }
                                                    else break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            // проверяем на заполнение конечных кординат
                            if (resWord.startY > -1 && resWord.startX > -1 && resWord.endY > -1 && resWord.endX > -1) {
                                resWords.add(resWord);
                            } else {
                                if (resWord.startY > -1 && resWord.startX > -1 && resWord.endY == -1 && resWord.endX == -1) {
                                    verifyWord.add("" + resWord.startX + resWord.startY);
                                    resWord.setStartPoint(-1, -1);
                                }
                            }
                        }
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
