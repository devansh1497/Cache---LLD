package strategies;

public interface EvictionStrategy<K ,V> {

    K evict();

    void accessed(K key, V value);
}
