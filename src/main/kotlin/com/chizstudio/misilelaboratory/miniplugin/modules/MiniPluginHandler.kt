package com.chizstudio.misilelaboratory.miniplugin.modules

import org.bukkit.attribute.Attribute
import org.bukkit.entity.Boss
import org.bukkit.entity.Entity
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Monster
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntitySpawnEvent

private val Double.onePercent: Double
    get() {
        return this / 100
    }

class MiniPluginHandler: Listener {

    private val eliteupamount = 107

    private fun eliteamountup(entity: Entity) {
        if (entity is LivingEntity) {
            val armorattribute = entity.getAttribute(Attribute.GENERIC_ARMOR)
            val attackattribute = entity.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE)
            val healthattribute = entity.getAttribute(Attribute.GENERIC_MAX_HEALTH)
            armorattribute?.baseValue = armorattribute!!.baseValue.onePercent * eliteupamount
            attackattribute?.baseValue = attackattribute!!.baseValue.onePercent * eliteupamount
            healthattribute?.baseValue = healthattribute!!.baseValue.onePercent * eliteupamount
        }
    }

    @EventHandler
    fun someSpawnEvent(e: EntitySpawnEvent) {
        val entity = e.entity
        if (entity is Monster) {
            if (entity is Boss) {
                if ((1..100).random() == 1) {
                    eliteamountup(entity)
                }
            }
            else {
                entity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)?.baseValue = entity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)!!.baseValue.onePercent * 140
                if ((1..100).random() <= 5) {
                    eliteamountup(entity)
                }
            }
        }

    }
}