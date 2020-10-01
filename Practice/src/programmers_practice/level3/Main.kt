package programmers_practice.level3


fun main(args: Array<String>) {
//    val routes = arrayOf(intArrayOf(-20,15), intArrayOf(-14,-5), intArrayOf(-18,-13), intArrayOf(-5,-3))
//    val num1 = Camera().solution(routes)
//    println(num1)

    val num2 = ExpressWithN().solution(5, 12)
    println(num2)

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