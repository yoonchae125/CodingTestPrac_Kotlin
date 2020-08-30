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

    val words = arrayOf("frodo", "front", "frost", "frozen", "frame", "kakao")
    val queries = arrayOf("fro??", "????o", "fr???", "fro???", "pro?")
    val num4 = SearchLyrics().solution(words, queries)
    num4.forEach {
        print("$it, ")
    }
}