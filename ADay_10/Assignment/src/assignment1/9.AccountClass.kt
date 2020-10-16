package assignment1

/*
9. Create a class called Account with acctid,Acct_type,name with primary constructor.
Create 5 instance to Account class to display each ones details.
 */
class Account(acctid: Int = 0, Acc_type: String = "Savings", name: String = "John Doe") {
    var acctid: Int = 0
    var Acc_type: String = "Savings"
    var name: String = "John Doe"

    init {
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
    val a = ArrayList<Account>()
    a.add(Account(1, "Current", "Rashwin"))
    a.add(Account(2, name = "Raksha"))
    a.add(Account(3, "Current", "Rakshi"))
    a.add(Account(4, "Savings", "Rashmi"))
    a.add(Account())
    for (i: Account in a) {
        i.display()
    }
}