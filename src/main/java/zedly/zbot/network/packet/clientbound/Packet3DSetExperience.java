/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zedly.zbot.network.packet.clientbound;

import java.io.IOException;
import zedly.zbot.network.ExtendedDataInputStream;

/**
 *
 * @author Dennis
 */
public class Packet3DSetExperience implements ClientBoundPacket {
    private float experienceBar;
    private int level;
    private int totalExperience;

    @Override
    public void readPacket(ExtendedDataInputStream dis, int packetLen) throws IOException {
        experienceBar = dis.readFloat();
        level = dis.readVarInt();
        totalExperience = dis.readVarInt();
    }

}
