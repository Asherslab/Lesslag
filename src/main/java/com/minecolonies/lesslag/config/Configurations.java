package com.minecolonies.lesslag.config;

import net.minecraftforge.common.config.Config;
import com.minecolonies.lesslag.LesslagMod;

@Config(modid = LesslagMod.ID)
public class Configurations
{
    @Config.Comment("Whether to allow Water Animations or not")
    public static Boolean waterAnimations = true;

    @Config.Comment("Whether to allow Lava Animations or not")
    public static Boolean lavaAnimations = true;

    @Config.Comment("Whether to allow Clock and Compass Animations or not")
    public static Boolean clockAndCompassAnimations = true;
}
