package Ch2LinkedLists;

public class DavesNode {

    private int value;
    private DavesNode nextNode;

    public DavesNode(int nodeValue) {
        this.value = nodeValue;
    }

    public DavesNode(int value, DavesNode nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }

    public int getValue() {
        return value;
    }

    public void setNextNode(DavesNode nextNode) {
        this.nextNode = nextNode;
    }

    public DavesNode getNextNode() {
        return nextNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DavesNode davesNode = (DavesNode) o;

        return value == davesNode.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {
        return "DavesNode{" + value +
                '}';
    }
}
