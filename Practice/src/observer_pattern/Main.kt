package observer_pattern

fun main(args:Array<String>){
    val scoreRecord = ScoreRecord()

    val dataSheetView = DataSheetView(scoreRecord, 3)
    scoreRecord.attach(dataSheetView)
    scoreRecord.attach(MinMaxView(scoreRecord))
    for(i in 0 until 5){
        scoreRecord.addScore(i*20)
    }
}