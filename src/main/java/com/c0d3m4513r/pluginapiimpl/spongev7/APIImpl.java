package com.c0d3m4513r.pluginapiimpl.spongev7;

import com.c0d3m4513r.logger.Slf4jLogger;
import com.c0d3m4513r.pluginapi.API;
import com.c0d3m4513r.pluginapiimpl.spongev7.Registry.Sound;
import com.c0d3m4513r.pluginapiimpl.spongev7.Scoreboard.ObjectiveImpl;
import com.c0d3m4513r.pluginapiimpl.spongev7.Scoreboard.ScoreboardImpl;
import com.c0d3m4513r.pluginapiimpl.spongev7.commands.CommandRegistrar;
import com.c0d3m4513r.pluginapiimpl.spongev7.commands.CommandResult;
import lombok.SneakyThrows;
import lombok.val;

public class APIImpl extends API {
    @SneakyThrows
    APIImpl(Plugin plugin) {
        API.logger = new Slf4jLogger(plugin.logger);
        API.server = new Server();
        configLoader = plugin;

        API.loadMain();

        commandRegistrar = new CommandRegistrar(plugin);
        commandResult = new CommandResult();
        config.main();

        new TaskBuilder(plugin);
        val _ = ScoreboardImpl.none;
        val _1 = ObjectiveImpl.none;
        val _2 = Sound.none;


    }
}
