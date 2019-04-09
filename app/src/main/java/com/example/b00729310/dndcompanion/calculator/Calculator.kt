package com.example.b00729310.dndcompanion.calculator

import java.math.BigInteger

/**
 * Interface for a basic calculator
 *
 * @author Gary Moore
 */
interface Calculator {
    fun add(result: BigInteger, operand: BigInteger): BigInteger
    fun subtract(result: BigInteger, operand: BigInteger): BigInteger
    fun divide(result: BigInteger, operand: BigInteger): BigInteger
    fun multiply(result: BigInteger, operand: BigInteger): BigInteger
}
