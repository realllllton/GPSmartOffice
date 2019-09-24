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
    @RequestMapping(value = "/getlistbydatetime/{datetime}", method = RequestMethod.GET)
    public List<TimesheetDto> getinfotimesheet(@PathVariable String datetime) {
        return timesheetService.getlistbydatetime(datetime);
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

    //    member
    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')||hasAuthority('MEMBER')")
    @RequestMapping(value = "/addinfotimesheet", method = RequestMethod.POST)
    public boolean addinfotimesheet(@RequestBody TimesheetDto timesheetDto) {
        return timesheetService.addinfotimesheet(timesheetDto);
    }

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')||hasAuthority('MEMBER')")
    @RequestMapping(value = "/getlisttimesheetm/{user_name}", method = RequestMethod.GET)
    public List<TimesheetDto> getlisttimesheetm(@PathVariable String user_name) {
        return timesheetService.getlisttimesheetm(user_name);
    }

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')||hasAuthority('MEMBER')")
    @RequestMapping(value = "/getinfotimesheetm", method = RequestMethod.POST)
    public TimesheetDto getinfotimesheetm(@RequestBody TimesheetDto timesheetDto) {
        return timesheetService.getinfotimesheetm(timesheetDto);
    }

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')||hasAuthority('MEMBER')")
    @RequestMapping(value = "/getlistbydatetimem/{user_name}/{datetime}", method = RequestMethod.GET)
    public List<TimesheetDto> getlistbydatetimem(@PathVariable String user_name, @PathVariable String datetime) {
        return timesheetService.getlistbydatetimem(user_name, datetime);
    }
}
