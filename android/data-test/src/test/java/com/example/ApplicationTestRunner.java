package com.example;

import org.junit.runners.model.InitializationError;
import org.robolectric.AndroidManifest;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.res.Fs;

public class ApplicationTestRunner extends RobolectricTestRunner {
    private static final int MAX_SDK_SUPPORTED_BY_ROBOLECTRIC = 18;
    private static final String ANDROID_MANIFEST_PATH = "../data/src/main/AndroidManifest.xml";
    private static final String ANDROID_MANIFEST_RES_PATH = "../data/src/main/res";

    public ApplicationTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    @Override protected AndroidManifest getAppManifest(Config config) {
        return new AndroidManifest(Fs.fileFromPath(ANDROID_MANIFEST_PATH),
                Fs.fileFromPath(ANDROID_MANIFEST_RES_PATH)) {
            @Override
            public int getTargetSdkVersion() {
                return MAX_SDK_SUPPORTED_BY_ROBOLECTRIC;
            }
        };
    }
}
