/*
 * @ (#) Exer04.java     1.0   8/26/2023
 *
 * Copyright (c) 2023 IUH. All right reserved
 */

package CalculateElectricMoneyTest.src.main.iuh.fit.se;

import java.util.InputMismatchException;

/*
 * @description:
 * @author: Nguyen Do Xuan Truong
 * @date: 8/26/2023
 * @version:   1.0
 */
public class Exer04 {

    public static int getTienDien(int chiSoCu, int chiSoMoi){

        if (chiSoMoi < chiSoCu || chiSoCu < 0 || chiSoMoi < 0)
            throw new InputMismatchException("Cannot calculate the electric money!");

        final double THUE = 0.1; // Thuế VAT

        int soKWh = chiSoMoi - chiSoCu; // Số kWh tiêu thụ
        int tienDien = getSoKWh(soKWh, 400, Integer.MAX_VALUE) * 3015
                + getSoKWh(soKWh, 300, 400) * 2919
                + getSoKWh(soKWh, 200, 300) * 2612
                + getSoKWh(soKWh, 100, 200) * 2074
                + getSoKWh(soKWh, 50, 100) * 1786
                + getSoKWh(soKWh, 0, 50) * 1728;

        return tienDien + (int)Math.ceil(tienDien * THUE);
    }

    public static int getSoKWh(int soKWh, int soDau, int soCuoi){

        if(soKWh < soDau)
            return 0;
        if(soKWh <= soCuoi)
            return soKWh - soDau;

        return soCuoi - soDau;
    }
}
