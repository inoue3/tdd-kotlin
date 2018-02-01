/**
 * @author inoue on 2018/01/20.
 */
data class Money(val amount: Int, val currency: String): Expression {

    fun times(multiplier: Int): Money {
        return Money(this.amount * multiplier, currency)
    }
    fun currency(): String {
        return currency
    }
    fun plus(money: Money): Sum {
        return Sum(this, money)
    }

    companion object {
        fun dollar(amount: Int) : Money {
            return Money(amount, "USD")
        }

        fun franc(amount: Int) : Money {
            return Money(amount, "CHF")
        }
    }
}