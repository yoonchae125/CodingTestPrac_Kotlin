package kakao_2019_blind

fun main(args: Array<String>) {
//    val record = arrayOf("Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan")
//    val num1 = OpenChatting().solution(record)
//    printList(num1)

//    val stages = intArrayOf(4,4,4,4,4)
//    val num2 = FailRatio().solution(4, stages)
//    printList(num2)

//    val relation = arrayOf(arrayOf("100","ryan","music","2"),
//            arrayOf("200","apeach","math","2"),
//            arrayOf("300","tube","computer","3"),
//            arrayOf("400","con","computer","4"),
//            arrayOf("500","muzi","music","3"),
//            arrayOf("600","apeach","music","2"))
//    val num3 = CandidateKey().solution(relation)
//    println(num3)

//    val food_times = intArrayOf(4,2,3,6,7,1,5,8)
////    val num4 = Mukbang().solution(food_times,4)
//    val num4 = Mukbang2().solution(food_times,27)
//    println(num4)
    val nodeInfo = arrayOf(intArrayOf(5,3),intArrayOf(11,5),intArrayOf(13,3), intArrayOf(3,5),intArrayOf(6,1),intArrayOf(1,3),intArrayOf(8,6),intArrayOf(7,2),intArrayOf(2,2))
    val num5 = FindPath().solution(nodeInfo)
    num5.forEach {
        printList(it)
    }
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