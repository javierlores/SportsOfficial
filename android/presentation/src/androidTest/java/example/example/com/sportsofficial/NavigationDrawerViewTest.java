package example.example.com.sportsofficial;


import android.test.ActivityInstrumentationTestCase2;

import example.example.com.sportsofficial.views.activities.MainActivity;

public class NavigationDrawerViewTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private MainActivity mMainActivity;

    public NavigationDrawerViewTest(String pkg, Class<MainActivity> activityClass) {
        super(pkg, activityClass);
    }
/*
    public static Matcher<Object> withTitle(final String title) {
        return new BoundedMatcher<Object, NavDrawerItem>(NavDrawerItem.class) {
            @Override
            public boolean matchesSafely(NavDrawerItem item) {
                return item.getTitle().equals(title);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("with title '" + title + "'");
            }
        };
    }

    public NavigationDrawerViewTest() {
        super(MainActivity.class);
    }

    @Override protected void setUp() throws Exception {
        super.setUp();
        mMainActivity = getActivity();
    }

    @Override protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testOpenAndCloseDrawer() {
        // Drawer should not be open to start.
        onView(withId(R.id.drawer_layout)).check(matches(isClosed()));

        openDrawer(R.id.drawer_layout);

        // The drawer should now be open.
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));

        closeDrawer(R.id.drawer_layout);

        // Drawer should be closed again.
        onView(withId(R.id.drawer_layout)).check(matches(isClosed()));
    }

    public void testDrawerOpenAndClickFootballItem() {
        openDrawer(R.id.drawer_layout);

        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));

        // Click an item in the drawer
        int rowIndex = 0;
        String rowContents = MainActivity.NAV_ITEM_TITLES[rowIndex];
        onData(allOf(is(instanceOf(NavDrawerItem.class)), withTitle(rowContents))).perform(click());

        // clicking the item should close the drawer.
        onView(withId(R.id.drawer_layout)).check(matches(isClosed()));

        // Test that the sport tab fragment was added
        Fragment fragment = mMainActivity.getFragmentManager().findFragmentById(R.id.fragment);
        assertThat(fragment, is(notNullValue()));

        // Test that the action bar title was updated
        String actualTitle = mMainActivity.getTitle().toString().trim();
        assertThat(actualTitle, is(rowContents));
    }

    public void testDrawerOpenAndClickBaseballItem() {
        openDrawer(R.id.drawer_layout);

        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));

        // Click an item in the drawer
        int rowIndex = 1;
        String rowContents = MainActivity.NAV_ITEM_TITLES[rowIndex];
        onData(allOf(instanceOf(NavDrawerItem.class), withTitle(rowContents))).perform(click());

        // clicking the item should close the drawer.
        onView(withId(R.id.drawer_layout)).check(matches(isClosed()));

        // Test that the sport tab fragment was added
        Fragment fragment = mMainActivity.getFragmentManager().findFragmentById(R.id.fragment);
        assertThat(fragment, is(notNullValue()));

        // Test that the action bar title was updated
        String actualTitle = mMainActivity.getTitle().toString().trim();
        assertThat(actualTitle, is(rowContents));
    }

    public void testDrawerOpenAndClickBasketballItem() {
        openDrawer(R.id.drawer_layout);

        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));

        // Click an item in the drawer
        int rowIndex = 2;
        String rowContents = MainActivity.NAV_ITEM_TITLES[rowIndex];
        onData(allOf(is(instanceOf(NavDrawerItem.class)), withTitle(rowContents))).perform(click());

        // clicking the item should close the drawer.
        onView(withId(R.id.drawer_layout)).check(matches(isClosed()));

        // Test that the sport tab fragment was added
        Fragment fragment = mMainActivity.getFragmentManager().findFragmentById(R.id.fragment);
        assertThat(fragment, is(notNullValue()));

        // Test that the action bar title was updated
        String actualTitle = mMainActivity.getTitle().toString().trim();
        assertThat(actualTitle, is(rowContents));
    }

    public void testDrawerOpenAndClickTennisItem() {
        openDrawer(R.id.drawer_layout);

        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));

        // Click an item in the drawer
        int rowIndex = 3;
        String rowContents = MainActivity.NAV_ITEM_TITLES[rowIndex];
        onData(allOf(is(instanceOf(NavDrawerItem.class)), withTitle(rowContents))).perform(click());

        // clicking the item should close the drawer.
        onView(withId(R.id.drawer_layout)).check(matches(isClosed()));

        // Test that the sport tab fragment was added
        Fragment fragment = mMainActivity.getFragmentManager().findFragmentById(R.id.fragment);
        assertThat(fragment, is(notNullValue()));

        // Test that the action bar title was updated
        String actualTitle = mMainActivity.getTitle().toString().trim();
        assertThat(actualTitle, is(rowContents));
    }

    public void testDrawerOpenAndClickSoccerItem() {
        openDrawer(R.id.drawer_layout);

        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));

        // Click an item in the drawer
        int rowIndex = 4;
        String rowContents = MainActivity.NAV_ITEM_TITLES[rowIndex];
        onData(allOf(is(instanceOf(NavDrawerItem.class)), withTitle(rowContents))).perform(click());

        // clicking the item should close the drawer.
        onView(withId(R.id.drawer_layout)).check(matches(isClosed()));

        // Test that the sport tab fragment was added
        Fragment fragment = mMainActivity.getFragmentManager().findFragmentById(R.id.fragment);
        assertThat(fragment, is(notNullValue()));

        // Test that the action bar title was updated
        String actualTitle = mMainActivity.getTitle().toString().trim();
        assertThat(actualTitle, is(rowContents));
    }

    public void testDrawerOpenAndClickQuidditchItem() {
        openDrawer(R.id.drawer_layout);

        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));

        // Click an item in the drawer
        int rowIndex = 5;
        String rowContents = MainActivity.NAV_ITEM_TITLES[rowIndex];
        onData(allOf(is(instanceOf(NavDrawerItem.class)), withTitle(rowContents))).perform(click());

        // clicking the item should close the drawer.
        onView(withId(R.id.drawer_layout)).check(matches(isClosed()));

        // Test that the sport tab fragment was added
        Fragment fragment = mMainActivity.getFragmentManager().findFragmentById(R.id.fragment);
        assertThat(fragment, is(notNullValue()));

        // Test that the action bar title was updated
        String actualTitle = mMainActivity.getTitle().toString().trim();
        assertThat(actualTitle, is(rowContents));
    }

    public void testDrawerOpenAndClickUltimateItem() {
        openDrawer(R.id.drawer_layout);

        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));

        // Click an item in the drawer
        int rowIndex = 6;
        String rowContents = MainActivity.NAV_ITEM_TITLES[rowIndex];
        onData(allOf(is(instanceOf(NavDrawerItem.class)), withTitle(rowContents))).perform(click());

        // clicking the item should close the drawer.
        onView(withId(R.id.drawer_layout)).check(matches(isClosed()));

        // Test that the sport tab fragment was added
        Fragment fragment = mMainActivity.getFragmentManager().findFragmentById(R.id.fragment);
        assertThat(fragment, is(notNullValue()));

        // Test that the action bar title was updated
        String actualTitle = mMainActivity.getTitle().toString().trim();
        assertThat(actualTitle, is(rowContents));
    }
    */
}