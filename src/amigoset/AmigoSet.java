package amigoset;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E>{
    private static final Object PRESENT = new Object();

    public AmigoSet() {
        map = new HashMap<>(16);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E e : c)
            if (add(e))
                modified = true;
        return modified;
    }

    public AmigoSet(Collection<? extends E> collection) {
        int cap = Math.max(16, (int)Math.ceil(collection.size()/.75f));
        map = new HashMap<E, Object>(cap);
        for(E elem: collection){
            map.put(elem, PRESENT);
        }

    }

    @Override
    public boolean add(E e) {
        boolean result = !map.containsKey(e);
        map.put(e, PRESENT);
        return result && map.containsKey(e);
    }

    private transient HashMap<E, Object> map;
    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public Object clone(){
        try{
            AmigoSet<E> newObject = new AmigoSet<>();
            HashMap<E, Object> newMap = (HashMap<E, Object>) map.clone();
            newObject.addAll(newMap.keySet());
            return newObject;

        }catch (Throwable e){
            throw new InternalError(e);
        }
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o)!= null;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof AmigoSet)) return false;
        AmigoSet amigo = (AmigoSet) o;
        return map.equals(amigo.map);
    }

    @Override
    public int hashCode() {
        return map.hashCode();
    }

    @Override
    public void clear() {
        map.clear();
    }
    private void readObject(ObjectInputStream inputStream) throws  IOException, ClassNotFoundException{
        inputStream.defaultReadObject();
        int capacity = inputStream.readInt();
        float loadFactor = inputStream.readFloat();
        Set<E> set = new HashSet<>();
        map = new HashMap<>(capacity, loadFactor);
        int count = inputStream.readInt();
        for (int i = 0; i < count ; i++)
            set.add((E)inputStream.readObject());
        addAll(set);
    }
    private void writeObject(ObjectOutputStream outputStream) throws IOException{
        Set<E> set = map.keySet();
        int capacity = HashMapReflectionHelper.callHiddenMethod(map, "capacity");
        float loadFactor = HashMapReflectionHelper.callHiddenMethod(map, "loadFactor");
        outputStream.defaultWriteObject();
        outputStream.writeInt(capacity);
        outputStream.writeFloat(loadFactor);
        outputStream.writeInt(set.size());
        for (E e: set
             ) {
            outputStream.writeObject(e);
        }
    }
}


