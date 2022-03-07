package com.chizstudio.misilelaboratory.miniplugin

import com.chizstudio.misilelaboratory.miniplugin.modules.MiniPluginHandler
import org.bukkit.plugin.java.JavaPlugin

@Suppress("unused")
class MiniPlugin: JavaPlugin() {

    override fun onEnable() {
        logger.info("Miniplugin enabling")
        setupSomeSettings()
        logger.info("Miniplugin enabled")
    }

    override fun onDisable() {
        logger.info("Miniplugin disabled")
    }

    private fun setupSomeSettings() {
        server.pluginManager.registerEvents(MiniPluginHandler(), this)
    }

}