package util

/**
 * triat Observable.
 * defines 1-n dependency between objects
 * when object changes, all dependants are notified and updated
 * @author Ying-Ling Dang
 *         Rebecca Braun
 */

trait Observer {

  /**
   * updates dependants of object
   * @return true if update is possible, else return false
   */
  def update:Boolean
}

class Observable {
  var subscribers:Vector[Observer] = Vector()
  def add(s:Observer):Unit = subscribers=subscribers:+s
  def remove(s:Observer):Unit = subscribers=subscribers.filterNot(o=>o==s)
  def notifyObservers():Unit = subscribers.foreach(o=>o.update)
}
