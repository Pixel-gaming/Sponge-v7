package com.c0d3m4513r.pluginapiimpl.spongev7.commands;

import com.c0d3m4513r.pluginapi.command.Command;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CommandCallable implements org.spongepowered.api.command.CommandCallable {
    @NonNull
    @Getter
    Command command;

    @Override
    public org.spongepowered.api.command.@NonNull CommandResult process(@NonNull CommandSource source, String arguments) throws CommandException {
        try {
            return ((CommandResult)
                    command.process(
                            new com.c0d3m4513r.pluginapiimpl.spongev7.commands.CommandSource(source),
                            arguments.split(" "))
            ).getComandResult();
        } catch (com.c0d3m4513r.pluginapi.command.CommandException ce) {
            throw new CommandException(Text.of(ce.getMessage()), ce.getE());
        }
    }

    @Override
    public @NonNull List<String> getSuggestions(@NonNull CommandSource source, String arguments, @Nullable Location<World> targetPosition) throws CommandException {
        try {
            return command.getSuggestions(
                    new com.c0d3m4513r.pluginapiimpl.spongev7.commands.CommandSource(source),
                    arguments.split(" "));
        } catch (com.c0d3m4513r.pluginapi.command.CommandException ce) {
            throw new CommandException(Text.of(ce.getMessage()), ce.getE());
        }
    }

    @Override
    public boolean testPermission(@NonNull CommandSource source) {
        return true;
    }

    @Override
    public @NonNull Optional<Text> getShortDescription(@NonNull CommandSource source) {
        Optional<String> ostr = command.getShortDescription(
                new com.c0d3m4513r.pluginapiimpl.spongev7.commands.CommandSource(source)
        );
        return ostr.map(Text::of);
    }

    @Override
    public @NonNull Optional<Text> getHelp(@NonNull CommandSource source) {
        Optional<String> ostr = command.getHelp(
                new com.c0d3m4513r.pluginapiimpl.spongev7.commands.CommandSource(source)
        );
        return ostr.map(Text::of);
    }

    @Override
    public @NonNull Text getUsage(@NonNull CommandSource source) {
        return Text.of(command.getUsage(
                new com.c0d3m4513r.pluginapiimpl.spongev7.commands.CommandSource(source)
        ));
    }
}
