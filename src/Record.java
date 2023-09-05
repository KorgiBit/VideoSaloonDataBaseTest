import java.util.Date;

public class Record {
    private int recordId;
    private int personId;
    private int gameExamplaryId;
    private Date dateOfRent;
    private Date dateOfReturn;



    public Record(int recordId, int personId, int gameExamplaryId, Date date) {
        this.recordId = recordId;
        this.personId = personId;
        this.gameExamplaryId = gameExamplaryId;
        this.dateOfRent = date;
    }

    public int getRecordId() {
        return recordId;
    }

    public int getPersonId() {
        return personId;
    }

    public int getGameExamplaryId() {
        return gameExamplaryId;
    }

    public Date getDateOfRent() {
        return dateOfRent;
    }

    public Date getDateOfReturn() {
        return dateOfReturn;
    }
}
