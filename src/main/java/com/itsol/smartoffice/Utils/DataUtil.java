package com.itsol.smartoffice.Utils;

/**
 * Utility class for data pre-handling
 *
 */

public class DataUtil {

    public static boolean isNotNullAndEmptyString(String srcString) {
        return srcString != null && !"".equals(srcString.trim());
    }


    public static String removeWildcardCharacters(String srcString) {
        if (isNotNullAndEmptyString(srcString)) {
            return "%" + srcString
                    .trim()
                    .replaceAll("%", "\\%")
                    .replaceAll("_", "\\_") + "%";
        }
        return null;
    }
}
