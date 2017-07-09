package Ch2LinkedLists;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DavesLinkedListTest {

    @Test
    public void givenAPopulatedLinkListWhenITraverseTheListThenMyJourneyIsExpected() throws Exception {
        DavesLinkedList davesLinkedList = new DavesLinkedList();
        assertNull(davesLinkedList.getHead());
        DavesNode davesNode = new DavesNode(486);
        davesLinkedList.addToTailEnd(davesNode);
        assertEquals(1, davesLinkedList.size());
        assertEquals(486, davesLinkedList.getHead().getValue());
        DavesNode davesNode1 = new DavesNode(481);
        DavesNode davesNode2 = new DavesNode(44);
        DavesNode davesNode3 = new DavesNode(6);
        DavesNode davesNode4 = new DavesNode(46);
        DavesNode davesNode5 = new DavesNode(86);
        DavesNode davesNode6 = new DavesNode(486);
        DavesNode davesNode7 = new DavesNode(4);
        davesLinkedList.addToTailEnd(davesNode1);
        davesLinkedList.addToTailEnd(davesNode2);
        davesLinkedList.addToTailEnd(davesNode3);
        davesLinkedList.addToTailEnd(davesNode4);
        davesLinkedList.addToTailEnd(davesNode5);
        davesLinkedList.addToTailEnd(davesNode6);
        davesLinkedList.addToTailEnd(davesNode7);
        assertEquals(8, davesLinkedList.size());
        assertEquals(46, davesLinkedList.getHead().getNextNode().getNextNode().getNextNode().getNextNode().getValue());
        davesLinkedList.removeAtIndex(0);
        davesLinkedList.removeAtIndex(3);
        assertEquals(6, davesLinkedList.size());
        assertEquals(6, davesLinkedList.getHead().getNextNode().getNextNode().getValue());
    }

    @Test(expected = DavesLinkedList.InvalidActivityInDavesLinkedListException.class)
    public void givenAnEmptyLinkedListWhenAttemptingToRemoveAnElementThenAnExceptionIsThrown() throws Exception {
        DavesLinkedList davesLinkedList = new DavesLinkedList();
        davesLinkedList.removeAtIndex(0);
    }
}