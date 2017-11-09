package com.minecolonies.lesslag.util;

import com.minecolonies.lesslag.config.Configurations;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TextureUtils
{

    public static final String BLOCKS = "minecraft:blocks/";
    public static final String ITEMS  = "minecraft:items/";

    public static final String GRASS_TOP          = BLOCKS + "grass_top";
    public static final String GRASS_SIDE         = BLOCKS + "grass_side";
    public static final String GRASS_SIDE_OVERLAY = BLOCKS + "grass_side_overlay";
    public static final String SNOW               = BLOCKS + "snow";
    public static final String GRASS_SIDE_SNOWED  = BLOCKS + "grass_side_snowed";
    public static final String MYCELIUM_SIDE      = BLOCKS + "mycelium_side";
    public static final String MYCELIUM_TOP       = BLOCKS + "mycelium_top";
    public static final String WATER_STILL        = BLOCKS + "water_still";
    public static final String WATER_FLOW         = BLOCKS + "water_flow";
    public static final String LAVA_STILL         = BLOCKS + "lava_still";
    public static final String LAVA_FLOW          = BLOCKS + "lava_flow";
    public static final String PORTAL             = BLOCKS + "portal";
    public static final String FIRE_LAYER_0       = BLOCKS + "fire_layer_0";
    public static final String FIRE_LAYER_1       = BLOCKS + "fire_layer_1";
    public static final String GLASS              = BLOCKS + "glass";
    public static final String GLASS_PANE_TOP     = BLOCKS + "glass_panel_top";
    public static final String COMPASS            = ITEMS + "compass";
    public static final String CLOCK              = ITEMS + "clock";

    @SideOnly(Side.CLIENT)
    public static boolean letLoad(final TextureAtlasSprite sprite)
    {
        TextureMap texturemap = getTextureMapBlocks();

        if (Configurations.getAllAnimations())
        {
            return true;
        }

        if (Configurations.getWaterAnimations() && (sprite == texturemap.getAtlasSprite(WATER_FLOW)
                                                      || sprite == texturemap.getAtlasSprite(WATER_STILL)))
        {
            return true;
        }

        if (Configurations.getLavaAnimations() && (sprite == texturemap.getAtlasSprite(LAVA_FLOW)
                                                     || sprite == texturemap.getAtlasSprite(LAVA_STILL)))
        {
            return true;
        }

        if (Configurations.getClockAndCompassAnimations() && (sprite == texturemap.getAtlasSprite(CLOCK)
                                                                || sprite == texturemap.getAtlasSprite(COMPASS)))
        {
            return true;
        }

        if (Configurations.getPortalAnimations() && (sprite == texturemap.getAtlasSprite(PORTAL)))
        {
            return true;
        }

        if (Configurations.getFireAnimations() && (sprite == texturemap.getAtlasSprite(FIRE_LAYER_0)
                                                     || sprite == texturemap.getAtlasSprite(FIRE_LAYER_1)))
        {
            return true;
        }

        if (Configurations.getGlassAnimations() && (sprite == texturemap.getAtlasSprite(GLASS)
                                                      || sprite == texturemap.getAtlasSprite(GLASS_PANE_TOP)))
        {
            return true;
        }

        if (Configurations.getGrassAnimations() && (sprite == texturemap.getAtlasSprite(GRASS_SIDE)
                                                      || sprite == texturemap.getAtlasSprite(GRASS_SIDE_OVERLAY)
                                                      || sprite == texturemap.getAtlasSprite(GRASS_TOP)))
        {
            return true;
        }

        if (Configurations.getSnowAnimations() && (sprite == texturemap.getAtlasSprite(SNOW)
                                                     || sprite == texturemap.getAtlasSprite(GRASS_SIDE_SNOWED)))
        {
            return true;
        }

        if (Configurations.getMyceliumAnimations() && (sprite == texturemap.getAtlasSprite(MYCELIUM_SIDE)
                                                         || sprite == texturemap.getAtlasSprite(MYCELIUM_TOP)))
        {
            return true;
        }

        return false;
    }

    @SideOnly(Side.CLIENT)
    public static TextureMap getTextureMapBlocks()
    {
        return Minecraft.getMinecraft().getTextureMapBlocks();
    }
}
