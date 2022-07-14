package ru.atikhonov.stringlist;

import java.util.Arrays;

public class StringListImpl implements StringList {

    private String[] arr;

    private int index = 0;

    private final int initialLength;

    public StringListImpl(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException();
        }
        initialLength = length;
        this.arr = new String[length];
    }

    @Override
    public String add(String item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (index == arr.length) {
            expandArr();
        }
        arr[index++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (index != 0 && index >= this.index) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int indexOfNull = 0;
        if (index == 0 && this.index == 0 && arr[0] == null) {
            arr[index] = item;
            this.index++;
        } else if (index < this.index && arr[index] != null) {
            for (int i = index + 1; i < arr.length; i++) {
                if (arr[i] == null) {
                    indexOfNull = i;
                    break;
                }
            }
            if (indexOfNull > 0) {
                shiftRight(index, indexOfNull);
                arr[index] = item;
                this.index++;
            } else {
                indexOfNull = this.index;
                expandArr();
                shiftRight(index, indexOfNull);
                arr[index] = item;
                this.index++;
            }
        }
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index < this.index && item != null) {
            arr[index] = item;
            return item;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public String remove(String item) {
        boolean hasItem = false;
        if (this.index == 1 && arr[0] == item) {
            hasItem = true;
            item = arr[0];
            arr[0] = null;
            this.index--;
        } else {
            for (int i = 0; i < index; i++) {
                if (arr[i] == item) {
                    hasItem = true;
                    shiftLeft(i , this.index);
                    index--;
                }
            }
        }
        if (this.index != 0 && this.index == arr.length - initialLength) {
            reduceArr();
        }
        if (hasItem == false) {
            throw new IllegalArgumentException();
        }
        return item;
    }

    @Override
    public String remove(int index) {
        if (arr[index] == null) {
            throw new IllegalArgumentException();
        }
        String item;
        if (index >= this.index || arr[index] == null) {
            throw new IllegalArgumentException();
        } else if (this.index == 1 && index == 0) {
            item = arr[0];
            arr[0] = null;
            this.index--;
        } else {
            item = arr[index];
            shiftLeft(index, this.index);
            this.index--;
        }
        if (this.index != 0 && this.index == arr.length - initialLength) {
            reduceArr();
        }
        return item;
    }

    @Override
    public boolean contains(String item) {
        boolean hasItem = false;
        if (item == null) {
            throw new IllegalArgumentException();
        } else {
            for (int i = 0; i < index; i++) {
                if (arr[i] == item) {
                    hasItem = true;
                    break;
                }
            }
        }
        return hasItem;
    }

    @Override
    public int indexOf(String item) {
        int index = -1;
        for (int i = 0; i < this.index; i++) {
            if (arr[i] == item) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(String item) {
        int index = -1;
        for (int i = this.index - 1; i >= 0; i--) {
            if (arr[i] == item) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public String get(int index) {
        if (index >= this.index) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return arr[index];
        }
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        int size = index;
        return size;
    }

    @Override
    public boolean isEmpty() {
        boolean isEmpty = true;
        for (int i = 0; i < index; i++) {
            if (arr[i] != null) {
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }

    @Override
    public void clear() {
        int length = index;
        if (!isEmpty()) {
            for (int i = 0; i < length; i++) {
                arr[i] = null;
                index--;
            }
            arr = new String[initialLength];
        }
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(arr, index);
    }

    private void expandArr() {
        String[] tmp = new String[index];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = arr[i];
        }
        arr = new String[index + initialLength];
        for (int i = 0; i < tmp.length; i++) {
            arr[i] = tmp[i];
        }
    }

    private void reduceArr() {
        String[] tmp = new String[index];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = arr[i];
        }
        arr = new String[arr.length - initialLength];
        for (int i = 0; i < tmp.length; i++) {
            arr[i] = tmp[i];
        }
    }

    private void shiftRight(int from, int to) {
        for (int i = to; i > from; i--) {
            arr[i] = arr[i - 1];
            arr[i - 1] = null;
        }
    }

    private void shiftLeft(int to, int from) {
        for (int i = to + 1; i < from; i++) {
            arr[i - 1] = arr[i];
            arr[i] = null;
        }
    }

    @Override
    public int getArrSize() {
        return arr.length;
    }
}
