package stringlist;

import exception.InvalidIndexException;
import exception.ItemNotFoundException;
import exception.NullParameterException;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private String[] storage;
    private int size;

    public StringListImpl() {
        this.storage = new String[10];
    }


    @Override
    public String add(String item) {
        if (size >= storage.length) {
            storage = Arrays.copyOf(storage, (int) (storage.length + (storage.length * 0.5)));
        }
        storage[size++] = item;
        return item;
    }

   @Override
   public String add(int index, String item) {
        if (index >= size || index < 0) {
            throw new InvalidIndexException();
        }
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = item;
        size++;
        return item;
   }

    @Override
    public String set(int index, String item) {
        if (index >= size || index < 0) {
            throw new InvalidIndexException();
        }
        storage[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        int itemIndex = indexOf(item);
        if (itemIndex == -1) {
            throw new ItemNotFoundException();
        }
        if (itemIndex != storage.length - 1) {
            System.arraycopy(storage, itemIndex + 1, storage, itemIndex, size - itemIndex);
        }
        size--;
        return item;
    }

    @Override
    public String remove(int index) {
        if (index >= size || index < 0) {
            throw new InvalidIndexException();
        }
        String itemToRemove = storage[index];
        if (index != storage.length - 1) {
            System.arraycopy(storage, index + 1, storage, index, size - index);
        }
        size--;
        return itemToRemove;
    }

    @Override
    public boolean contains(String item) {
        int itemIndex = indexOf(item);
        return itemIndex >= 0;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index <= size && index >= 0) {
            return storage[index];
        }
        throw new InvalidIndexException();
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new NullParameterException();
        }
        return Arrays.equals(toArray(), otherList.toArray());
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(storage, size);
    }

}
