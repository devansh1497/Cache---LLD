package strategies;

import datastructures.DLL;
import datastructures.DLLNode;

import java.util.HashMap;
import java.util.Map;

public class LRUStrategy<K, V> implements EvictionStrategy<K, V> {

    DLL<K> dll;
    Map<K, DLLNode<K>> nodes;
    int capacity;

    public LRUStrategy(int capacity) {
        dll = new DLL<K>();
        nodes = new HashMap<>();
        this.capacity = capacity;
    }

    @Override
    public K evict() {
        if (dll.getSize() > capacity) {
            DLLNode<K> deletedNode = dll.deleteTail();
            return deletedNode.getData();
        }
        return null;
    }

    @Override
    public void accessed(K key, V value) {
        if(nodes.get(key) != null) {
            dll.remove(nodes.get(key));
        }
        dll.addHead(key);
    }
}
