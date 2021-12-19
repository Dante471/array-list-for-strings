package stringlist;

import exception.InvalidIndexException;
import exception.ItemNotFoundException;
import exception.NullParameterException;

import java.util.Arrays;
import java.util.Objects;

public class StringListImpl implements StringList {
    private String[] stringList;
    private int size;

    public StringListImpl() {
        this.stringList = new String[10];
    }


    @Override
    public String add(String item) {
        if (size >= stringList.length) {
            stringList = Arrays.copyOf(stringList, (int) (stringList.length + (stringList.length * 0.5)));
        }
        stringList[size++] = item;
        return item;
    }

   @Override
   public String add(int index, String item) {
       if (index <= size - 1 && index >= 0) {
           System.arraycopy(stringList, index, stringList, index + 1, size - index);
           stringList[index] = item;
           size++;
           return item;
       }
       throw new InvalidIndexException();
   }

    @Override
    public String set(int index, String item) {
        if (index <= size - 1 && index >= 0) {
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
                    System.arraycopy(stringList, i + 1, stringList, i, size - i);
                }
                size--;
                return item;
            }
        }
        throw new ItemNotFoundException();
    }

    @Override
    public String remove(int index) {
        String itemToRemove = stringList[index];
        stringList[index] = null;
        if (index != stringList.length - 1) {
            System.arraycopy(stringList, index + 1, stringList, index, size - index);
            size--;
            return itemToRemove;
        }
        throw new InvalidIndexException();
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < size; i++) {
            if (stringList[i].equals(item)) {
                    return true;
                }
            }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (stringList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (stringList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index <= size && index >= 0) {
            return stringList[index];
        }
        throw new InvalidIndexException();
    }


    @Override
    public int getSize() {
        return size;
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
        stringList = new String[10];
        size = 0;
    }

    @Override
    public String[] toArray() {
        String[] arr = new String[size];
        System.arraycopy(stringList, 0, arr, 0, size);
        return arr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StringListImpl)) return false;
        StringListImpl that = (StringListImpl) o;
        return size == that.size && Arrays.equals(stringList, that.stringList);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(stringList);
        return result;
    }
}
