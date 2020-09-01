package observer_pattern

abstract class Subject {
    private val observers = ArrayList<Observer>()
    fun attach(observer: Observer){
        observers.add(observer)
    }
    fun detach(observer: Observer){
        observers.remove(observer)
    }
    fun notifyObservers(){
        observers.forEach { it.update() }
    }
}