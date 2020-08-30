package kakao_2020_blind

class SearchLyrics {
    fun solution(words: Array<String>, queries: Array<String>): IntArray {
        var answer = IntArray(queries.size)
        for ((idx, query) in queries.withIndex()) {
            var count = 0

            for (word in words) {
                if (query.length != word.length)
                    continue
                count += if (query[0] == '?')
                    if (compareBack(word, query)) 1 else 0
                else
                    if (compareFront(word, query)) 1 else 0
//                println("$word $query $count")
            }
            answer[idx] = count
        }
        return answer
    }

    fun compareFront(word: String, query: String): Boolean {
        var result = true
        for (i in query.indices) {
            if (query[i] == '?') break
            if (query[i] != word[i]) {
                result = false
                break
            }
        }
        return result
    }

    fun compareBack(word: String, query: String): Boolean {
        var result = true
        for (i in query.lastIndex downTo 0) {
            if (query[i] == '?') break
            if (query[i] != word[i]) {
                result = false
                break
            }
        }
        return result
    }
}