import scala.collection.mutable

/*
  2.2
  algorithm to find kth to last element of singly LL
 */


object kthLast {
  println("ch 2 question 2")

  val singlyLinkedList = mutable.LinkedList(13, 38, 2, 86, 29, 22, 90, 11, 29, 32)

  // algorithm 1: challenge in this problem is we don't have a back reference to the
  // previous node in a singly ll.
  //
  // one strategy: finding the kth to last is like finding the node in
  // postion n-k starting from the head (where n is total number of nodes).
  // first we iterate entire list to get total length n;
  // then we subtract k from that and iterate (n-k) from the start to
  // the node that must be removed

  var sllIterator = singlyLinkedList;
  var length = 0;
  while (sllIterator.nonEmpty) {
    sllIterator = sllIterator.next;
    length += 1
  }
  length

  val kthPosition = 3;

  sllIterator = singlyLinkedList
  var counter = 0;
  while (sllIterator.nonEmpty) {
    sllIterator = sllIterator.next;
    counter += 1
    if (counter == length - kthPosition) {
      println("remove node: " + sllIterator.elem)
    }
  }

  // algorithm 2: recursive

}

def recursiveSearch: Unit = {

}