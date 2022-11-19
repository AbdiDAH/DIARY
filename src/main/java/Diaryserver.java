import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Diaryserver {

    private static final Scanner scanner = new Scanner(System.in);
    public static final ObjectMapper mapper = new ObjectMapper();
    public byte[] jsonString;

    DiaryAccess diaryObjectmapper;

    {
        try {
            diaryObjectmapper = objectmapper.readValue(jsonString,DiaryAccess.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ObjectReader objectmapper;
    DiaryAccess diaryAccess;

    {
        try {
            diaryAccess = objectmapper.readValue(path.toFile(),DiaryAccess.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static final Path path = Paths.get("src/main/resources/thediaries.json");

    public Diaryserver(byte[] jsonString) {
        this.jsonString = jsonString;
    }

    public static void readdiaries() throws IOException {
        List<DiaryAccess> EveryDiary;
        EveryDiary = List.of(mapper.readValue(path.toFile(), DiaryAccess[].class));
        //List.of(mapper.readValue(path.toFile(), DiaryAccess[].class));
        for (DiaryAccess a : EveryDiary) {
            System.out.println("Title:" + a.getTitle());
            System.out.println("Context:" + a.getContext());
            System.out.println("Date:" + a.getDateOfAccess());
        }
    }
    public static void DiaryMenu(){
        String Alternativ1 = "1: Add diaries";
        String Alternativ2 = "2: Read all diaries";
        String Alternativ3 = "3: Close the program";
        System.out.println(Alternativ1 + "\n" + Alternativ2 + "\n" + Alternativ3);
    }

    public static void AddDiariesToJson() throws IOException {
        List<DiaryAccess> diariesFromJSON = List.of(mapper.readValue(path.toFile(), DiaryAccess[].class));
        List<DiaryAccess>diaries = new ArrayList<>(diariesFromJSON);
        diaries.add(makeYourDiary());
        mapper.writerWithDefaultPrettyPrinter().writeValue(path.toFile(),diaries);


    }
    private static DiaryAccess makeYourDiary(){
        System.out.println("Insert your title");
        String title = scanner.nextLine();
        System.out.println("Enter your context");
        String context = scanner.nextLine();
        String date = LocalDate.now().toString();
        System.out.println("What is the date?");
        System.out.println(title + context + date);
        return new DiaryAccess(title , context , date);

    }

    public static void TheEnd(){
        String Aternativ3 = "This is the end of this diary, BYE";
        System.out.println(Aternativ3);
    }
    public static void Error(){
        String Alternativ4 = "Something went wrong try again select between 1-3";
        System.out.println(Alternativ4);
    }
}

