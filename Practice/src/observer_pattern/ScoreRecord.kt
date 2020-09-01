package observer_pattern

class ScoreRecord : Subject() {
    private val scores = ArrayList<Int>()

    fun addScore(score: Int) {
        scores.add(score)
        notifyObservers()
    }

    fun getScoreRecord(): ArrayList<Int> {
        return scores
    }
}
