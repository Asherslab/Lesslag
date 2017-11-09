package com.minecolonies.lesslag.core.hooks;

import com.minecolonies.lesslag.util.TextureUtils;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * Hook Class for the TextureMap.
 */
public class TextureMapHook
{
    @SideOnly(Side.CLIENT)
    public static void updateAnimations(final List<TextureAtlasSprite> sprites)
    {
        for (final TextureAtlasSprite sprite : sprites)
        {
            if (TextureUtils.letLoad(sprite))
            {
                sprite.updateAnimation();
            }
        }
    }
}
