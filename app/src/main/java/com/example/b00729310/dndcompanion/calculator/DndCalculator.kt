package com.example.b00729310.dndcompanion.calculator

/**
 * Interface for a dungeons and dragons dice rolling calculator
 *
 * @author Gary Moore
 */
interface DndCalculator : Calculator {
    fun rollDice(sides: Int): Int
}
