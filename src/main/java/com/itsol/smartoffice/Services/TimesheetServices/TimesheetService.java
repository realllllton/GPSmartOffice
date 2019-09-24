package com.itsol.smartoffice.Services.TimesheetServices;

import com.itsol.smartoffice.dto.TimesheetDto;

import java.util.List;

public interface TimesheetService {
    List<TimesheetDto> getlisttimesheet();

    TimesheetDto getinfotimesheet(TimesheetDto timesheetDto);

    List<TimesheetDto> getlistbydatetime(String datetime);

    boolean edittimesheet(TimesheetDto timesheetDto);

    boolean deletetimesheet(TimesheetDto timesheetDto);

    //    member
    boolean addinfotimesheet(TimesheetDto timesheetDto);

    List<TimesheetDto> getlisttimesheetm(String user_name);

    TimesheetDto getinfotimesheetm(TimesheetDto timesheetDto);

    List<TimesheetDto> getlistbydatetimem(String user_name, String datetime);
}
