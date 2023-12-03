package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidOneTimeInput() {
        Output out = new StubOutput();
        int first = 1;
        Input in = new StubInput(
                new String[] {"one", String.valueOf(first)}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(first);
    }

    @Test
    public void whenValidAtOnceInput() {
        Output out = new StubOutput();
        int first = 1;
        Input in = new StubInput(
                new String[] {String.valueOf(first)}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(first);
    }

    @Test
    public void whenValidSeveralTimesInRowInput() {
        Output out = new StubOutput();
        int first = 1;
        int second = 2;
        int third = 3;
        Input in = new StubInput(
                new String[] {
                        String.valueOf(first),
                        String.valueOf(second),
                        String.valueOf(third)
                }
        );
        ValidateInput input = new ValidateInput(out, in);
        int firstNumber = input.askInt("Enter menu:");
        int secondNumber = input.askInt("Enter menu:");
        int thirdNumber = input.askInt("Enter menu:");
        assertThat(firstNumber).isEqualTo(first);
        assertThat(secondNumber).isEqualTo(second);
        assertThat(thirdNumber).isEqualTo(third);
    }

    @Test
    public void whenInvalidValueWontThrowException() {
        Output out = new StubOutput();
        int first = -2;
        Input in = new StubInput(
                new String[] {
                        String.valueOf(first)
                }
        );
        ValidateInput input = new ValidateInput(out, in);
        int firstNumber = input.askInt("Enter menu:");
        assertThat(firstNumber).isEqualTo(first);
    }
}