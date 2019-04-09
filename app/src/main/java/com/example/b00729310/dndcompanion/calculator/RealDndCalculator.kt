package com.example.b00729310.dndcompanion.calculator

import java.math.BigInteger
import kotlin.random.Random

/**
 * Class implements a basic calculator for now, but will
 * eventually manage adding the result of dice rolls together.
 *
 * @author Gary Moore
 */
class RealDndCalculator : DndCalculator {
    var result: BigInteger? = null
        private set

    override fun rollDice(sides: Int): Int {
        return Random.nextInt(0, sides)
    }

    override fun add(result: BigInteger, operand: BigInteger): BigInteger {
        result.add(operand)
        return result
    }

    override fun subtract(result: BigInteger, operand: BigInteger): BigInteger {
        result.subtract(operand)
        return result
    }

    override fun divide(result: BigInteger, operand: BigInteger): BigInteger {
        result.divide(operand)
        return result
    }

    override fun multiply(result: BigInteger, operand: BigInteger): BigInteger {
        result.multiply(operand)
        return result
    }

}