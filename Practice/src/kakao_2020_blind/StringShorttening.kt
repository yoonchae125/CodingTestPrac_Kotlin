package kakao_2020_blind

import kotlin.math.min

class StringShorttening {
    fun solution(s: String): Int {
        var answer = 0
        if(s.length == 1)
            return 1
        val n = s.length / 2

        for (len in 1..n) {
            val tokens = ArrayList<String>()
            getToken(tokens, s, len)

            val short = shortten(tokens,len)
            answer = if(answer == 0) short else min(short, answer)
        }
        return answer
    }

    private fun getToken(tokens: ArrayList<String>, s: String, len: Int) {
        for (idx in s.indices step len) {
            val last = if (idx + len >= s.length) s.length else idx + len
            val a = s.substring(idx, last)
            tokens.add(a)
        }
    }

    private fun shortten(tokens: ArrayList<String>, len:Int):Int {
        var length = 0
        var before = tokens[0]
        var same = 1
        for (idx in 1 until tokens.size) {
            val cur = tokens[idx]

            if (before == cur) {
                same++
            } else {
                if(same==1){
                    length += len
                }else{
                    length += len + same/10 +1
                }
                same = 1
            }
            before = cur
        }
        if(same==1){
            length += tokens[tokens.lastIndex].length
        }else{
            length += len + same/10 +1
        }
        return length
    }
}
