package kakao_2019_blind

class FailRatio {
    fun solution(N: Int, stages: IntArray): IntArray {

        var answer = IntArray(N)
        var ratios = mutableMapOf<Int, Float>()
        for(i in 1..N){
            ratios[i] = 0f
        }
        stages.sortDescending()

        var previous = -1
        var count = 1
        for((idx, stage) in stages.withIndex()){
            if(stage == N+1)
                continue
            if(stage != previous){
                if(previous!=N+1&&previous!=-1) {
                    val ratio = count / (idx).toFloat()
                    ratios[previous] = ratio
                }
                count = 1
                previous = stage
                continue
            }
            count++
        }
        if(previous != -1) {
            val ratio = count / (stages.size).toFloat()
            ratios[previous] = ratio
        }
        val comparator = compareByDescending<Pair<Int, Float>> {it.second}
        val pair = ratios.toList().sortedWith(comparator.thenBy { it.first })
        var idx=0
        println(pair.size)
        pair.forEach {
            answer[idx] = it.first
            idx++
            println("${it.first}, ${it.second}")
        }
        return answer
    }
}