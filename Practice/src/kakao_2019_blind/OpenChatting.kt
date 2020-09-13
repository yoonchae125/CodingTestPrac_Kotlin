package kakao_2019_blind

class OpenChatting {
    fun solution(record: Array<String>): Array<String> {
        var answer = arrayOf<String>()

        val users = mutableMapOf<String,String>()
        record.forEach {
            val words = it.split(" ")
            if(words[0] == "Enter" || words[0] == "Change"){
                users[words[1]] = words[2]
            }
        }
        record.forEach {
            val words = it.split(" ")
            when(words[0]){
                "Enter"->{
                    answer = answer.plus("${users[words[1]]}님이 들어왔습니다.")
                }
                "Leave"->{
                    answer = answer.plus("${users[words[1]]}님이 나갔습니다.")
                }
            }
        }
        return answer
    }

}