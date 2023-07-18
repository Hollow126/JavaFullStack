package es25;

import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ProvaCsv
{
    public static void main(String[]args)
    {
        
        System.out.println("ciao");
}

    public String convertToCSV(String[]data){
        return Stream.of(data).map(this::escapeSpecialCharacters).collect(Collectors.joining(","));
    }


}