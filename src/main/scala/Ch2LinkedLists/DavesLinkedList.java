package Ch2LinkedLists;

/*
    Singly linked list implementation
 */
public class DavesLinkedList {

    private DavesNode head;
    private DavesNode tail;
    private int countNodes = 0;

    public DavesNode getHead() {
        return this.head;
    }

    public DavesNode getTail() {
        return tail;
    }

    public void addToTailEnd(DavesNode davesNode) {
        countNodes++;
        if (tail == null) {
            head = davesNode;
            tail = davesNode;
            return;
        }
        tail.setNextNode(davesNode);
        tail = davesNode;
    }

    public void removeAtIndex(int index) {
        if (index < 0 || index + 1 > size() || size() <= 0) {
            throw new InvalidActivityInDavesLinkedListException("Index is invalid or the ll is already empty.");
        }
        if (size() == 1) {
            voidOutLinkedList();
        } else if (size() == 2) {
            handleRemovalForSizeTwoLL(index);
        } else {
            handleRemoveForSizeGreaterThanTwoLL(index);
        }
        countNodes--;
    }

    private void handleRemoveForSizeGreaterThanTwoLL(int index) {
        if (index == 0) {
            replaceHead();
        } else if (index == size() - 1) {
            replaceTail();
        } else {
            replaceInsideNode(index);
        }
    }

    private void replaceInsideNode(int index) {
        DavesNode preIndex = head;
        for (int i = 0; i < index - 1; i++) {
            preIndex = preIndex.getNextNode();
        }
        DavesNode atIndex = preIndex.getNextNode();
        preIndex.setNextNode(atIndex.getNextNode());
        atIndex.setNextNode(null);
    }

    private void replaceTail() {
        DavesNode findPenultimate = head;
        for (int i = 0; i < size() - 2; i++) {
            findPenultimate = findPenultimate.getNextNode();
        }
        this.tail = findPenultimate;
        findPenultimate.setNextNode(null);
    }

    private void replaceHead() {
        DavesNode temp = head.getNextNode();
        head.setNextNode(null);
        head = temp;
    }

    private void handleRemovalForSizeTwoLL(int index) {
        if (index == 0) {
            head = tail;
        } else if (index == 1) {
            tail = head;
        }
    }

    private void voidOutLinkedList() {
        head = null;
        tail = null;
    }

    public int size() {
        return countNodes;
    }

    @Override
    public String toString() {
        DavesNode headCopy = head;
        StringBuffer sb = new StringBuffer();
        sb.append("DavesLinkedList{");
        while (headCopy != null) {
            sb.append(headCopy);
            sb.append(",");
            headCopy = headCopy.getNextNode();
        }
        sb.setLength(sb.length() - 1);
        return sb.toString() + "}";
    }

    public class InvalidActivityInDavesLinkedListException extends RuntimeException {

        public InvalidActivityInDavesLinkedListException() {
            super();
        }

        public InvalidActivityInDavesLinkedListException(String msg) {
            super(msg);
        }

    }
}
