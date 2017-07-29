package Ch2LinkedLists.datamodel

class DaveNode(var value: Int, var nextNode: DaveNode) {

  override def toString: String =
    "NODE{" + value + "}"

}
