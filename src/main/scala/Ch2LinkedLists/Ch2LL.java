package Ch2LinkedLists;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class Ch2LL {

    public static void main(String[] args) {
        writeCodeToRemoveDuplicatesFromAnUnsortedLinkList();
    }

    // 2.1
    public static void writeCodeToRemoveDuplicatesFromAnUnsortedLinkList() {
        DavesLinkedList unsortedWithDuplicates = new DavesLinkedList();
        DavesNode n0 = new DavesNode(0);
        DavesNode n1 = new DavesNode(0);
        DavesNode n2 = new DavesNode(23);
        DavesNode n3 = new DavesNode(53);
        DavesNode n4 = new DavesNode(1);
        DavesNode n5 = new DavesNode(0);
        DavesNode n6 = new DavesNode(30);
        DavesNode n7 = new DavesNode(23);
        unsortedWithDuplicates.addToTailEnd(n0);
        unsortedWithDuplicates.addToTailEnd(n1);
        unsortedWithDuplicates.addToTailEnd(n2);
        unsortedWithDuplicates.addToTailEnd(n3);
        unsortedWithDuplicates.addToTailEnd(n4);
        unsortedWithDuplicates.addToTailEnd(n5);
        unsortedWithDuplicates.addToTailEnd(n6);
        unsortedWithDuplicates.addToTailEnd(n7);

        System.out.println("Before algorithm: " + unsortedWithDuplicates);

        Set<DavesNode> trackDuplicates = new HashSet<>();
        DavesNode temp = unsortedWithDuplicates.getHead();
        int trackIndex = 0;
        while (temp != null) {
            if (trackDuplicates.contains(temp)) {
                temp = temp.getNextNode();
                unsortedWithDuplicates.removeAtIndex(trackIndex);
                trackIndex--;
            } else {
                trackDuplicates.add(temp);
                temp = temp.getNextNode();
            }
            trackIndex++;
        }

        System.out.println("After algorithm: " + unsortedWithDuplicates.toString());

        // solve with no temporary buffer
        DavesLinkedList unsortedWithDuplicatesNoBuffer = new DavesLinkedList();
        DavesNode m0 = new DavesNode(0);
        DavesNode m1 = new DavesNode(0);
        DavesNode m2 = new DavesNode(23);
        DavesNode m3 = new DavesNode(53);
        DavesNode m4 = new DavesNode(1);
        DavesNode m5 = new DavesNode(0);
        DavesNode m6 = new DavesNode(30);
        DavesNode m7 = new DavesNode(23);
        unsortedWithDuplicatesNoBuffer.addToTailEnd(m0);
        unsortedWithDuplicatesNoBuffer.addToTailEnd(m1);
        unsortedWithDuplicatesNoBuffer.addToTailEnd(m2);
        unsortedWithDuplicatesNoBuffer.addToTailEnd(m3);
        unsortedWithDuplicatesNoBuffer.addToTailEnd(m4);
        unsortedWithDuplicatesNoBuffer.addToTailEnd(m5);
        unsortedWithDuplicatesNoBuffer.addToTailEnd(m6);
        unsortedWithDuplicatesNoBuffer.addToTailEnd(m7);

        System.out.println("Before algorithm with no temporary buffer. " + unsortedWithDuplicatesNoBuffer);
        DavesNode cowboy = unsortedWithDuplicatesNoBuffer.getHead();
        DavesNode lasso = unsortedWithDuplicatesNoBuffer.getHead();

        int trackCowboy = 0;
        while (cowboy != null) {
            lasso = cowboy; // reel back in the lasso
            int lassoPositionFromStartOfLL = trackCowboy;
            while (lasso != null) {
                if (cowboy == lasso) { // this == represents the same memory location
                    lasso = lasso.getNextNode();
                    lassoPositionFromStartOfLL++;
                    continue;
                }
                if (cowboy.equals(lasso)) { // this equals represents overrode method in DavesNode
                    lasso = lasso.getNextNode();
                    unsortedWithDuplicatesNoBuffer.removeAtIndex(lassoPositionFromStartOfLL);
                } else {
                    lasso = lasso.getNextNode();
                    lassoPositionFromStartOfLL++;
                }
            }
            cowboy = cowboy.getNextNode();
            trackCowboy++;
        }

        System.out.println("After algorithm with no temp buffer: " + unsortedWithDuplicatesNoBuffer);
    }
}
