package me.teach.lopamoko.TeachMe.course.theme.lesson.block;

import org.springframework.stereotype.Component;

@Component
public class BlockToBlockDataTransferObjectConverter {
    public BlockDataTransferObject convert(Block block) {
        BlockDataTransferObject blockDataTransferObject = new BlockDataTransferObject();
        blockDataTransferObject.setBlockData(block.getBlockData());
        blockDataTransferObject.setBlockId(block.getBlockId());
        blockDataTransferObject.setBlockPosition(block.getBlockPosition());
        blockDataTransferObject.setBlockType(block.getBlockType());
        return blockDataTransferObject;
    }
}
