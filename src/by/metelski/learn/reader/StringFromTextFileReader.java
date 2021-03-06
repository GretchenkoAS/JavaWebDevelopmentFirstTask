package by.metelski.learn.reader;

import by.metelski.learn.exception.CustomArrayException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class StringFromTextFileReader {
    public final static Logger logger = LogManager.getLogger();

    public List<String> readStringsFromFile(String filePath) throws CustomArrayException {
        List<String> stringsFromFile;

        try {
            stringsFromFile= Files.lines(Paths.get(filePath))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new CustomArrayException("File not found",e);
        }
        logger.log(Level.INFO,"read string from file : " + stringsFromFile );
        return stringsFromFile;
    }

}
