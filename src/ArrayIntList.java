import java.util.Iterator;

public class ArrayIntList implements IntList {

    private int size;
    private int[] buffer;

    public ArrayIntList() {
        size = 0;
        this.buffer = new int[10];
    }

    /**
     * Prepends (inserts) the specified value at the front of the list (at index 0).
     * Shifts the value currently at the front of the list (if any) and any
     * subsequent values to the right.
     *
     * @param value value to be inserted
     */
    @Override
    public void addFront(int value) {
        if (size == buffer.length) {
            resize(size * 2);
        }

        //4 <- 3
        //3 <- 2
        //2 <- 1
        //1 <- 0
        for (int i = size; i >= 1; i--) {
            buffer[i] = buffer[i - 1];
        }

        buffer[4] = buffer[3];
        buffer[3] = buffer[2];
        buffer[2] = buffer[1];
        buffer[1] = buffer[0];

       buffer[0] = value;
        size++;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        // TODO: check to see if we are full - if so, we need to create a larger buffer
        if (size == buffer.length) {
            resize(size * 2);
        }
        buffer[size] = value;
        value++;
    }

    /**
     * Inserts the specified value at the specified position in this list.
     * Shifts the value currently at that position (if any) and any subsequent
     * values to the right.
     *
     * @param index index at which the specified value is to be inserted
     * @param value value to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void add(int index, int value) {
        // TODO: finish method
        if (size == buffer.length) {
            resize(size * 2);
        }
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        // TODO: finish method

    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        // TODO: finish method

    }

    /**
     * Removes the value at the specified position in this list.
     * Shifts any subsequent values to the left. Returns the value
     * that was removed from the list.
     *
     * @param index the index of the value to be removed
     * @return the value previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public int remove(int index) {
        //validate index
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index cannot be greater than size");
        }
        else if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be less than zero");
        }

        //save a copy of the value to be removed, so we can return it latter
        int copyOfRemovedValue = buffer[index];

        //shift values to the left
        for (int i = index; i <= size - 1; i++) {
            buffer[i] = buffer[i + 1];
        }

        buffer[size - 1] = 0;

        //don't forget to decrease size
        size--;

        return copyOfRemovedValue;
    }

    /**
     * Returns the value at the specified position in the list.
     *
     * @param index index of the value to return
     * @return the value at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public int get(int index) {
        // TODO: finish method

        return 0;
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value) {
        // TODO: finish method

        return false;
    }

    /**
     * Returns the index of the first occurrence of the specified value
     * in this list, or -1 if this list does not contain the value.
     *
     * @param value value to search for
     * @return the index of the first occurrence of the specified value in this list
     * or -1 if this list does not contain the value
     */
    @Override
    public int indexOf(int value) {
        // TODO: finish method

        return 0;
    }

    /**
     * Returns true if this list contains no values.
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty() {
        // TODO: finish method

        return false;
    }

    /**
     * Returns the number of values in this list.
     *
     * @return the number of values in this list
     */
    @Override
    public int size() {
        // TODO: finish method

        return 0;
    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear() {
        buffer = new int[10];
        size = 0;

    }

    private void resize(int newSize) {
        //create new space, separate from the old space
        int[] newBuffer = new int[newSize];

        //copy everything over from buffer into newBuffer
        for (int i = 0; i < buffer.length; i++) {
            newBuffer[i] = buffer[i];
        }

        //set the new space into buffer
        buffer = newBuffer;

        //the old space is no longer "pointed to" and will
        //eventually be cleaned up by the garbage collector
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        // TODO: finish method

        return null;
    }
}