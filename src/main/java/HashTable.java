public class HashTable {
    private final int INITIAL_SIZE = 16; // array length
    private HashEntry[] data; // Linked List

    class HashEntry {
        String key;
        String value;
        HashEntry next;

        HashEntry(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    HashTable() {
        data = new HashEntry[INITIAL_SIZE];
    }

    public void put(String key, String value) {
        int index = getIndex(key);
        HashEntry entry = new HashEntry(key, value);
        if (data[index] == null)
            data[index] = entry;
            // else handle collision by adding to end of linked list
        else {
            HashEntry entries = data[index];
            // walk to the end
            while (entries.next != null)
                entries = entries.next;
            entries.next = entry;
        }
    }

    public String get(String key){
        int index = getIndex(key);
        HashEntry entries = data[index];
        if(entries != null){
            // walk until find match
            while(!entries.key.equals(key) && entries.next != null)
                entries = entries.next;
            return !entries.key.equals(key) ? null : entries.value;
        }
        return null;
    }

    public int getIndex(String key){
        int hashCode = key.hashCode();
        System.out.println("hashCode = " + hashCode);
        // convert to index
        int index = Math.abs(hashCode) % INITIAL_SIZE;
        System.out.println("index = " + index);

        if(key.equals("John Smith") || key.equals("Sandra Dee"))
            index = 4; // force collision for testing

        return index;
    }






}
