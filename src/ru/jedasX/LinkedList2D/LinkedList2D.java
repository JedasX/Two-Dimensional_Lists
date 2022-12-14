package ru.jedasX.LinkedList2D;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * The two-dimensional LinkedList
 */
public class LinkedList2D<E>{

    List<LinkedList<E>> twoDList;

    public LinkedList2D() {
        twoDList = new LinkedList<>();
    }

    /**
     * @return count of Lists in two-dimensional LinkedList
     */
    public int size() {
        return twoDList.size();
    }

    /**
     * @param listIndex index of List
     * @return count of elements in List by index
     */
    public int listSize(int listIndex) {
        return twoDList.get(listIndex).size();
    }

    /**
     * @return is two-dimensional LinkedList empty
     */
    public boolean isEmpty() {
        return twoDList.size() == 0;
    }

    /**
     * @param index index of List
     * @return is List by index empty
     */
    public boolean isListEmpty(int index) {
        return twoDList.get(index).size() == 0;
    }

    /**
     * @param c two-dimensional collection
     * @return true if two-dimensional LinkedList contains of lists of c
     */
    public boolean containsAll(Collection<Collection<E>> c) {
        int count = 0;
        for (int i = 0; i < twoDList.size(); i ++) {
            if (twoDList.get(i) == c) {
                count ++;
            }
        }
        return count == c.size();
    }

    /**
     * @param c collection to compare with lists
     * @return does two-dimensional LinkedList has at least one list identical to c
     */
    public boolean containsList(Collection<E> c) {
        boolean ret = false;
        for (LinkedList<E> list : twoDList) {
            if (list == c) {
                ret = true;
                break;
            }
        }
        return ret;
    }

    /**
     * @param e E object to compare
     * @return does at least one list in two-dimensional LinkedList has at least one object equals to e
     */
    public boolean containsElement(E e) {
        boolean ret = false;
        for (int i = 0; i < twoDList.size(); i ++) {
            for (int j = 0; i < twoDList.get(i).size(); j ++) {
                if (twoDList.get(i).get(j) == e) {
                    ret = true;
                    break;
                }
            }
        }
        return ret;
    }

    /**
     * converts two-dimensional LinkedList to two-dimensional primitive array
     * the first d size will be equals two-dimensional LinkedList size,
     * the second d size will be equals max list size in two-dimensional LinkedList
     * @return two-dimensional LinkedList had converted to two-dimensional primitive array
     */
    public Object[][] toArray() {
        int maxSize = 0;
        for (int i = 0; i < twoDList.get(i).size(); i ++) {
            if (twoDList.get(i).size() > maxSize) {
                maxSize = twoDList.get(i).size();
            }
        }

        Object[][] arr = new Object[twoDList.size()][maxSize];
        for (int i = 0; i < twoDList.size(); i ++) {
            for (int j = 0; j < twoDList.get(i).size(); j ++) {
                arr[i][j] = twoDList.get(i).get(j);
            }
        }
        return arr;
    }

    /**
     * @param c collection to add in two-dimensional LinkedList;
     * @return always true
     */
    public boolean addAll(Collection<E> c) {
        twoDList.add((LinkedList<E>) c);
        return true;
    }

    /**
     * @param index indicating the insertion point
     * @param c collection to add in two-dimensional LinkedList
     * @return always true
     */
    public boolean addAll(int index, Collection<E> c) {
        twoDList.add(index, (LinkedList<E>) c);
        return true;
    }

    /**
     * @param index indicating the List where to add
     * @param c collection, whose elements will be added to list by index
     * @return always true
     */
    public boolean addAllElementsInList(int index, Collection<E> c) {
        for (int i = 0; i < c.size(); i ++) {
            twoDList.get(index).add(((LinkedList<E>) c).get(i));
        }
        return true;
    }

    /**
     * @param c collection, whose index a user want to get
     * @return index of c if two-dimensional LinkedList has list equals to c,
     * -1 if two-dimensional list hasn't list equals to c
     */
    public int indexOfList(Collection<E> c) {
        return twoDList.indexOf((LinkedList<E>) c);
    }

    /**
     * @param element E object, whose index a user want to get
     * @return primitive int[][] array if two-dimensional LinkedList has desired element at least in one list ,
     * the first number is index of list, that has desired element,
     * the second number is index of desired element in list by index equals to first number;
     * null if no one list in two-dimensional LinkedList has desired element
     */
    public int[] indexOfElement (E element) {
        for (int i = 0; i < twoDList.size(); i ++) {
            for (int j = 0; j < twoDList.get(i).size(); j ++) {
                if (twoDList.get(i).get(j) == element) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * remove all lists in two-dimensional LinkedList, which equals to c
     * @param c collection, which a user want to remove
     * @return true if two-dimensional LinkedList had at least one list equals to c, and it was removed,
     * false if two-dimensional LinkedList has no one collection equals to c
     */
    public boolean removeAllLists(Collection<E> c) {
        boolean ret = false;
        for (int i = 0; i < twoDList.size();) {
            if (twoDList.get(i) == c) {
                twoDList.remove(i);
                ret = true;
            } else {
                i ++;
            }
        }
        return ret;
    }

    /**
     * removes first list, that equals to c;
     * @param c collection to remove;
     * @return true if two-dimensional LinkedList had at least one list equals to c
     * false if two-dimensional LinkedList hasn't at least one list equals to c
     */
    public boolean removeList(Collection<E> c) {
        for (LinkedList<E> list : twoDList) {
            if (list == c) {
                twoDList.remove(c);
                return true;
            }
        }
        return false;
    }

    /**
     * removes all elements in all lists in two-dimensional LinkedList, which equals to at least one element in c
     * @param c collection, whose elements a user want to remove from two-dimensional LinkedList
     * @return true if two-dimensional LinkedList had at least one element equals to at least one element from c
     */
    public boolean removeAllElements(Collection<E> c) {
        boolean ret = false;
        for (int i = 0; i < twoDList.size();) {
            for (int j = 0; i < twoDList.get(i).size();) {
                for (int x = 0; x < c.size(); x ++) {
                    if (twoDList.get(i).get(j) == ((LinkedList<E>) c).get(x)) {
                        twoDList.get(i).remove(j);
                        ret = true;
                    } else {
                        j ++;
                    }
                }
            }
            i ++;
        }
        return ret;
    }

    /**
     * removes first element, that equals to e
     * @param e obj, which a user wants to remove
     * @return true if two-dimensional LinkedList had at least one element equals to e
     */
    public boolean removeElement(E e) {
        for (int i = 0; i < twoDList.size(); i ++) {
            for (int j = 0; j < twoDList.get(i).size(); j ++) {
                if (twoDList.get(i).get(j) == e) {
                    twoDList.get(i).remove(j);
                    return true;
                } else {
                    j ++;
                }
            }
        }
        return false;
    }

    /**
     * removes list by index
     * @param listIndex index of list which a user wants to remove
     */
    public void removeList(int listIndex) {
        twoDList.remove(listIndex);
    }

    /**
     * removes element by index in list by index
     * @param listIndex index of list
     * @param elementIndex index of element in list by list index, which a user wants to remove
     */
    public void removeElement(int listIndex, int elementIndex) {
        twoDList.get(listIndex).remove(elementIndex);
    }

    /**
     * clears list by index
     * @param listIndex index of list, which a user wants to clear
     */
    public void clearList(int listIndex) {
        twoDList.get(listIndex).clear();
    }

    /**
     * clears element by index in list by index
     * @param listIndex index of list
     * @param elementIndex index of element in list by list index, which a user wants to clear
     */
    public void clearElement(int listIndex, int elementIndex) {
        twoDList.get(listIndex).remove(elementIndex);
    }

    /**
     * adds list
     */
    public void addList() {
        twoDList.add(new LinkedList<>());
    }

    /**
     * @param index index of list, which a user want to get
     * @return list by index
     */
    public LinkedList<E> getList(int index) {
        return twoDList.get(index);
    }

    /**
     * adds element to list by listIndex
     * @param listIndex index of list, where a user wants to add
     * @param obj E obj to add
     */
    public void addElement(int listIndex, E obj) {
        twoDList.get(listIndex).add(obj);
    }

    /**
     * adds element to last list
     * @param obj E obj to add
     */
    public void addElement(E obj) {
        twoDList.get(twoDList.size() - 1).add(obj);
    }

    /**
     * @param listIndex index of list
     * @param elementIndex index of element, which a user want to get
     * @return element by index in list by index
     */
    public E getElement(int listIndex, int elementIndex) {
        return twoDList.get(listIndex).get(elementIndex);
    }

    /**
     * sets list to index in two-dimensional LinkedList
     * @param listIndex index of list, where a user wants to set
     * @param list list, which a user want to set
     */
    public void setList(int listIndex, LinkedList<E> list) {
        twoDList.set(listIndex, list);
    }

    /**
     * sets element to index of list by index in two-dimensional LinkedList
     * @param listIndex index of list
     * @param elementIndex index of element, where a user wants to set
     * @param e E obj to set
     */
    public void setElement(int listIndex, int elementIndex, E e) {
        twoDList.get(listIndex).set(elementIndex, e);
    }

    /**
     * @return String presentation of two-dimensional LinkedList
     */
    @Override
    public String toString() {
        return Arrays.toString(twoDList.toArray());
    }
}