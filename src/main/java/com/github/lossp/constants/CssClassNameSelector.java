package com.github.lossp.constants;

public final class CssClassNameSelector {
    private static final String USER_LINK_CLASS_NAME = ".UserLink-link";
    private static final String PAGE_NUMBER_CLASS_NAME = ".Pagination>button";
    private static final String USER_PAGE_PROFILE = ".ProfileHeader-contentBody";

    private static String getUserPageProfile() {
        return USER_PAGE_PROFILE;
    }

    public static String getUserLinkClassName() {
        return USER_LINK_CLASS_NAME;
    }

    public static String getPageNumberClassName() {
        return PAGE_NUMBER_CLASS_NAME;
    }
}
