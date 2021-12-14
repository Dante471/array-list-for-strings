package stringlist;

import exception.InvalidIndexException;
import exception.ItemNotFoundException;
import exception.NullParameterException;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private String[] stringList;

    public StringListImpl() {
        this.stringList = new String[1];
    }


    @Override
    public String add(String item) {
        if (stringList.length == 1 && stringList[0] == null) {
            stringList[0] = item;
        } else {
            stringList = Arrays.copyOf(stringList, stringList.length + 1);
            stringList[stringList.length - 1] = item;
        }
        return item;
    }

//    @Override
//    public String add(int index, String item) {
//    }

    @Override
    public String set(int index, String item) {
        if (index <= stringList.length && index >= 0) {
            stringList[index] = item;
            return item;
        }
        throw new InvalidIndexException();
    }

    @Override
    public String remove(String item) {
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i].equals(item)) {
                stringList[i] = null;
                if (i != stringList.length - 1) {
                    System.arraycopy(stringList, i + 1, stringList, i, stringList.length - i - 1);
                    return item;
                }
            }
        }
        throw new ItemNotFoundException();
    }

    @Override
    public String remove(int index) {
        String itemToRemove = stringList[index];
        stringList[index] = null;
        if (index != stringList.length - 1) {
            System.arraycopy(stringList, index + 1, stringList, index, stringList.length - index - 1);
            return itemToRemove;
        }
        throw new InvalidIndexException();
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i].equals(item)) {
                    return true;
                }
            }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = stringList.length - 1; i >= 0; i--) {
            if (stringList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index <= stringList.length && index >= 0) {
            return stringList[index];
        }
        throw new InvalidIndexException();
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList != null) {
            if (stringList.equals(otherList)) {
                return true;
            } else {
                return false;
            }
        }
        throw new NullParameterException();
    }

    @Override
    public int size() {
        return stringList.length;
    }

    @Override
    public boolean isEmpty() {
        if (stringList.length == 1 && stringList[0] == null) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        stringList = new String[1];
    }

    @Override
    public String[] toArray() {
        String[] clone = stringList.clone();
        return clone;
    }

}
