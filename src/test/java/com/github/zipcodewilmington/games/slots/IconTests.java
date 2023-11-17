package com.github.zipcodewilmington.games.slots;

import com.github.zipcodewilmington.casino.games.slots.Icon;
import org.junit.Assert;
import org.junit.Test;

public class IconTests {

    @Test
    public void testGetMultiplier(){
        Assert.assertEquals(10, Icon.SEVEN.getMultiplier());
        Assert.assertEquals(8, Icon.BELL.getMultiplier());
        Assert.assertEquals(6, Icon.BAR.getMultiplier());
        Assert.assertEquals(3, Icon.LEMON.getMultiplier());
        Assert.assertEquals(2, Icon.CHERRY.getMultiplier());
    }
}
