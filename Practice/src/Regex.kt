fun main(args:Array<String>){
    val regex = """\([A-Z]\w+\)""".toRegex()
    val input = "(Apple) (Hello)"
    val matchResult : MatchResult? = regex.matchEntire(input)
    val matchResult2 : MatchResult? = regex.find(input)
    val matchResult3 : Sequence<MatchResult> = regex.findAll(input)

    println(matchResult?.value)
    println(matchResult2?.groupValues?.size)
    val it = matchResult3.iterator()
    while (it.hasNext()){
        val result = it.next()
        println(result.value)
    }
//    println(matchResult3.va)

}