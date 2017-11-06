package jatekok.wumpus.model.table;

public enum RoomLevel
{
    EASY("easy"),
    MEDIUM("medium"),
    HARD("hard");
    
    private final String level;

    RoomLevel(String level)
    {
        this.level = level;
    }

    public String getLevel()
    {
        return level;
    }
}
