import scala.collection.mutable

/*
  2.2
  algorithm to find kth to last element of singly LL
 */

val kTH_POSITION = 3;
val singlyLinkedList = mutable.LinkedList(13, 38, 2, 86, 29, 22, 90, 11, 29, 32)

object kthLast {
  println("ch 2 question 2")

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

  sllIterator = singlyLinkedList
  var counter = 0;
  while (sllIterator.nonEmpty) {
    sllIterator = sllIterator.next;
    counter += 1
    if (counter == length - kTH_POSITION) {
      println("remove node: " + sllIterator.elem)
    }
  }

  // algorithm 2: recursive
  recursiveSearch(singlyLinkedList, 4)
}

def recursiveSearch(element: mutable.LinkedList[Int], kthLast: Int): Int = {
  if (!element.next.nonEmpty) {
    return 1
  }
  var counter = recursiveSearch(element.next, kthLast) + 1
  if (counter == kTH_POSITION) {
    println("remove element: " + element.elem + " at position: " + kTH_POSITION)
  }
  return counter
}