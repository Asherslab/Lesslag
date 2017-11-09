package com.minecolonies.lesslag.core.mappings;

import org.objectweb.asm.tree.FieldInsnNode;

/**
 * Class describing a mapping for a Method.
 */
public class McpFieldMapping extends McpMapping<FieldInsnNode>
{
    public McpFieldMapping(String mcp, String srg, String owner, String descriptor)
    {
        super(mcp, srg, owner, descriptor);
    }

    @Override
    public FieldInsnNode getInsnNode(int opcode)
    {
        return new FieldInsnNode(opcode, getOwner(), getName(), getDescriptor());
    }
}