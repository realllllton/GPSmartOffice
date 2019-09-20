package com.itsol.smartoffice.Controllers;

import com.itsol.smartoffice.Services.TimesheetServices.TimesheetService;
import com.itsol.smartoffice.dto.TimesheetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/timesheet")
public class TimesheetController {

    @Autowired
    private TimesheetService timesheetService;

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')")
    @RequestMapping("/getlisttimesheet")
    public List<TimesheetDto> getlisttimesheet() {
        return timesheetService.getlisttimesheet();
    }

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')")
    @RequestMapping(value = "/getinfotimesheet", method = RequestMethod.POST)
    public TimesheetDto getinfotimesheet(@RequestBody TimesheetDto timesheetDto) {
        return timesheetService.getinfotimesheet(timesheetDto);
    }

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')")
    @RequestMapping(value = "/edittimesheet", method = RequestMethod.POST)
    public boolean edittimesheet(@RequestBody TimesheetDto timesheetDto) {
        return timesheetService.edittimesheet(timesheetDto);
    }

    @PreAuthorize(("hasAnyAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')"))
    @RequestMapping(value = "/deletetimesheet", method = RequestMethod.POST)
    public boolean deletetimesheet(@RequestBody TimesheetDto timesheetDto) {
        return timesheetService.deletetimesheet(timesheetDto);
    }
}
