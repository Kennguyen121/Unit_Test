/*
 * @ (#) CalculateElectricMoneyTest.java     1.0   8/25/2023
 *
 * Copyright (c) 2023 IUH. All right reserved
 */

package CalculateElectricMoneyTest.src.test.java.iuh.fit.se;

import CalculateElectricMoneyTest.src.main.iuh.fit.se.CalculateElectricMoney;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * @description:
 * @author: Nguyen Do Xuan Truong
 * @date: 8/25/2023
 * @version:   1.0
 */
public class CalculateElectricMoneyTest {
    @ParameterizedTest(name = "{0} and {1} => {2}")
    @CsvSource({
        "6638, 7298, 1892110",
        "5689, 6638, 2850579",
        "5640, 5689, 93140",
        "5467, 5640, 359813",
        "5467, 5467, 0",
        "5417, 5467, 95040",
        "5366, 5417, 100195",
        "5266, 5366, 196460",
        "5165, 5266, 195552",
        "4965, 5165, 421410",
        "4764, 4965, 424284",
        "4263, 4563, 708730",
        "3962, 4263, 711941",
        "3562, 3962, 1029820",
        "-100, -50, 95040"
    })

    void testGetTotalMoney(int a, int b, int expected) {
        int actual = CalculateElectricMoney.getTotalMoney(a, b);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetTotalMoneyException() {
        Exception exception = Assertions.assertThrows(InputMismatchException.class,
                () -> CalculateElectricMoney.getTotalMoney(432, 0));

        String expected = "Cannot calculate the electric money!";
        assertEquals(expected, exception.getMessage());
    }
}
