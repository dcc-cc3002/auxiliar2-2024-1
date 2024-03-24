package person

import bank.Bank

/* Note que el nombre de una persona no es algo que varíe con el tiempo, por lo que es constante.
Sin embargo, la edad sí varía, y junto con eso, tenemos métodos que necesitan modificar la edad,
como birthday(). También, es posible omitir la necesidad de añadirle un banco a una persona en su
constructor, y en este caso, dejar que simplemente sea un atributo interno que será igual para
todas las instancias de personas que se creen. */

/** Represents a person.
 * @param name Name of the person.
 * @param age Age of the person.
 */
class Person(val name: String, var age: Int) { // (val name: String, var age: Int) es el constructor
  // de la clase, esto es, los atributos que se le asignan a una instancia de la clase al momento de
  // crearla. Sin embargo, note que el banco al que está suscrito una persona (línea 22) no es un
  // atributo que se le asigne al momento de crearla, pues podríamos decir que un banco no es
  // necesario para crear una persona, por lo que no se incluye en el constructor. Esto hará que
  // todas las personas que se creen no tengan un banco asignado, y si se desea asignar uno, se
  // puede hacer con el método bankSubscribe().

  /** Bank the person is subscribed to. */
  var bank: Bank = null

  /** Makes the person have a birthday. */
  def birthday(): Unit = {
    age += 1
  }

  /** Subscribes the person to a bank.
   * @param newBank Bank to subscribe to.
   */
  def bankSubscribe(newBank: Bank): Unit = {
    bank = newBank
    bank.addNewSubscriber(this)
  }

  /** Unsubscribes the person from a bank. */
  def bankUnsubscribe(): Unit = {
    bank.removeSubscriber(this)
    bank = null
  }
}