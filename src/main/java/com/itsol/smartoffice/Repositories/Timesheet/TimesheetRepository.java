package com.itsol.smartoffice.Repositories.Timesheet;

import com.itsol.smartoffice.dto.TimesheetDto;

import java.util.List;

public interface TimesheetRepository {
    List<TimesheetDto> getlisttimesheet();

    TimesheetDto getinfotilesheet(int id_timesheet);

    boolean edittimesheet(TimesheetDto timesheetDto);

    boolean deletetimesheet(int id_timesheet);
}
