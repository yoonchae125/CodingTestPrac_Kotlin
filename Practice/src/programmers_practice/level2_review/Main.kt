package programmers_practice.level2_review

import programmers_practice.level2.PriceOfStock

fun main(args: Array<String>){
//    val num1 = Country124().solution(4)
//    println(num1)

//    var skillTree = arrayOf("BACDE", "CBADF", "AECB", "BDA", "CXF", "ASF", "BDF", "CEFD")
//    //                         x       o         o      x      o      o      x      x
//    val num2 = SkillTree().solution("CBD", skillTree)
//    println(num2)

//    val progresses = intArrayOf(93, 30, 55)
//    val speeds = intArrayOf(1, 30, 5)
//    val num3 = DevelopFeature().solution(progresses, speeds)
//    printList(num3)

//    val truck_weights = intArrayOf(7,4,5,6)
//    val num4 = TruckCrossingBridge().solution(2, 10 ,truck_weights)
//    println(num4)

    val prices = intArrayOf(1, 2, 3, 2, 3)
    val num5 = PriceOfStock().solution(prices)
    printList(num5)
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