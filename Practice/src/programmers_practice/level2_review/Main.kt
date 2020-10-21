package programmers_practice.level2_review

fun main(args: Array<String>){
//    val num1 = Country124().solution(4)
//    println(num1)

    var skillTree = arrayOf("BACDE", "CBADF", "AECB", "BDA", "CXF", "ASF", "BDF", "CEFD")
    //                         x       o         o      x      o      o      x      x
    val num2 = SkillTree().solution("CBD", skillTree)
    println(num2)
}