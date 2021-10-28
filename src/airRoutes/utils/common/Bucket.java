package airRoutes.utils.common;

public class Bucket<K, V>{
    final K key;
    V value;
    Bucket<K, V> nextBucket;
    public Bucket(K key, V value, Bucket<K, V> nextBucket){
        this.key = key;
        this.value = value;
        this.nextBucket = nextBucket;
    }
}
