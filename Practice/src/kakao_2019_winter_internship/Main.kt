package kakao_2019_winter_internship

fun main(args: Array<String>) {
    val user_id = arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc")
    val banned_id = arrayOf("fr*d*", "abc1**")
    val num1=BadUser().solution(user_id, banned_id)
    print(num1)
}