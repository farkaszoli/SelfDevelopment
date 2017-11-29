package jatekok.wumpus;

import jatekok.wumpus.game.CreateTable;
import jatekok.wumpus.game.GamePlay;
import jatekok.wumpus.model.table.Status;
import jatekok.wumpus.model.table.Table;
import org.springframework.boot.ResourceBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.core.io.DefaultResourceLoader;

import java.io.IOException;

public class Main extends SpringBootServletInitializer
{
    // TODO: add pmd check style, create unit tests and add mocks, use testng, log4j

    private static CreateTable createTable = new CreateTable();
    private final static GamePlay gamePlay = new GamePlay(createTable);

    public static void Main(String[] args) throws Exception
    {
        final SpringApplication application = new SpringApplicationBuilder()
                .banner(new ResourceBanner(new DefaultResourceLoader().getResource("banner.txt")))
                .sources(Main.class)
                .build();

        System.out.println("Wampus world");

        Table[][] table = gamePlay.createTable();

        gamePlay.game(table);

        // todo controller settings

        application.run(Main.class, args);
    }
}
