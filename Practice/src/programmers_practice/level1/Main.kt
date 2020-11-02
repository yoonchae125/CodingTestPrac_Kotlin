package programmers_practice.level1


fun main(args: Array<String>) {
    val num1 = DartGame().solution("1S2D*3T")
    println(num1)
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