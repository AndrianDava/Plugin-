
package com.example.randomdiamond;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public class RandomDiamond extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("RandomDiamond Plugin telah aktif!");
    }

    @Override
    public void onDisable() {
        getLogger().info("RandomDiamond Plugin telah dinonaktifkan.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("wk")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                Random random = new Random();

                // Mendapatkan jumlah diamond secara acak antara 1 dan 64
                int diamondCount = random.nextInt(64) + 1;

                // Berikan diamond kepada pemain
                ItemStack diamonds = new ItemStack(Material.DIAMOND, diamondCount);
                player.getInventory().addItem(diamonds);

                // Kirim pesan kepada pemain
                player.sendMessage(ChatColor.GREEN + "Kamu mendapatkan " + diamondCount + " diamond!");
                return true;
            } else {
                sender.sendMessage("Perintah ini hanya bisa digunakan oleh pemain!");
                return false;
            }
        }
        return false;
    }
}
