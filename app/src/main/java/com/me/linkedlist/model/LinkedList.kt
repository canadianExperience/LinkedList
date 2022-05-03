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

    fun pop(): T? {
        //Remove at head
        if (!isEmpty()) size--
        val result = head?.value
        head = head?.next
        if (isEmpty()) {
            tail = null
        }

        return result
    }

    fun removeLast(): T? {
        // 1
        val head = head ?: return null
        // 2
        if (head.next == null) return pop()
        // 3
        size--

        // 4
        var prev = head
        var current = head

        var next = current.next
        while (next != null) {
            prev = current
            current = next
            next = current.next
        }
        // 5
        prev.next = null
        tail = prev
        return current.value
    }

    fun removeAfter(node: Node<T>): T? {
        val result = node.next?.value

        if (node.next == tail) {
            tail = node
        }

        if (node.next != null) {
            size--
        }

        node.next = node.next?.next
        return result
    }
}