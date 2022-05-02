
public class MyHashMap <K, V>{

    private Entry<K, V>[] table;

    //default size of hashmap
    private int capacity = 8;

    public MyHashMap()
    {
        table = new Entry[this.capacity];
    }

    public MyHashMap(int capacity)
    {
        this.capacity = capacity;
        table = new Entry[capacity];
    }

    public void put(K key, V value)
    {
        int hashKey = makeHash(key);
        Entry<K, V> newEntry = new Entry<>(key, value, null);

        if(table[hashKey] == null) table[hashKey] = newEntry;
        else
        {
            Entry<K, V> prevRecord = null, currentRecord = table[hashKey];

            while(currentRecord != null)
            {
                if(currentRecord.getKey().equals(key))
                {
                    currentRecord.setValue(value);
                    break;
                }

                prevRecord = currentRecord;
                currentRecord = currentRecord.getNext();
            }

            if(prevRecord != null) prevRecord.setNext(newEntry);
        }
    }

    public int size()
    {
        int size = 0;
        for(int i=0;i<capacity;i++)
        {
            if(table[i] != null)
            {
                Entry<K, V> currentRecord = table[i];
                while(currentRecord != null)
                {
                    size++;
                    currentRecord = currentRecord.getNext();
                }
            }
        }
        return size;
    }

    public V get(K key)
    {
        V value = null;
        int hashKey = makeHash(key);

        Entry<K, V> currentRecord = table[hashKey];

        while(currentRecord != null)
        {
            if(currentRecord.getKey().equals(key))
            {
                value = currentRecord.getValue();
                break;
            }
            currentRecord = currentRecord.getNext();
        }
        return value;
    }

    public void remove(K key)
    {
        int hashKey = makeHash(key);
        Entry<K, V> prevRecord = null;
        Entry<K, V> currentRecord = table[hashKey];

        while(currentRecord != null)
        {
            if (currentRecord.getKey().equals(key)) {
                if (prevRecord == null)
                {
                    currentRecord = currentRecord.getNext();
                    table[hashKey] = currentRecord;
                    return;
                }
                else
                {
                    prevRecord.setNext(currentRecord.getNext());
                    return;
                }
            }
            prevRecord = currentRecord;
            currentRecord = currentRecord.getNext();
        }
    }

    public void display()
    {
        for(int i=0;i<capacity;i++)
        {
            if(table[i] != null)
            {
                Entry<K, V> currentRecord = table[i];
                while(currentRecord != null)
                {
                    System.out.println(currentRecord.getKey() + " " + currentRecord.getValue());
                    currentRecord = currentRecord.getNext();
                }
            }
        }
    }

    public void clear()
    {
        table = new Entry[capacity];
    }

    public boolean isEmpty()
    {
        if(size() == 0) return true;
        else return false;
    }

    public void replace(K key, V newValue)
    {
        int hashKey = makeHash(key);
        Entry<K, V> currentRecord = table[hashKey];

        while(currentRecord != null)
        {
            if(currentRecord.getKey().equals(key))
            {
                currentRecord.setValue(newValue);
                break;
            }
            currentRecord = currentRecord.getNext();
        }
    }

    public boolean containsKey(K key)
    {
        int hashKey = makeHash(key);
        Entry<K, V> currentRecord = table[hashKey];

        while(currentRecord != null)
        {
            if(currentRecord.getKey().equals(key))
            {
                return true;
            }
            currentRecord = currentRecord.getNext();
        }
        return false;
    }

    private int makeHash(K key)
    {
        if(key == null) return 0;
        return Math.abs(key.hashCode()) % capacity;
    }
}
