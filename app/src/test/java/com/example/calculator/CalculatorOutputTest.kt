package com.example.calculator

import com.example.calculator.calculator.CalculatorOutputInterfaceVIew
import com.example.calculator.calculator.CalculatorOutputPresenter
import org.junit.Test
import org.mockito.BDDMockito.then
import org.mockito.Mockito

class CalculatorOutputTest {

    private val mmPresenter = CalculatorOutputPresenter
    private val mmMockView = Mockito.mock(CalculatorOutputInterfaceVIew::class.java)

    @Test
    fun onePlusOne () {

        // Given that the view is attached
        mmPresenter.attach(mmMockView)

        // When a number is added
        mmPresenter.add("1")

        // Then the correct equation should be set
        then(mmMockView).should().setEquation("1")

        // When an operator is added
        mmPresenter.add("+")

        // Then the correct equation should be set
        then(mmMockView).should().setEquation("1+")

        // When a num is added
        mmPresenter.add("1")

        // Then the correct equation should be set
        then(mmMockView).should().setEquation("1+1")

        // Then the correct outcome should be set
        then(mmMockView).should().setOutcome("2")

        // Clear presenter
        mmPresenter.clear()

    }

    @Test
    fun twoPlusTwoMinusOne () {

        // Given that the view is attached
        mmPresenter.attach(mmMockView)

        // When a number is added
        mmPresenter.add("2")

        // Then the correct equation should be set
        then(mmMockView).should().setEquation("2")

        // When an operator is added
        mmPresenter.add("+")

        // Then the correct equation should be set
        then(mmMockView).should().setEquation("2+")

        // When a num is added
        mmPresenter.add("2")

        // Then the correct equation should be set
        then(mmMockView).should().setEquation("2+2")

        // Then the correct outcome should be set
        then(mmMockView).should().setOutcome("4")

        // When an operator is added
        mmPresenter.add("-")

        // Then the correct equation should be set
        then(mmMockView).should().setEquation("2+2-")

        // When a number is added
        mmPresenter.add("1")

        // Then the correct equation should be set
        then(mmMockView).should().setEquation("2+2-1")

        // Then the correct outcome should be set
        then(mmMockView).should().setOutcome("3")


        // Clear presenter
        mmPresenter.clear()

    }
}