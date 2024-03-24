import bank.Bank
import person.Person

// Juegue con las diferentes cosas que puede realizar con este código para familiarizarse con la
// sintaxis del lenguaje.
object Main { // Para ejecutar este archivo, debe hacer click izquierdo en el icono del botón verde
  def main(args: Array[String]): Unit = {

    // Note que Bank solo necesita el nombre del banco para ser creado, a pesar de que posee un
    // atributo interno que es mutable (subscribers). Esto es porque subscribers no se declaró en el
    // constructor de la clase Bank, por lo que no es necesario asignarle un valor al momento de
    // crear una instancia de Bank.
    val bank: Bank = new Bank("Banco de Chile")

    // En cambio, Person necesita un nombre y una edad para ser creado, pero no necesita un banco
    // asignado al momento de crearse, por lo que no se incluye en el constructor. Esto hará que
    // todas las personas que se creen tengan un valor de banco por defecto (null), y si se desea
    // asignar uno, se puede hacer con el método bankSubscribe().
    val person1: Person = new Person("Juan", 20)
    val person2: Person = new Person("Pedro", 30)

    // Podemos acceder a los atributos de una instancia de una clase de esta manera:
    println(person1.name) // Juan
    println(person1.age) // 20

    println(person2.name) // Pedro
    println(person2.age) // 30

    person1.birthday() // Juan cumple años!

    println(person1.age) // 21

    person1.bankSubscribe(bank) // Juan se suscribe al banco Banco de Chile, y el banco Banco de
    // Chile agrega a Juan como suscriptor

    person2.bankSubscribe(bank) // Pedro se suscribe al banco Banco de Chile, y el banco Banco de
    // Chile agrega a Pedro como suscriptor

    person1.bankUnsubscribe()
  }
}