package com.itsol.smartoffice.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SQLBuilder {

    private static Logger logger = LoggerFactory.getLogger(SQLBuilder.class);

    public static final String SQL_MODUL_NEW = "new";
    public static final String SQL_MODUL_USERS = "user";
    public static final String SQL_MODUL_ROLE = "role";
    public static final String SQL_MODUL_TIMESHEET = "timesheet";
    public static final String SQL_MODUL_DEPARTMENT = "department";
    public static final String SQL_MODUL_EMPLOYEE = "employee";
    public static final String SQL_MODUL_PERMISSIONS = "permissions";

    public static String getSqlFromFile(String modul, String sqlFileName) {
        File folder;
        try {
            folder = new ClassPathResource("sql" + File.separator + modul + File.separator + sqlFileName + ".sql").getFile();

            if (folder.isFile()) {
                String sql = new String(Files.readAllBytes(Paths.get(folder.getAbsolutePath())));
                return sql;
            }
        } catch (IOException ioe) {
            logger.error(ioe.getMessage(), ioe);
        }
        return null;
    }
}
