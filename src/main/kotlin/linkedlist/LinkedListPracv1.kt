package linkedlist

data class Nodev1<T>(
    var value: T,
    var next: Nodev1<T>? = null
) {
    override fun toString(): String {
        return if (next != null) {
            "$value ---->>> $next"
        } else {
            value.toString()
        }
    }
}

class LinkedListPracv1<T> {
    private var head: Nodev1<T>? = null
    private var tail: Nodev1<T>? = null
    private var size: Int = 0

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

    fun prepend(value: T) {
        head = Nodev1(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
    }

    fun append(value: T) {
        if (isEmpty()) {
            prepend(value)
            return
        }
        tail?.next = Nodev1(value = value)
        tail = tail?.next
        size++
    }

    fun nodeAt(index: Int): Nodev1<T>? {
        var curPos = 0
        var curNode = head
        while (curNode?.next != null && curPos < index) {
            curNode = curNode.next
            curPos++
        }
        return curNode
    }

    fun insertAfterNode(value: T, afterNode: Nodev1<T>) {
        if (tail == afterNode) {
            append(value)
            return
        }
        val newNode = Nodev1(value = value, next = afterNode.next)
        afterNode.next = newNode
        size++
    }

    fun deleteMiddleNode(): Nodev1<T>? {
        var slow = head
        var fast = head?.next?.next
        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }
        slow?.next = slow?.next?.next
        return head
    }
}

fun main() {
    val list = LinkedListPracv1<Int>()
    list.append(1)
    list.append(2)
    list.append(3)
    println(list.toString())
    list.prepend(111)
    list.prepend(222)
    println(list.toString())
    val afterNode = list.nodeAt(2)
    if (afterNode != null) {
        list.insertAfterNode(32323, afterNode = afterNode)
    }
    println(list.toString())
    val node = list.deleteMiddleNode()
    println(node.toString())
}