package util

import org.scalatest.matchers.*
import org.scalatest.wordspec.*

import scala.language.postfixOps

class ObservableSpec extends AnyWordSpec with should.Matchers :

  "An Observer" should {

    var updated:Boolean = false
    def isUpdated: Boolean = updated

    val observable = new Observable
    val observer = new Observer {
      override def update: Boolean = {updated = true; updated}
    }

    "add an Observer" in {
      observable.add(observer)
      observable.subscribers should contain(observer)
    }
    "notify an Observer" in {
      isUpdated should be (false)
      observable.notifyObservers()
      isUpdated should be (true)
    }
    "remove an Observer" in {
      observable.remove(observer)
      observable.subscribers should not contain (observer)
    }
  }
end ObservableSpec
