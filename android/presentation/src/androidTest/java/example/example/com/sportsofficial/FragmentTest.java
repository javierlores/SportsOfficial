package example.example.com.sportsofficial;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.test.ActivityInstrumentationTestCase2;

import example.example.com.sportsofficial.views.activities.TestFragmentActivity;
import example.example.com.sportsofficial.views.fragments.SportTabsFragment;

public class FragmentTest extends ActivityInstrumentationTestCase2<TestFragmentActivity> {
    private TestFragmentActivity mActivity;

    public FragmentTest(Class<TestFragmentActivity> activityClass) {
        super(activityClass);
    }

    @Override protected void setUp() throws Exception {
        super.setUp();
        mActivity = getActivity();
    }

    private Fragment createFragment(Fragment fragment, String tag) {
        FragmentManager manager = mActivity.getSupportFragmentManager();
        manager.beginTransaction().add(fragment, tag).commit();

        getInstrumentation().waitForIdleSync();
        Fragment newFragment = mActivity.getSupportFragmentManager().findFragmentByTag(tag);

        return newFragment;
    }

    public void testSportsTabFragment() {
        Fragment fragment = SportTabsFragment.n
    }

    public void testTournamentsFragment() {

    }

    public void testLeaguesFragment() {

    }

    public void testMatchesFragment() {

    }
}
