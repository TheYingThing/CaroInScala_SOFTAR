package caro.util

trait Observer {
  def update
}

class Observable {
  var subscribers:Vector[Observer] = Vector()
  def add(s:Observer) = subscribers=subscribers:+s
  def remove(s:Observer) = subscribers=subscribers.filterNot(o=>0==s)
  def notifyObservers = subscribers.foreach(o=>o.update)
}
