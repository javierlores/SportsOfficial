package example.example.com.sportsofficial.models;


import android.os.Parcel;
import android.os.Parcelable;

public class Sport implements Parcelable {
    private String mName;
    private int mIcon;
    private boolean mHasLeagues;
    private boolean mHasTournaments;
    private boolean mHasMatches;

    public Sport(String name, int icon, boolean hasLeagues, boolean hasTournaments, boolean hasMatches) {
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

    protected Sport(Parcel in) {
        mName = in.readString();
        mIcon = in.readInt();
        mHasLeagues = in.readByte() != 0x00;
        mHasTournaments = in.readByte() != 0x00;
        mHasMatches = in.readByte() != 0x00;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeInt(mIcon);
        dest.writeByte((byte) (mHasLeagues ? 0x01 : 0x00));
        dest.writeByte((byte) (mHasTournaments ? 0x01 : 0x00));
        dest.writeByte((byte) (mHasMatches ? 0x01 : 0x00));
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Sport> CREATOR = new Parcelable.Creator<Sport>() {
        @Override
        public Sport createFromParcel(Parcel in) {
            return new Sport(in);
        }

        @Override
        public Sport[] newArray(int size) {
            return new Sport[size];
        }
    };
}