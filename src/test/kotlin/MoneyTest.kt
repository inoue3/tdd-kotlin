import org.junit.Assert
import org.junit.Test

class MoneyTest {

    @Test fun testMultiplication() {
        val five = Money.dollar(5)
        Assert.assertEquals(Money.dollar(10), five.times(2))
        Assert.assertEquals(Money.dollar(15), five.times(3))
    }

    @Test fun testEquality() {
        val dollar = Money.dollar(5)
        val dollar2 = Money.dollar(5)
        val dollar3 = Money.dollar(6)
        Assert.assertTrue(dollar.equals(dollar2))
        Assert.assertFalse(dollar.equals(dollar3))
        val franc = Money.franc(5)
        Assert.assertFalse(franc.equals(dollar))
    }

    @Test fun testCurrency() {
        Assert.assertEquals("USD", Money.dollar(1).currency())
        Assert.assertEquals("CHF", Money.franc(1).currency())
    }

    @Test fun testSimpleAddiction() {
        val five = Money.dollar(5)
        val sum = five.plus(five)
        val bank = Bank()
        val reduce = bank.reduce(sum, "USD")
        Assert.assertEquals(Money.dollar(10), reduce)
    }

    @Test fun tesPlusReturnsSum() {
        val five = Money.dollar(5)
        val result = five.plus(five)
        val sum: Sum = result
        Assert.assertEquals(five, sum.augend)
        Assert.assertEquals(five, sum.addend)
    }

    @Test fun tesReduceSum() {
        val sum = Sum(Money.dollar(3), Money.dollar(4))
        val bank = Bank()
        val result = bank.reduce(sum, "USD")
        Assert.assertEquals(Money.dollar(7), result)
    }
}

