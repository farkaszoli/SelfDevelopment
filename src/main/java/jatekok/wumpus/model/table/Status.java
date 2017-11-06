package jatekok.wumpus.model.table;

public enum Status
{
    EMPTY("empty"),
    WAMPUS("wampus"),
    BAT("bat"),
    STACK("stack"),
    MEAT("meat");

    private final String roomType;

    Status(String roomType)
    {
        this.roomType = roomType;
    }

    public String getRoomType()
    {
        return roomType;
    }
}
