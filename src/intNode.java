public class intNode {
    private int value;
    private intNode next;

    public intNode(int value) {
        this.value = value;
        this.next = null;
    }

    public intNode(int value, intNode next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public intNode getNext() {
        return next;
    }

    public void setNext(intNode next) {
        this.next = next;
    }

    public boolean hasNext() {
        return(this.next!=null);
    }
    public void build() {

    }

    @Override
    public String toString() {
        return this.value + "--> " + this.next;
    }

}
