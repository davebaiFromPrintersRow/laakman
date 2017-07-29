package Ch2LinkedLists

import Ch2LinkedLists.datamodel.DaveNode

object Ch2Q4 {

  def main(args: Array[String]): Unit = {
    println("Partition")
    println("IN:  3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition=5]")
    println("OUT: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8")

    println()

    val node0 = new DaveNode(3, null)
    var head = node0

    val node1 = new DaveNode(5, null)
    val node2 = new DaveNode(8, null)
    val node3 = new DaveNode(5, null)
    val node4 = new DaveNode(10, null)
    val node5 = new DaveNode(2, null)
    val node6 = new DaveNode(1, null)

    node0.nextNode = node1
    node1.nextNode = node2
    node2.nextNode = node3
    node3.nextNode = node4
    node4.nextNode = node5
    node5.nextNode = node6

    println("Before list:")
    while (head != null) {
      println(head)
      head = head.nextNode
    }

    val partitionVale = 5

    var iterator = node0
    var lessThanNodes: DaveNode = null
    var equalsOrGreaterNodes: DaveNode = null

    var tailOfLessThans: DaveNode = null
    var tailOfGreaterThanEqualsTo: DaveNode = null
    while (iterator != null) {
      if (iterator.value < partitionVale) {
        if (lessThanNodes == null) {
          val iteratorHolder: DaveNode = iterator
          lessThanNodes = iteratorHolder
          tailOfLessThans = lessThanNodes
        } else {
          tailOfLessThans.nextNode = iterator
          tailOfLessThans = iterator
        }
      }
      else {
        if (equalsOrGreaterNodes == null) {
          val iteratorHolder: DaveNode = iterator
          equalsOrGreaterNodes = iteratorHolder
          tailOfGreaterThanEqualsTo = equalsOrGreaterNodes
        }
        else {
          tailOfGreaterThanEqualsTo.nextNode = iterator
          tailOfGreaterThanEqualsTo = iterator
        }
      }
      iterator = iterator.nextNode
    }

    tailOfGreaterThanEqualsTo.nextNode = null
    tailOfLessThans.nextNode = equalsOrGreaterNodes

    head = lessThanNodes

    println("*" * 20)
    println("After list:")
    while (head != null) {
      println(head)
      head = head.nextNode
    }
  }
}
