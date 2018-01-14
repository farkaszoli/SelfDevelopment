package jatekok.campercrew.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@ToString
@EqualsAndHashCode
public class Robber
{
    private final String name;
    private final List<String> skills;
    private final double share;
    private final int experience;
    private final boolean dead;
    private final boolean prisoner;

    public Robber(String name, List<String> skills, double share, int experience, boolean dead, boolean prisoner) {
        this.name = name;
        this.skills = skills;
        this.share = share;
        this.experience = experience;
        this.dead = dead;
        this.prisoner = prisoner;
    }

    public String getName() {
        return name;
    }

    public List<String> getSkills() {
        return skills;
    }

    public double getShare() {
        return share;
    }

    public int getExperience() {
        return experience;
    }

    public boolean isDead() {
        return dead;
    }

    public boolean isPrisoner() {
        return prisoner;
    }
}
