package jatekok.campercrew;

import jatekok.campercrew.model.Robber;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

@Component
public class CreateRobbers
{
    public List<Robber> createRobbers()
    {
        List<Robber> robbers = new ArrayList<>();

        robbers.add(createRobber());

        return robbers;
    }

    // TODO dummy robber, modify this method
    private Robber createRobber()
    {
        return new Robber("name", emptyList(), 0.0, 0, false, false);
    }
}
