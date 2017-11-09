package com.minecolonies.lesslag.transformers;

import com.minecolonies.lesslag.core.asm.AsmHook;
import com.minecolonies.lesslag.core.asm.SmithsCoreClassTransformer;
import com.minecolonies.lesslag.core.mappings.McpFieldMapping;
import com.minecolonies.lesslag.core.mappings.McpMethodMapping;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.VarInsnNode;

import javax.annotation.Nonnull;

import static org.objectweb.asm.Opcodes.*;

public class TextureMapTransformer extends SmithsCoreClassTransformer
{
    private static final String CST_UPDATE_ANIMATIONS_MCPNAME    = "updateAnimations";
    private static final String CST_UPDATE_ANIMATIONS_SRGNAME    = "func_94248_c";
    private static final String CST_UPDATE_ANIMATIONS_OWNER      = "net.minecraft.client.renderer.texture.TextureMap";
    private static final String CST_UPDATE_ANIMATIONS_DESCRIPTOR = "()V";

    private static final McpMethodMapping CST_UPDATE_ANIMATIONS_MAPPING = new McpMethodMapping(
                                                                                                CST_UPDATE_ANIMATIONS_MCPNAME,
                                                                                                CST_UPDATE_ANIMATIONS_SRGNAME,
                                                                                                CST_UPDATE_ANIMATIONS_OWNER,
                                                                                                CST_UPDATE_ANIMATIONS_DESCRIPTOR
    );

    private static final String CST_BIND_TEXTURE_MCPNAME    = "bindTexture";
    private static final String CST_BIND_TEXTURE_SRGNAME    = "func_94277_a";
    private static final String CST_BIND_TEXTURE_OWNER      = "net.minecraft.client.renderer.texture.TextureUtil";
    private static final String CST_BIND_TEXTURE_DESCRIPTOR = "(I)V";

    private static final McpMethodMapping CST_BIND_TEXTURE = new McpMethodMapping(
                                                                                   CST_BIND_TEXTURE_MCPNAME,
                                                                                   CST_BIND_TEXTURE_SRGNAME,
                                                                                   CST_BIND_TEXTURE_OWNER,
                                                                                   CST_BIND_TEXTURE_DESCRIPTOR
    );

    private static final String CST_LIST_ANIMATED_SPRITES_MCPNAME    = "listAnimatedSprites";
    private static final String CST_LIST_ANIMATED_SPRITES_SRGNAME    = "field_94258_i";
    private static final String CST_LIST_ANIMATED_SPRITES_OWNER      = "net.minecraft.client.renderer.texture.TextureMap";
    private static final String CST_LIST_ANIMATED_SPRITES_DESCRIPTOR = "Ljava/util/List;";

    private static final McpFieldMapping CST_LIST_ANIMATED_SPRITES_MAPPING = new McpFieldMapping(
                                                                                                  CST_LIST_ANIMATED_SPRITES_MCPNAME,
                                                                                                  CST_LIST_ANIMATED_SPRITES_SRGNAME,
                                                                                                  CST_LIST_ANIMATED_SPRITES_OWNER,
                                                                                                  CST_LIST_ANIMATED_SPRITES_DESCRIPTOR
    );

    private static final String CST_TEXTURE_HOOK_OWNER      = "com/minecolonies/lesslag/core/hooks/TextureMapHook";
    private static final String CST_TEXTURE_HOOK_METHOD     = "updateAnimations";
    private static final String CST_TEXTURE_HOOK_DESCRIPTOR = "(Ljava/util/List;)V";

    private static final MethodInsnNode CST_TEXTURE_HOOK_INSN = new MethodInsnNode(
                                                                                    INVOKESTATIC,
                                                                                    CST_TEXTURE_HOOK_OWNER,
                                                                                    CST_TEXTURE_HOOK_METHOD,
                                                                                    CST_TEXTURE_HOOK_DESCRIPTOR,
                                                                                    false
    );

    /**
     * Method used to register the ASM Hooks that are required for this transformer.
     */
    @Override
    public void registerHooks()
    {
        register(getTextureCollectedAsmHook());
    }

    /**
     * Method used to get the ASMHook used to transform the TextureMap so it calls the Texture
     * Collected Hook.
     *
     * @return The asm hook.
     */
    private AsmHook getTextureCollectedAsmHook()
    {
        //-Dfml.coreMods.load=LesslagCorePlugin
        @Nonnull AsmHook hook = new AsmHook(CST_UPDATE_ANIMATIONS_MAPPING);

        InsnList insertionList = new InsnList();
        insertionList.add(new VarInsnNode(ALOAD, 0));
        insertionList.add(CST_LIST_ANIMATED_SPRITES_MAPPING.getInsnNode(GETFIELD));
        insertionList.add(CST_TEXTURE_HOOK_INSN);
        insertionList.add(new InsnNode(RETURN));

        InsnList matchingList = new InsnList();
        matchingList.add(CST_BIND_TEXTURE.getInsnNode(INVOKESTATIC));

        hook.jumpAfter(matchingList).insert(insertionList);

        return hook;
    }
}
