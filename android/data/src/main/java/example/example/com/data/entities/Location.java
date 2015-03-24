package example.example.com.data.entities;


public class Location {
    private String mCountry;
    private String mState;
    private String mCity;

    public Location () {

    }

    public String getCountry() {
        return mCountry;
    }

    public String getState() {
        return mState;
    }

    public String getCity() {
        return mCity;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public void setState(String state) {
        mState = state;
    }

    public void setCity(String city) {
        mCity = city;
    }

    @Override
    public String toString() {
        if (mState != null) {
            return mCity;
        } else {
            return mState + ", " + mCity;
        }
    }
}
