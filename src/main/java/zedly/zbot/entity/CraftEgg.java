/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zedly.zbot.entity;

import zedly.zbot.EntityType;
import zedly.zbot.entity.Egg;

/**
 *
 * @author Dennis
 */
public class CraftEgg extends CraftProjectile implements Egg {

    @Override
    public EntityType getType() {
        return EntityType.EGG;
    }

    @Override
    public boolean hasGravity() {
        return true;
    }
    
}
