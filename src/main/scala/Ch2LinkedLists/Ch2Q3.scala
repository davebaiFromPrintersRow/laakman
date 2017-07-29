package Ch2LinkedLists

import scala.collection.mutable

object Ch2Q3 {

  def main(args: Array[String]) {
    println("delete middle node")
    println("alg to delete an inner node of an SLL given only access to the to be deleted node")

    val sLL = mutable.LinkedList(13, 38, 2, 86, 29, 22, 90, 11, 29, 32)
    val node29 = sLL.next.next.next.next
    println("before deleting node 29: " + sLL)
    deleteMiddleNode(node29)
    println("after deleting node 29: " + sLL)
  }

  def deleteMiddleNode(node: mutable.LinkedList[Int]): Boolean = {
    if (node == null || node.next == null) {
      false
    }
    val nodeToCopy = node.next
    node.elem = nodeToCopy.elem
    node.next = nodeToCopy.next
    true
  }
}