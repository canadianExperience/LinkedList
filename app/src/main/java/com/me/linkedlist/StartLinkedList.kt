package com.me.linkedlist

import android.util.Log
import com.me.linkedlist.model.LinkedList
import com.me.linkedlist.model.Node
import com.me.linkedlist.model.TAG
import com.me.linkedlist.model.recursiveStr


fun linkedListExample(){

    javaLinkedList()

    // A linked list is a collection of values arranged in a linear, unidirectional sequence.
    // Benefits:
    //  Constant time insertion and removal from the front of the list.
    //  Reliable performance characteristics.

    //Linked List - is a chain of nodes and refs. Each node contains value and ref to the nex node.
    // When ref = null - end the linked list.

//    val node1 = Node(value = 1)
//    val node2 = Node(value = 2)
//    val node3 = Node(value = 3)
//    val node4 = Node(value = 4)
//    val node5 = Node(value = 5)
//
//    node1.next = node2 //head
//    node2.next = node3
//    node3.next = node4
//    node4.next = node5
//    node5.next = null //tail


    val linkedList = LinkedList<Int>()

//    for(i in 5 downTo 1){
//        linkedList.push(i)
//    }
    //Or

    linkedList
        //Add value at the front of the list
        .push(5)
        .push(4)
        .push(3)
        .push(2)
        .push(1)
        //Add value at the end of the list
        .append(6)

    Log.d(TAG, "Initial linked list: ${linkedList.toString()}")

    //Insert new Node to position = 3, node value = 77
    val node = linkedList.nodeAt(3)
    linkedList.insert(77, node!!)

    Log.d(TAG, "Insert node 77 to position = 3:  ${linkedList.toString()}")

    //Reversing
    iterativeReverse(linkedList)
    recursiveReverse(linkedList)

    val headRemoved = linkedList.pop()
    Log.d(TAG, "Node $headRemoved at head removed:  ${linkedList.toString()}")

    val tailRemoved = linkedList.removeLast()
    Log.d(TAG, "Node $tailRemoved at tail removed:  ${linkedList.toString()}")

    //Remove node at index 2
    val n = linkedList.nodeAt(2)
    val removedNode = linkedList.removeAfter(n!!)
    Log.d(TAG, "Remove node $removedNode at position = 2:  ${linkedList.toString()}")
}


private fun javaLinkedList(){
    val list = java.util.LinkedList<Int>()
    list.add(10)
    list.add(20)
    list.add(30)

    Log.d(TAG, "Java linked list:  ${list.joinToString(" -> ")}")

    val iterator = list.descendingIterator()
    val newList = java.util.LinkedList<Int>()
    while (iterator.hasNext()) {
        newList.add(iterator.next())
    }

    Log.d(TAG, "Reversed java linked list:  ${newList.joinToString(" -> ")}")
}

private fun iterativeReverse(linkedList: LinkedList<Int>){
    // 1    -> 2    -> 3   -> null
    // prev -> curr -> next

    var currentNode: Node<Int>? = linkedList.head
    var prevNode: Node<Int>? = null

    val newLinkedList = LinkedList<Int>()

    while (currentNode != null){
        // Move from 1 to the end of the list
        val nextNode = currentNode.next // 2
        prevNode = currentNode // 1
        currentNode = nextNode // 2

        newLinkedList.push(prevNode.value)
    }

    Log.d(TAG, "Reverse with iteration:  ${newLinkedList.toString()}")
}

private fun recursiveReverse(linkedList: LinkedList<Int>){
    val head = linkedList.head
    head?.printInReverse()
    Log.d(TAG, "Reverse with recursion:  $recursiveStr")
}