package com.minecolonies.lesslag.config;

import com.minecolonies.lesslag.LesslagMod;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;

@Config(modid = LesslagMod.ID)
public class Configurations
{

    private static ConfigCategory getGeneral()
    {
        return LesslagMod.getConfig().getCategory(Configuration.CATEGORY_GENERAL);
    }

    public static Boolean getAllAnimations()
    {
        return getGeneral().get("allAnimations").getBoolean();
    }

    public static Boolean getWaterAnimations()
    {
        return getGeneral().get("waterAnimations").getBoolean();
    }

    public static Boolean getLavaAnimations()
    {
        return getGeneral().get("lavaAnimations").getBoolean();
    }

    public static Boolean getClockAndCompassAnimations()
    {
        return getGeneral().get("clockAndCompassAnimations").getBoolean();
    }

    public static Boolean getPortalAnimations()
    {
        return getGeneral().get("portalAnimations").getBoolean();
    }

    public static Boolean getFireAnimations()
    {
        return getGeneral().get("fireAnimations").getBoolean();
    }

    public static Boolean getGlassAnimations()
    {
        return getGeneral().get("glassAnimations").getBoolean();
    }

    public static Boolean getGrassAnimations()
    {
        return getGeneral().get("grassAnimations").getBoolean();
    }

    public static Boolean getSnowAnimations()
    {
        return getGeneral().get("snowAnimations").getBoolean();
    }

    public static Boolean getMyceliumAnimations()
    {
        return getGeneral().get("myceliumAnimations").getBoolean();
    }
}
