package mymultimap;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        //напишите тут ваш код
        int size = 0;
        for (Entry<K, List<V>> pair: map.entrySet()
             ) {
            if (pair.getValue() != null)
                size += pair.getValue().size();
        }
        return size;
    }

    @Override
    public V put(K key, V value) {
        /*V put(K key, V value) - должен добавить элемент value по ключу key.
        Если в мапе такой ключ уже есть, и количество значений по этому ключу меньше, чем repeatCount - то добавь элемент value в конец листа в объекте map.
        Если по такому ключу количество значений равняется repeatCount - то удали из листа в объекте map элемент с индексом ноль, и добавь в конец листа value.
        Метод должен возвращать значение последнего добавленного элемента по ключу key (но не значение, которое мы сейчас добавляем).
        Если по ключу key значений еще нет - верни null.*/
        if (key == null)
            throw new IllegalArgumentException();
        List<V> tempList = map.containsKey(key) ? map.get(key) : new LinkedList<>();
        map.remove(key);
        int size = tempList.size();
        V result = size > 0 ? tempList.get(size - 1) : null;
        if ( size < repeatCount)
            tempList.add(value);
        else {
            tempList.remove(0);
            tempList.add(value);
        }
        map.put(key, tempList);
        return result;
    }

    @Override
    public V remove(Object key) {
        /*
        * V remove(Object key) - должен удалить элемент по ключу key. Если по этому ключу хранится несколько элементов - должен удаляться элемент из листа с индексом ноль.
         * Если по какому-то ключу хранится лист размером ноль элементов - удали такую пару ключ : значение. Метод должен возвращать элемент, который ты удалил.
        * Если в мапе нет ключа key - верни null.*/
        if (!map.containsKey(key))
            return null;
        List<V> tempList = map.get(key);
        int size = tempList.size();
        V result = size > 0 ? tempList.get(0) : null;
        map.remove(key);
        if (size > 0){
            tempList.remove(0);
            if (tempList.size() > 0)
                map.put((K) key, tempList);
        }
        return result;

    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        //напишите тут ваш код
        ArrayList<V> result = new ArrayList<>();
        for (List<V> list: map.values()
             ) {
            result.addAll(list);
        }
        return result;
    }

    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        return map.containsKey(key);

    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        boolean result = false;
        for (List<V> list: map.values()
                ) {
            if (list.contains(value)){
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}