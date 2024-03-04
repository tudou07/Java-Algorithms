package main.java.Hashmapping.HashMapImplementation;

/**
 * Hash Map is implemented using array and array of linkedList.
 * References:
 * <a href="https://www.youtube.com/watch?v=1Ovg3IC-p5A&t=1271s">CLick</a>
 *
 * @param <K>
 * @param <V>
 */
public class myHashMap<K, V> {
    private final int SIZE = 2;

    private final Entry<K, V>[] table;

    public myHashMap() {
        table = new Entry[SIZE];
    }

    void put(K key, V value) {
        // Map hash into an array using modulus
        int hash = key.hashCode() % 2; // Can be any number b/w 0 and 7

        Entry<K, V> entry = table[hash];

        if (entry == null) {
            table[hash] = new Entry<>(key, value);
            return;
        } else {
            // traverse through the LL present there
            while (entry.next != null) {
                if (entry.getKey() == key) {
                    entry.setValue(value);
                    return;
                }
                entry = entry.next;
            }

            if (entry.getKey() == key) {
                entry.setValue(value);
                return;
            }
            entry.next = new Entry<K, V>(key, value);
        }

    }

    public V get(K key) {
        int hash = key.hashCode() % SIZE;
        Entry<K, V> e = table[hash];

        if (e == null) {
            return null;
        }
        while (e != null) {
            if (e.getKey() == key) {
                return e.getValue();
            }
            e = e.next;
        }
        return null;
    }

    public Entry remove(K key) {
        int hash = key.hashCode() % SIZE;
        Entry<K, V> e = table[hash];

        if (e == null)
            return null;

        // If the head key is the key we want to remove.
        if (e.getKey() == key) {
            table[hash] = e.next;
            e.next = null;
            return e;
        }
        Entry<K, V> prev = e;

        while (e != null) {
            if (e.getKey() == key) {
                prev.next = e.next;
                e.next = null;
                return e;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        myHashMap<Integer, String> hash = new myHashMap<>();
        hash.put(1, "hello");
        hash.put(2, "World");
        hash.put(3, "Sahil");
        hash.put(4, "suuuiiii");

        System.out.println(hash.get(4));
    }
}
