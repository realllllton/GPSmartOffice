package com.itsol.smartoffice.Repositories.Timesheet;

import com.itsol.smartoffice.dto.TimesheetDto;

import java.util.Date;
import java.util.List;

public interface TimesheetRepository {
    List<TimesheetDto> getlisttimesheet();

    TimesheetDto getinfotilesheet(int id_timesheet);

    List<TimesheetDto> getlistbydatetime(String datetime);

    boolean edittimesheet(TimesheetDto timesheetDto);

    boolean deletetimesheet(int id_timesheet);

    //member
    boolean addinfotimesheet(TimesheetDto timesheetDto);

    List<TimesheetDto> getlisttimesheetm(String user_name);

    TimesheetDto getinfotilesheetm(int id_timesheet);

    List<TimesheetDto> getlistbydatetimem(String user_name, String datetime);
}
