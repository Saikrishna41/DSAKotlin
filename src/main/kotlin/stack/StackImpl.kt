package stack

class StackImpl<T : Any> : Stack<T> {

    private var storage = mutableListOf<T>()

    override val count: Int
        get() = storage.size

    override fun pop(): T? {
        return storage.removeLastOrNull()
    }

    override fun push(element: T) {
       storage.add(element)
    }

    override fun peek(): T? {
       return storage.lastOrNull()
    }

}

fun String.isValidParanthesis() : Boolean {
    val stack = StackImpl<Char>()

    for (c in this) {
       when(c) {
           '(' -> {
                stack.push(c)
           }
           ')' -> {
               if (stack.isEmpty) {
                   return false
               }
               else {
                   stack.pop()
               }
           }
       }
     }
    return stack.count == 0
}

fun main() {
    val str = "(())())"
    println("isvalid ? --- ${str.isValidParanthesis()}")
}