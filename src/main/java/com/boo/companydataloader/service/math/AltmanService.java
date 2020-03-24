package com.boo.companydataloader.service.math;

import com.boo.companydataloader.util.math.Zone;

public class AltmanService {

    /**
     * Coefficient for calculation zone
     * K = SUM(Ai*Ti)
     **/
    private static final float A1 = 6.56f;
    private static final float A2 = 3.26f;
    private static final float A3 = 6.72f;
    private static final float A4 = 1.05f;

    public static Zone calculateAltmanZone(float t1, float t2, float t3, float t4) {
        float zoneValue = A1*t1 + A2*t2 + A3*t3 + A4*t4;

        if (zoneValue >= Zone.GREEN.getValue()) {
            return Zone.GREEN;
        } else {
            if (zoneValue >= Zone.GREY.getValue()) {
                return Zone.GREY;
            }
        }

        return Zone.RED;
    }
}
