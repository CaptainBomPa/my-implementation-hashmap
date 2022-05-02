import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {

    @Test
    void shouldCreateClass()
    {
        //given
        //when
        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();

        //then
        assertInstanceOf(MyHashMap.class, myHashMap);
        assertThat(myHashMap.size(), is(0));
    }

    @Test
    void shouldCreateClassWithCustomCapacity()
    {
        //given
        //when
        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>(15);

        //then
        assertInstanceOf(MyHashMap.class, myHashMap);
        assertThat(myHashMap.size(), is(0));
    }

    @Test
    void shouldPutNewRecord()
    {
        //given
        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();

        //when
        myHashMap.put(15, 20);

        //then
        assertThat(myHashMap.get(15), is(20));
        assertThat(myHashMap.size(), is(1));
    }

    @Test
    void shouldPutManyRecords()
    {
        //given
        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();

        //when
        myHashMap.put(15, 20);
        myHashMap.put(12, 25);
        myHashMap.put(19, 99);

        //then
        assertThat(myHashMap.get(15), is(20));
        assertThat(myHashMap.get(12), is(25));
        assertThat(myHashMap.get(19), is(99));
    }

    @Test
    void shouldReturnProperSize()
    {
        //given
        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();

        //when
        myHashMap.put(15, 20);
        myHashMap.put(12, 25);
        myHashMap.put(19, 99);

        //then
        assertThat(myHashMap.size(), is(3));
    }

    @Test
    void shouldReturnProperValueFromKey()
    {
        //given
        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();

        //when
        myHashMap.put(15, 20);

        //then
        assertThat(myHashMap.get(15), is(20));
    }

    @Test
    void shouldRemoveItem()
    {
        //given
        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put(15, 20);
        myHashMap.put(12, 8);

        //when
        myHashMap.remove(15);
        myHashMap.remove(12);

        //then
        assertThat(myHashMap.size(), is(0));
        assertThat(myHashMap.get(15), nullValue());
    }

    @Test
    void shouldClearAll()
    {
        //given
        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put(15, 20);
        myHashMap.put(12, 8);

        //when
        myHashMap.clear();

        //then
        assertThat(myHashMap.size(), is(0));
    }

    @Test
    void shouldReturnTrueIfEmpty()
    {
        //given
        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();

        //when
        //then
        assertThat(myHashMap.isEmpty(), is(true));
    }

    @Test
    void shouldReturnFalseIfNotEmpty()
    {
        //given
        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put(15, 20);

        //when
        //then
        assertThat(myHashMap.isEmpty(), is(false));
    }

    @Test
    void shouldChangeValueOfSpecifiedKey()
    {
        //given
        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put(15, 20);

        //when
        myHashMap.replace(15, 66);

        //then
        assertThat(myHashMap.get(15), is(66));
    }

    @Test
    void shouldReturnTrueIfKeyExists()
    {
        //given
        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put(15, 20);

        //when
        //then
        assertThat(myHashMap.containsKey(15), is(true));
    }

    @Test
    void shouldReturnFalseIfKeyDoNotExists()
    {
        //given
        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();

        //when
        //then
        assertThat(myHashMap.containsKey(15), is(false));

        HashMap<Integer, Integer> hashMap = new HashMap<>();
    }
}