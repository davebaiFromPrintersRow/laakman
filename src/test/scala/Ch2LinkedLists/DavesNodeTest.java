package Ch2LinkedLists;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class DavesNodeTest {
    @Test
    public void givenADefinedNodeObjectWhenIModifyItsStateThenItReturnsTheModifiedState() throws Exception {
        DavesNode node = new DavesNode(5);
        assertEquals(5, node.getValue());
        assertNull(node.getNextNode());

        DavesNode secondNode = new DavesNode(385);
        node.setNextNode(secondNode);
        assertNotNull(node.getNextNode());

        DavesNode thirdNode = new DavesNode(485);
        DavesNode fourthNode = new DavesNode(10, thirdNode);
        assertEquals(thirdNode.getValue(), fourthNode.getNextNode().getValue());
    }
}