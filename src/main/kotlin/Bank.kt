/**
 * @author inoue on 2018/01/23.
 */
class Bank {

    fun reduce(source: Expression, to: String): Money {
        if (source is Sum) {
            val amount = source.augend.amount + source.addend.amount
            return Money(amount, to)
        }
        throw IllegalAccessException()
    }
}