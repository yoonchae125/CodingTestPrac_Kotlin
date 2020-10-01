package NAVER2020


fun main(args: Array<String>) {
//    val num1 = Num1().solution("acbbdc", "abc")
//    println(num1)

//    val blocks = arrayOf(intArrayOf(0, 50), intArrayOf(0, 22), intArrayOf(2, 10),
//            intArrayOf(1, 4), intArrayOf(4, -13));
//    val num2 = Num2().solution(blocks)
//    printList(num2)

    val edges = arrayOf(intArrayOf(0, 1),intArrayOf(0, 2), intArrayOf(0, 3),
            intArrayOf(1, 4), intArrayOf(1, 5), intArrayOf(2, 6), intArrayOf(3, 7), intArrayOf(3, 8),
            intArrayOf(3, 9), intArrayOf(4, 10), intArrayOf(4, 11), intArrayOf(5, 12), intArrayOf(5, 13),
            intArrayOf(6, 14), intArrayOf(6, 15), intArrayOf(6, 16), intArrayOf(8, 17), intArrayOf(8, 1))
    val num3 = Num3().solution(19,edges)
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