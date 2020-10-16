package assignment1

/*
10. Convert the program 9 using secondary constructors.
 */
class Account1 {
    var acctid: Int = 0
    var Acc_type: String = "Savings"
    var name: String = "John Doe"

    constructor(acctid: Int = 0, Acc_type: String = "Savings", name: String = "John Doe") {
        this.acctid = acctid
        this.Acc_type = Acc_type
        this.name = name
    }

    fun display() {
        println("************")
        println("Account Name $name")
        println("Account Id $acctid")
        println("Account Type $Acc_type")
        println("************")
    }
}

fun main() {
    val a = ArrayList<Account1>()
    a.add(Account1(1, "Current", "Rashwin"))
    a.add(Account1(2, name = "Raksha"))
    a.add(Account1(3, "Current", "Rakshi"))
    a.add(Account1(4, "Savings", "Rashmi"))
    a.add(Account1())
    for (i: Account1 in a) {
        i.display()
    }
}