package com.example.student.calculator.main;

import com.example.student.calculator.data.Calculator;
import com.example.student.calculator.main.CalculatorPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static android.support.v7.appcompat.R.styleable.View;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

/**
 * Created by jittat on 29/3/2560.
 */

public class CalculatorPresenterTest {
    private CalculatorPresenter presenter;

    @Mock
    CalculatorView view;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Calculator calculator = new Calculator();
        presenter = new CalculatorPresenter(calculator,view);
    }

    @Test
    public void shouldShowZeroAfterReset() {
        presenter.reset();

        verify(view).setCalculatorResult(0);
    }

    @Test
    public void shouldShowSingleDigitNumber() {
        presenter.reset();
        presenter.onNumberClick(5);

        verify(view).setCalculatorResult(5);
    }

    @Test
    public void shouldShowTwoDigitNumber() {
        presenter.reset();
        presenter.onNumberClick(5);
        presenter.onNumberClick(7);

        InOrder order = inOrder(view);

        order.verify(view).setCalculatorResult(0);
        order.verify(view).setCalculatorResult(5);
        order.verify(view).setCalculatorResult(57);
    }

    @Test
    public void shouldDeleteLastDigit(){
        presenter.reset();
        presenter.onNumberClick(2);
        presenter.onNumberClick(3);
        presenter.onBackClick();
        presenter.onBackClick();

        InOrder order = inOrder(view);
        order.verify(view).setCalculatorResult(0);
        order.verify(view).setCalculatorResult(2);
        order.verify(view).setCalculatorResult(23);
        order.verify(view).setCalculatorResult(2);
        order.verify(view).setCalculatorResult(0);

    }

    @Test
    public void shouldAddTwoNumber(){
        presenter.reset();
        presenter.onNumberClick(5);
        presenter.onOpClick(presenter.OPERATOR_ADD);
        presenter.onNumberClick(3);
        presenter.onOpClick(presenter.OPERATOR_EQ);

        verify(view).setCalculatorResult(8);

    }

    @Test
    public void shouldAddThreeNumber(){
        presenter.reset();
        presenter.onNumberClick(1);
        presenter.onNumberClick(3);
        presenter.onOpClick(1);
        presenter.onNumberClick(2);
        presenter.onNumberClick(0);
        presenter.onOpClick(5);
        presenter.onOpClick(1);
        presenter.onNumberClick(2);
        presenter.onOpClick(5);

        verify(view).setCalculatorResult(35);
    }


}
