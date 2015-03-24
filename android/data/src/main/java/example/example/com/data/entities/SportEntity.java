package example.example.com.data.entities;


public class SportEntity {
    private String mName;
    private int mIcon;
    private boolean mHasLeagues;
    private boolean mHasTournaments;
    private boolean mHasMatches;

    public SportEntity(String name, int icon, boolean hasLeagues, boolean hasTournaments, boolean hasMatches) {
        mName = name;
        mIcon = icon;
        mHasLeagues = hasLeagues;
        mHasTournaments = hasTournaments;
        mHasMatches = hasMatches;
    }

    public String getName() {
        return mName;
    }

    public int getIcon() {
        return mIcon;
    }

    public boolean hasLeagues () {
        return mHasLeagues;
    }

    public boolean hasTournaments() {
        return mHasTournaments;
    }

    public boolean hasMatches() {
        return mHasMatches;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setIcon(int icon) {
        mIcon = icon;
    }

    public void setHasTournaments(boolean hasTournaments) {
        mHasTournaments = hasTournaments;
    }

    public void setHasLeagues(boolean hasLeagues) {
        mHasLeagues = hasLeagues;
    }

    public void setHasMatches(boolean hasMatches) {
        mHasMatches = hasMatches;
    }
}
