package programmers_practice.level2_review

import programmers_practice.level2.PriceOfStock

fun main(args: Array<String>) {
//    val num1 = Country124_2().solution(1)
//    println(num1)

//    var skillTree = arrayOf("BACDE", "CBADF", "AECB", "BDA", "CXF", "ASF", "BDF", "CEFD")
//    //                         x       o         o      x      o      o      x      x
//    val num2 = SkillTree2().solution("CBD", skillTree)
//    println(num2)

//    val progresses = intArrayOf(93, 30, 55)
//    val speeds = intArrayOf(1, 30, 5)
//    val num3 = DevelopFeature().solution(progresses, speeds)
//    printList(num3)

//    val truck_weights = intArrayOf(7,4,5,6)
//    val num4 = TruckCrossingBridge2().solution(2, 10 ,truck_weights)
//    println(num4)

//    val prices = intArrayOf(1, 2, 3, 2, 3)
//    val num5 = PriceOfStock().solution(prices)
//    printList(num5)

//    val priorities = intArrayOf(1, 1, 9, 1, 1, 1)
//    val num6 = Printer2().solution(priorities, 0)
//    println(num6)

//    val num7 = ShrinkString().solution("abcabcdede")
//    println(num7)

//    val picture = arrayOf(intArrayOf(1, 1, 1, 0), intArrayOf(1, 2, 2, 0),
//            intArrayOf(1, 0, 0, 1), intArrayOf(0, 0, 0, 1),
//            intArrayOf(0, 0, 0, 3), intArrayOf(0, 0, 0, 3))
//    val num8 = ColoringBook2().solution(6, 4, picture)
//    printList(num8)

//    val num9 = TriangleSnail().solution(5)
//    printList(num9)

//    val num10 = StockPrice().solution(intArrayOf(1, 2, 3, 2, 3))
//    printList(num10)

//    val processes = intArrayOf(95, 90, 99, 99, 80, 99)
//    val speeds = intArrayOf(1,1,1,1,1,1)
//    val num11 = DevelopFunction().solution(processes, speeds)
//    printList(num11)

//    val num12 = BiggestNumber().solution("1924",2)
//    println(num12)

//    val num13 = Hotter().solution(intArrayOf(1, 2, 3, 9, 10, 12), 7)
//    println(num13)

//    val num14 = BiggestNum().solution(intArrayOf(3, 30, 34, 5, 9))
//    println(num14)

//    val num15 = ContactList().solution(arrayOf("119", "97674223", "1195524421"))
//    println(num15)

//    val num16 = HIndex().solution(intArrayOf(3, 0, 6, 1, 5))
//    println(num16)

//    val num17 = SavingBoat().solution(intArrayOf(70, 50, 80, 50), 100)
//    println(num17)

//    val clothes = arrayOf(arrayOf("yellow_hat", "headgear"), arrayOf("blue_sunglasses", "eyewea)"),
//            arrayOf("green_turban", "headgear"))
//    val num18 = Fake().solution(clothes)
//    println(num18)

//    val num19 = Carpet().solution(10,2)
//    printList(num19)

//    val num20 = TargetNumber().solution(intArrayOf(1, 1, 1, 1, 1), 3)
//    println(num20)

    val map = arrayOf(intArrayOf(1,1,0,0),intArrayOf(1,0,0,0),
            intArrayOf(1,0,0,1),intArrayOf(1,1,1,1))
    val num21 = QuadZip().solution(map)
    printList(num21)
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