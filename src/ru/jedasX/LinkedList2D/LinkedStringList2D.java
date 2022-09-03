package ru.jedasX.LinkedList2D;

import java.util.List;

/**
 * The String two-dimensional LinkedList
 * It has three methods, that may simplify a work with the String two-dimensional LinkedList
 */
public class LinkedStringList2D extends LinkedList2D<String> {

    /**
     * adds string to element by index in list by index in two-dimensional LinkedList
     * @param listIndex index of list
     * @param elementIndex index of element in list by index in two-dimensional LinkedList
     * @param str String, which a user want to add To element
     */
    public void addToElement(int listIndex, int elementIndex, String str) {
        twoDList.get(listIndex).set(elementIndex, twoDList.get(listIndex).get(elementIndex) + str);
    }

    /**
     * adds string to element by index in last list in two-dimensional LinkedList
     * @param elementIndex index of element
     * @param str String, which a user want to add to element
     */
    public void addToElement(int elementIndex, String str) {
        List<String> list = twoDList.get(twoDList.size() - 1);
        list.set(elementIndex, list.get(elementIndex) + str);
    }

    /**
     * adds string to last element in last list in two-dimensional LinkedList
     * @param str String, which a user want to add to element
     */
    public void addToElement(String str) {

        if (twoDList.size() == 0) {
            addList();
        }
        List<String> list = twoDList.get(twoDList.size() - 1);
        if (twoDList.get(twoDList.size() - 1).size() != 0) {
            list.set(list.size() - 1, list.get(list.size() - 1) + str);
        } else {
            list.add(str);
        }
    }
}
