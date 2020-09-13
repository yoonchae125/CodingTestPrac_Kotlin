package kakao_2021_blind_1

fun main(args: Array<String>) {
//    val num1 = Num1().solution(".aaa..c____AAAA.bbb...,,,,.....asd..........")
//    println(num1)

//    var orders = arrayOf("XYZ", "XWY", "WXA")
//    var course = intArrayOf(2,3,4)
//    val num2 = Num2().solution(orders,course)
//    printList(num2)

//    val info = arrayOf("java backend junior pizza 150",
//            "python frontend senior chicken 210",
//            "python frontend senior chicken 150","cpp backend senior pizza 260",
//            "java backend junior chicken 80","python backend senior chicken 50")
//    val query = arrayOf("java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150")
//    val num3 = Num3().solution(info, query)
//    printList(num3)

//    val fares = arrayOf(intArrayOf(4, 1, 10), intArrayOf(3, 5, 24),
//            intArrayOf(5, 6, 2), intArrayOf(3, 1, 41), intArrayOf(5, 1, 24),
//            intArrayOf(4, 6, 50), intArrayOf(2, 4, 66), intArrayOf(2, 3, 22), intArrayOf(1, 6, 25))
//    val fares2 = arrayOf(intArrayOf(5, 7, 9), intArrayOf(4, 6, 4), intArrayOf(3, 6, 1),
//            intArrayOf(3, 2, 3), intArrayOf(2, 1, 6))
//    val fares3 = arrayOf(intArrayOf(2,6,6), intArrayOf(6,3,7), intArrayOf(4,6,7),
//            intArrayOf(6,5,11), intArrayOf(2,5,12), intArrayOf(5,3,20), intArrayOf(2,4,8), intArrayOf(4,3,9))
//    val num4 = Num4().solution(6,4,5,6,fares3)
//    println(num4)

    val play_time = "02:03:55"
    val adv_time = "00:14:15"
    val logs = arrayOf("01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30")
    val num5 = Num5().solution(play_time, adv_time, logs)
    println(num5)

    val num6 = Num6()

    val num7 = Num7()
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