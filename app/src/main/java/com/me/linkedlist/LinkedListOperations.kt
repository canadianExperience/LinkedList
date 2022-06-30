package com.me.linkedlist

import android.util.Log
import com.me.linkedlist.model.LinkedList
import com.me.linkedlist.model.Node

const val LINKED_LIST_TAG = "LINKED_LIST"

fun linkedListOperations(){
    reverseListIterative()

    val list = LinkedList(Node(1, Node(2, Node(3, Node(4, Node(5, null))))))
    val reversed = reverseListRecursive(list.head)
    Log.d(LINKED_LIST_TAG, "Reverse list recursive: ${reversed.toString()}")

    addLastNode()
    addFirstNode()
    addNodeToPosition()

    deleteLastNode()
    deleteFirstNode()
    deleteNodeAtPosition()
}
//        val tail = Node(4, null)
//        val node3 = Node(3, tail)
//        val node2 = Node(2, node3)
//        val node1 = Node(1, node2) // head
//        val list = LinkedList(node1)


// 1 -> 2 -> 3 -> 4 -> 5

private fun reverseListIterative(){
    val list = LinkedList(
        Node(1, Node(2, Node(3, Node(4, Node(5, null)))))
    )

    var current = list.head
    var previous: Node? = null

    while (current != null){
        val next = current.next
        current.next = previous
        previous = current
        current = next
    }

    list.head = previous

    Log.d(LINKED_LIST_TAG, "Reverse list iterative: ${list.head.toString()}")
}

private fun reverseListRecursive(current: Node?) : Node?{
    if(current == null) return null
    if(current.next == null) return current

    val next = current.next
    current.next = null

    val reverse = reverseListRecursive(next)
    next?.next = current

    return reverse
}

private fun addLastNode(){
    val list = LinkedList(
        Node(1, Node(2, Node(3, Node(4, Node(5, null)))))
    )

    var current = list.head
    val size = linkedListSize(list)
    var i = 0
    while (current != null && i < (size - 1)){
        current = current.next
        i += 1
    }

    val afterNode = current
    val newNode = Node(8, null)
    afterNode?.next = newNode

    Log.d(LINKED_LIST_TAG, "Add Node To The End: ${list.head.toString()}")
}

private fun addFirstNode(){
    val list = LinkedList(
        Node(1, Node(2, Node(3, Node(4, Node(5, null)))))
    )

    val firstNode = Node(8, list.head)
    list.head = firstNode

    Log.d(LINKED_LIST_TAG, "Add First Node: ${list.head.toString()}")
}

private fun addNodeToPosition(){
    val list = LinkedList(
        Node(1, Node(2, Node(3, Node(4, Node(5, null)))))
    )

    //Add node with value = 8 to position 3
    val position = 3
    var size = linkedListSize(list)

    if(size > 0 && position > 0 && position < (size-1)){
        var current = list.head
        var i = 0

        while(current != null && i < (position - 1)){
            current = current.next
            i += 1
        }

        val newNode = Node(8, current?.next)
        current?.next = newNode


        Log.d(LINKED_LIST_TAG, "Add Node to position 3 -> 4: ${list.head.toString()}")
    }
}

private fun deleteLastNode(){
    val list = LinkedList(
        Node(1, Node(2, Node(3, Node(4, Node(5, null)))))
    )

    val size = linkedListSize(list)
    var current = list.head
    var i = 0
    while (current != null && i<(size - 2)){
        current = current.next
        i += 1
    }

    current?.next = null

    Log.d(LINKED_LIST_TAG, "Delete last node: ${list.head.toString()}")

}

private fun deleteFirstNode(){
    val list = LinkedList(
        Node(1, Node(2, Node(3, Node(4, Node(5, null)))))
    )

    list.head = list.head?.next


    Log.d(LINKED_LIST_TAG, "Delete first node: ${list.head.toString()}")

}

private fun deleteNodeAtPosition(){
    val list = LinkedList(
        Node(1, Node(2, Node(3, Node(4, Node(5, null)))))
    )

    //Add node with value = 8 to position 3
    val position = 2
    var size = linkedListSize(list)


    when{
        (position == 0) -> deleteFirstNode()
        (position == (size - 1)) -> deleteLastNode()
        (position > 0 || position > (size - 1)) -> {
            var i = 0
            var current = list.head
            while (i < (position - 1)){
                current = current?.next
                i += 1
            }
            current?.next = current?.next?.next
        }
    }

    Log.d(LINKED_LIST_TAG, "Delete Node at position $position: ${list.head.toString()}")
}

private fun linkedListSize(list: LinkedList): Int{
    var current = list.head
    var size = 0
    while (current != null){
        current = current.next
        size += 1
    }

    return size
}
