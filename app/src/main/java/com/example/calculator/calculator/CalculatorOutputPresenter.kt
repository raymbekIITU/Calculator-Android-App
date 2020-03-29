package com.example.calculator.calculator

import bsh.Interpreter
import java.lang.Exception

object CalculatorOutputPresenter {

    // Current attached view
    private var mmView: CalculatorOutputInterfaceVIew? = null

    // Current equation
    private var mmCurrentEquation: String = ""

    // Current outcome
    private var mmCurrentOutcome: String = ""

    // Interpreter
    private val mmInterpreter = Interpreter()

    fun attach(view: CalculatorOutputInterfaceVIew) {
        mmView = view
    }

    fun detach() {
        mmView = null
    }

    fun add(item: String) {
        mmCurrentEquation = mmCurrentEquation.plus(item)
        updateEquation()
        calculateOutcome()
        updateOutcome()
    }

    fun remove() {
        if (mmCurrentEquation.length > 1) {
            mmCurrentEquation = mmCurrentEquation.substring(0, mmCurrentEquation.length - 1)
        } else {
            mmCurrentEquation = ""
        }

        updateEquation()
        calculateOutcome()
        updateOutcome()
    }

    fun solve() {
        if (mmCurrentOutcome.isNotEmpty()) {
            mmCurrentEquation = mmCurrentOutcome
            mmCurrentOutcome = ""
        }

        updateEquation()
        updateOutcome()
    }

    fun clear() {
        mmCurrentEquation = ""
        mmCurrentOutcome = ""

        updateEquation()
        updateOutcome()
    }

    private fun calculateOutcome() {
        if (mmCurrentEquation.isNotEmpty()) {
            try {
                mmInterpreter.eval("result = $mmCurrentEquation")
                val result = mmInterpreter.get("result")

                if (result != null && result is Int) {
                    mmCurrentOutcome = result.toString()
                }
            } catch (e: Exception) {
                mmCurrentOutcome = ""
            }
        } else {
            mmCurrentOutcome = ""
        }


    }

    private fun updateEquation() {
        mmView?.setEquation(mmCurrentEquation)
    }

    private fun updateOutcome() {
        mmView?.setOutcome(mmCurrentOutcome)
    }

}