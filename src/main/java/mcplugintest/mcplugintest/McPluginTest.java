package mcplugintest.mcplugintest;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class McPluginTest extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        // 이걸 써야 이벤트가 적용됨
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void msgWhenBreakBlock (BlockBreakEvent e) {
        Player p = e.getPlayer();
        p.sendMessage(p.getName() + "이(가) " + e.getBlock().getType() + " 블럭을 부쉈습니다.");
    }

    @EventHandler
    public void msgWhenPlaceBlock (BlockPlaceEvent e) {
        Player p = e.getPlayer();
        p.sendMessage(p.getName() + "이(가) " + e.getBlock().getType() + " 블럭을 놓았습니다.");
        // 블럭 타입이나 아이템 타입 가져오고 싶을 때 -> Material
        if (e.getBlock().getType() == Material.STONE) {
            p.sendMessage("돌 블럭을 놓았습니다.");
        }
    }

    @EventHandler
    public void msgWhenMove(PlayerMoveEvent e) {
        Player p = e.getPlayer(); // 이동한 플레이어를 가져와 변수에 담는다
        p.sendMessage("이동했습니다."); // 해당 플레이어에게 메시지를 보낸다
    }

    @EventHandler
    public void msgWhenJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.sendMessage("입장했습니다.");
    }

    @EventHandler
    public void msgWhenChat(PlayerChatEvent e) {
        Player p = e.getPlayer();
        p.sendMessage("당신의 이름은 " + p.getName() + "입니다.");
        // 발생한 채팅 이벤트에서 메시지를 가져와 "안녕"과 일치하면 "하세요." 메시지를 보냄
        if(e.getMessage().equals("안녕")) {
            p.sendMessage("하세요.");
        }
    }
}
