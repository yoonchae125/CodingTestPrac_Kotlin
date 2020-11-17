package programmers_practice.level4

fun main(args: Array<String>) {
    val num1 = ThreeN().solution(4)
    println(num1)
}

fun printList(list: Array<IntArray>) {
    list.forEach {
        printList(it)
    }
    println()
}
fun printList(list: IntArray) {
    list.forEach {
        print("$it ")
    }
    println()
}

fun printList(list: Array<String>) {
    list.forEach {
        print("$it ")
    }
    println()
}

fun printList(list: List<String>) {
    list.forEach {
        print("$it ")
    }
    println()
}