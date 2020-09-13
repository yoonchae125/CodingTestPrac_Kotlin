package programmers_challenge

class Num1 {
    fun solution(numbers: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        numbers.sort()
        for(i in numbers.indices){
            for(j in i+1 until numbers.size){
                answer = answer.plus(numbers[i]+numbers[j])
            }
        }
        val set= answer.toSet()
        return set.toIntArray().apply { sort() }
    }
}