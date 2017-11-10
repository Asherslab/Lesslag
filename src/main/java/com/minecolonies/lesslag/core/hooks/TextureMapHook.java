package com.minecolonies.lesslag.core.hooks;

import com.minecolonies.lesslag.util.TextureUtils;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.*;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;

/**
 * Hook Class for the TextureMap.
 */
@Mixin(TextureMap.class)
public abstract class TextureMapHook extends AbstractTexture implements ITickableTextureObject
{
    @Shadow
    private @Final List<TextureAtlasSprite> listAnimatedSprites;

    /**
     * Overwrites the updateAnimations in {@link TextureMap}
     *
     * @reason This is the main point of the mod!
     * @author Asherslab
     */
    @Overwrite
    public void updateAnimations()
    {
        GlStateManager.bindTexture(this.getGlTextureId());

        for (final TextureAtlasSprite sprite : this.listAnimatedSprites)
        {
            if (TextureUtils.letLoad(sprite))
            {
                sprite.updateAnimation();
            }
        }
    }
}
