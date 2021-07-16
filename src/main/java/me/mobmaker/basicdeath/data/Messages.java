package me.mobmaker.basicdeath.data;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.Template;
import net.kyori.adventure.text.minimessage.markdown.DiscordFlavor;
import net.kyori.adventure.text.minimessage.transformation.TransformationType;

import java.util.ArrayList;
import java.util.List;

public enum Messages {
    INVULNERABILITY_STARTED("invulnerability.started","<gray>You've died, but don't worry! You're invulnerable for the next <green><0> <gray>minutes, or until you damage something!"),
    INVULNERABILITY_CANCELLED("invulnerability.cancelled","<gray>You attacked something and<red> **LOST** invulnerability<gray>!"),
    INVULNERABILITY_ENDED("invulnerability.ended","<gray>Your invulnerability has expired, and you can now be attacked.")
    ;

    private final String key;
    private final String defaultValue;

    Messages(String key, String defaultValue) {
        this.key = key;
        this.defaultValue = defaultValue;
    }

    public Component get() {
        return mm.parse(defaultValue);
    }

    public Component get(Component... args) {
        List<Template> translate = new ArrayList<>();
        int argNum = 0;
        for (Component arg : args) {
            translate.add(Template.of(String.valueOf(argNum), arg));
            argNum++;
        }
        return mm.parse(defaultValue, translate);
    }

    private MiniMessage mm = MiniMessage.builder()
            .transformation(TransformationType.COLOR)
            .transformation(TransformationType.DECORATION)
            .markdownFlavor(DiscordFlavor.get())
            .markdown()
            .build();
}
