package com.me.linkedlist.model


class LinkedList<T> {
    var head: Node<T>? = null
    var tail: Node<T>? = null
    private var size = 0


    private fun isEmpty(): Boolean {
        return size == 0
    }



    override fun toString(): String {
        return if (isEmpty()) {
            "Empty list"
        } else {
            head.toString()
        }
    }

    fun push(value: T): LinkedList<T> {
        //Add value at the front of the list
        head = Node(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    fun append(value: T): LinkedList<T>{
        //Add value at the end of the list
        //1
        if(isEmpty()){
            push(value)
        }
        //2
        tail?.next = Node(value = value)
        //3
        tail = tail?.next

        size++

        return this
    }

    fun nodeAt(index: Int): Node<T>? {
        //Find particular node (at given index)
        // 1
        var currentNode = head
        var currentIndex = 0

        // 2
        while (currentNode != null && currentIndex < index-1) {
            currentNode = currentNode.next
            currentIndex++
        }

        return currentNode
    }

    fun insert(value: T, afterNode: Node<T>):Node<T>{
        //Add a value after a particular node of the list
        // 1
        if (tail == afterNode) {
            //if last item
            append(value)
          //  return tail!!
        }
        // 2
        val node = Node(value = value, next = afterNode.next)
        // 3
        afterNode.next = node
        size++
        return node
    }
}