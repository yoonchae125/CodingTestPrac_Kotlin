package programmers_practice.level3


fun main(args: Array<String>) {
//    val routes = arrayOf(intArrayOf(-20,15), intArrayOf(-14,-5), intArrayOf(-18,-13), intArrayOf(-5,-3))
//    val num1 = Camera().solution(routes)
//    println(num1)

//    val num2 = ExpressWithN().solution(5, 12)
//    println(num2)

//    val lines = arrayOf("2016-09-15 01:00:04.002 2.0s",
//    "2016-09-15 01:00:07.000 2s")
//    val num3 = ChuseokTraffic().solution(lines)
//    println(num3)

//    val triangle = arrayOf(intArrayOf(7), intArrayOf(3, 8), intArrayOf(8, 1, 0), intArrayOf(2, 7, 4, 4), intArrayOf(4, 5, 2, 6, 5))
//    val num4 = IntTriangle().solution(triangle)
//    println(num4)

//    val a = intArrayOf(9,-1,-5)
//    val num5 = Balloon().solution(a)
//    println(num5)

//    val operations = arrayOf("I 7","I 5","I -5","D -1")
//    val num6 = PriorityQueue().solution(operations)
//    printList(num6)

//    val times = intArrayOf(7,10)
//    val num7 = Epkuksimsa().solution(6, times)
//    println(num7)

    val genres = arrayOf("classic", "pop", "classic", "classic", "pop")
    val plays = intArrayOf(500, 600, 150, 800, 2500)
    val num8 = BestAlbum().solution(genres, plays)
    printList(num8)
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