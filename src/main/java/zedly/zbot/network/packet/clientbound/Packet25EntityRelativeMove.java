/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zedly.zbot.network.packet.clientbound;

import java.io.IOException;
import zedly.zbot.Location;
import zedly.zbot.GameContext;
import zedly.zbot.entity.CraftEntity;
import zedly.zbot.event.entity.EntityMoveEvent;
import zedly.zbot.network.ExtendedDataInputStream;

/**
 *
 * @author Dennis
 */
public class Packet25EntityRelativeMove implements ClientBoundPacket {
    private int entityId;
    private int dX;
    private int dY;
    private int dZ;
    private boolean onGround;

    @Override
    public void readPacket(ExtendedDataInputStream dis, int packetLen) throws IOException {
        entityId = dis.readVarInt();
        dX = dis.readShort();
        dY = dis.readShort();
        dZ = dis.readShort();
        onGround = dis.readBoolean();
    }
    
    public void process(GameContext context) {
        CraftEntity ent = context.getSelf().getEnvironment().getEntityById(entityId);
        if(ent != null) {
            Location oloc = ent.getLocation();
            Location loc = new Location(oloc.getX() + dX / 4096.0, oloc.getY() + dY / 4096.0, oloc.getZ() + dZ / 4096.0, oloc.getYaw(), oloc.getPitch());
            context.getMainThread().fireEvent(new EntityMoveEvent(ent, oloc, loc));
            ent.setLocation(loc);
        }
    }
}
