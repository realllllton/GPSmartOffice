package com.itsol.smartoffice.Services.TimesheetServices;

import com.itsol.smartoffice.dto.TimesheetDto;

import java.util.List;

public interface TimesheetService {
    List<TimesheetDto> getlisttimesheet();

    TimesheetDto getinfotimesheet(TimesheetDto timesheetDto);

    boolean edittimesheet(TimesheetDto timesheetDto);

    boolean deletetimesheet(TimesheetDto timesheetDto);
}
