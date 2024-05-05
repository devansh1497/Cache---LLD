package datastructures;

public class DLL<K> {

    private DLLNode<K> dummyHead;
    private DLLNode<K> dummyTail;
    private int size;

    public DLL() {
        this.dummyHead = new DLLNode<>(null);
        this.dummyTail = new DLLNode<>(null);
        this.dummyHead.setNext(this.dummyTail);
        this.dummyTail.setPrev(this.dummyHead);
    }

    public K remove(DLLNode<K> node) {
        DLLNode<K> prev = node.getPrev();
        DLLNode<K> next = node.getNext();
        prev.setNext(next);
        next.setPrev(prev);
        size--;
        return node.getData();
    }

    public DLLNode<K> addHead(K data) {
        DLLNode<K> node = new DLLNode<>(data);
        DLLNode<K> next = dummyHead.getNext();
        dummyHead.setNext(node);
        node.setPrev(dummyHead);
        next.setPrev(node);
        node.setNext(next);
        size++;
        return node;
    }

    public DLLNode<K> deleteTail() {
        DLLNode<K> prev = dummyTail.getPrev().getPrev();
        DLLNode<K> deletedNode = prev.getNext();
        prev.setNext(dummyTail);
        dummyTail.setPrev(prev);
        size--;
        return deletedNode;
    }

    public int getSize() {
        return size;
    }
}
