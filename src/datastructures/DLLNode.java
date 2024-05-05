package datastructures;

public class DLLNode<K> {

    private K data;
    private DLLNode<K> next;
    private DLLNode<K> prev;

    public DLLNode(K data) {
        this.data = data;
    }

    public K getData() {
        return data;
    }

    public DLLNode<K> getNext() {
        return next;
    }

    public DLLNode<K> getPrev() {
        return prev;
    }

    public void setData(K data) {
        this.data = data;
    }

    public void setNext(DLLNode<K> next) {
        this.next = next;
    }

    public void setPrev(DLLNode<K> prev) {
        this.prev = prev;
    }
}
