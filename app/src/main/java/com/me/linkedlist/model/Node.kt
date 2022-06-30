package com.me.linkedlist.model

data class Node(
    val data: Int,
    var next: Node?
){

    override fun toString(): String {
        return if(next != null)"$data -> ${next.toString()}" else{
            "$data"
        }
    }
}
