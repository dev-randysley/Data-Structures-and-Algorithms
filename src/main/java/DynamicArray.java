public class DynamicArray<String> {
    private Object[] data;
    private int size;
    private int initialCapacity;

    public DynamicArray(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        data = new Object[initialCapacity];
    }

    public String get(int index) {
        return (String) this.data[index];
    }

    public void set(int index, String value) {
        this.data[index] = value;
    }

    public void insert(int index, String value) {
        if (this.size == this.initialCapacity)
            resize();
        // copy up
        for (int i = size; i > index; i--)
            data[i] = data[i - 1];
        // insert to
        data[index] = value;
        size++;
    }

    public void delete(int index) {
        int finalIndex = this.initialCapacity - 1;
        if (index <= finalIndex) {
            if (index == finalIndex) {
                data[index] = null;
            } else {
                for (int i = index; i < size; i++){
                    data[i] = this.data[i +1];
                }
            }
            size--;
        }
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean Contains(String value) {
        boolean result = false;
        for (int i = 0; i < size; i++) {
            if(data[i] != null){
                if (data[i].equals(value))
                    result = true;
            }

        }
        return result;
    }

    public void resize() {
        Object[] newData = new Object[initialCapacity * 2];
        for(int i = 0; i<initialCapacity; i++){
            newData[i] = data[i];
        }
        data = newData;
        this.initialCapacity = this.initialCapacity * 2;
    }

    public int size(){
        return size;
    }

    public void add(String value){
        if(size == initialCapacity)
            resize();
        data[size] = value;
        size++;
    }
}
