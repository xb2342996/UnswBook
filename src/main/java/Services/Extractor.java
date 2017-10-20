package Services;


import Models.MessageBean;
import unsw.curation.api.domain.abstraction.IKeywordEx;
import unsw.curation.api.extractnamedentity.ExtractEntitySentence;
import unsw.curation.api.tokenization.ExtractionKeywordImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.List;

public class Extractor {

    private static ExtractEntitySentence entityExtractor = new ExtractEntitySentence();
    private static IKeywordEx keywordEx = new ExtractionKeywordImpl();

    public static List<String> extractPeople(MessageBean message) throws URISyntaxException{
        return entityExtractor.ExtractPerson(message.getMessage());
    }
    public static List<String> highlightPeople(MessageBean message) throws URISyntaxException{
        List<String> people = extractPeople(message);
        System.out.println(people);

        return people;
    }

    public static String extractKeyword(MessageBean message) throws Exception, FileNotFoundException{
        File file = new File(Extractor.class.getClassLoader().getResource("../../resources/englishStopwords.txt").getPath());

        return keywordEx.ExtractSentenceKeyword(message.getMessage(), file);

    }
    public static String[] highlightKeyword(MessageBean message) throws Exception{
        String keywordString = extractKeyword(message);
        String[] keywords = keywordString.split(",");

        return keywords;
    }
}

