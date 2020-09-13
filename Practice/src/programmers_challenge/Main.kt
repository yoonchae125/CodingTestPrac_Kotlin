package programmers_challenge

fun main(args: Array<String>) {
//    val tc1 = intArrayOf(2,1,3,4,1)
//    val tc2 = intArrayOf(5,0,2,7)
//    val num1 = Num1().solution(tc1)
//    printList(num1)

    val num2 = Num2().solution(200)
    printList(num2)
}
fun printList(list: IntArray) {
    list.forEach {
        print("$it ")
    }
    println()
}