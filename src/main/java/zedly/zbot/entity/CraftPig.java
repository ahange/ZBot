/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zedly.zbot.entity;

import java.util.HashMap;
import java.util.List;
import zedly.zbot.EntityType;
import zedly.zbot.entity.Pig;
import zedly.zbot.event.Event;

/**
 *
 * @author Dennis
 */
public class CraftPig extends CraftAnimal implements Pig {

    protected boolean saddle = false;

    @Override
    public synchronized List<Event> setMeta(HashMap<Integer, EntityMeta> metaMap) {
        List<Event> list = super.setMeta(metaMap);
        if (metaMap.containsKey(13)) {
            saddle = metaMap.get(13).asBoolean();
        }
        return list;
    }

    public EntityType getType() {
        return EntityType.PIG;
    }

    @Override
    public synchronized boolean hasSaddle() {
        return saddle;
    }
}
