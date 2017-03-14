package egypercesek.stringcounter;

import org.testng.annotations.Test;

public class StringCounter
{
    private static final String STRING = "KKNDDKDKKNKDEDNNENNNNNEKNEEEDKNK"+
            "EEEDKDDNDKDEKEDKNKKDEENKEKKDKEND"+
            "KNNDDDKNDNDDDNEKNEDENDEEDKDDDNDN"+
            "NEDEKNENNEEKDEKKDKKEEEDKDNNKKDNN"+
            "NEDEKKNEEENKKKDEKDKKKN";

    private static final String SEARCH_STRING = "KKN";
    private int result = 0;
    int searchStringLength = SEARCH_STRING.length();

    @Test
    public void counter()
    {
        for(int i = 0; i <= STRING.length() - searchStringLength; i ++)
        {
            if(SEARCH_STRING.equals(STRING.substring(i, searchStringLength + i)))
            {
                result++;
            }
        }

        System.out.println("result: " + result);
    }

    public void counterWithJava8()
    {
//        STRING.chars()
//                .filter(char -> SEARCH_STRING.equals(STRING.substring(char, searchStringLength + char)))
    }
}

