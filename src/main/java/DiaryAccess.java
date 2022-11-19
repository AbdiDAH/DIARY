import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiaryAccess {

    private String Title;
    private String Context;
    private String DateOfAccess;

    public DiaryAccess(String title, String context, String dateOfAccess) {
        Title = title;
        Context = context;
        DateOfAccess = dateOfAccess;
    }

    public DiaryAccess() {
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContext() {
        return Context;
    }

    public void setContext(String context) {
        Context = context;
    }

    public String getDateOfAccess() {
        return DateOfAccess;
    }

    public void setDateOfAccess(String dateOfAccess) {
        DateOfAccess = dateOfAccess;
    }

    @Override
    public String toString() {
        return "DiaryAccess{" +
                "Title='" + Title + '\'' +
                ", Context='" + Context + '\'' +
                ", DateOfAccess='" + DateOfAccess + '\'' +
                '}';
    }
}
