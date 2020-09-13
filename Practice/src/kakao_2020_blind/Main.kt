package kakao_2020_blind

fun main(args: Array<String>) {
//    val num1 = StringShorttening().solution("a")
//    println(num1)

//    val num2 = Gualho().solution("()))((()")
//    println("ans : $num2")

//    val key = arrayOf(intArrayOf(0,0,0),intArrayOf(1,0,0),intArrayOf(0,1,1))
//    val lock = arrayOf(intArrayOf(1,1,1),intArrayOf(1,1,0),intArrayOf(1,0,1))
//    val num3 = LockAndKey().solution(key, lock)
//    println("ans : $num3")

//    val words = arrayOf("frodo", "front", "frost", "frozen", "frame", "kakao")
//    val queries = arrayOf("fro??", "????o", "fr???", "fro???", "pro?")
//    val num4 = SearchLyrics().solution(words, queries)
//    num4.forEach {
//        print("$it, ")
//    }
    val n = 5
    val build_frame = arrayOf(intArrayOf(1,0,0,1), intArrayOf(1,1,1,1), intArrayOf(2,1,0,1),
            intArrayOf(2,2,1,1), intArrayOf(5,0,0,1), intArrayOf(5,1,0,1), intArrayOf(4,2,1,1), intArrayOf(3,2,1,1))

    val num5 = ColumnAndRow().solution(n, build_frame)
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