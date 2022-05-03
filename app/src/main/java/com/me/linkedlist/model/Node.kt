package com.me.linkedlist.model

const val TAG = "_LINKED"
var recursiveStr = ""

data class Node<T>(
    var value: T,
    var next: Node<T>? = null
){

    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }

    fun printInReverse(){
        next?.printInReverse()
        recursiveStr = "$recursiveStr ${value.toString()} ->"
    }
}
