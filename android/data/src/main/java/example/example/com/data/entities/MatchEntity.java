package example.example.com.data.entities;


public class MatchEntity {
    private int mMatchId;
    private String mHomeTeamName;
    private String mAwayTeamName;
    private int mHomeTeamScore;
    private int mAwayTeamScore;
    private Date mDate;
    private Time mTime;

    public MatchEntity() {
    }

    public int getMatchId() {
        return  mMatchId;
    }

    public String getHomeTeamName() {
        return mHomeTeamName;
    }

    public String getAwayTeamName() {
        return mAwayTeamName;
    }

    public int getHomeTeamScore() {
        return mHomeTeamScore;
    }

    public int getAwayTeamScore() {
        return mAwayTeamScore;
    }

    public Date getDate() {
        return mDate;
    }

    public Time getTime() {
        return mTime;
    }

    public void setMatchId(int matchId) {
        mMatchId = matchId;
    }

    public void setHomeTeamName(String name) {
        mHomeTeamName = name;
    }

    public void setAwayTeamName(String name) {
        mAwayTeamName = name;
    }

    public void setHomeTeamScore(int score) {
        mHomeTeamScore = score;
    }

    public void setAwayTeamScore(int score) {
        mAwayTeamScore = score;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public void setTime(Time time) {
        mTime = time;
    }
}
