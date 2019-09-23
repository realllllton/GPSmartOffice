package com.itsol.smartoffice.Services.TimesheetServices;

import com.itsol.smartoffice.Repositories.Timesheet.TimesheetRepository;
import com.itsol.smartoffice.dto.TimesheetDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create Service timesheet
 *
 * @author thainguyen283
 */
@Service
public class TimesheetServiceImpl implements TimesheetService {
    private Logger logger = LoggerFactory.getLogger(TimesheetServiceImpl.class);

    @Autowired
    private TimesheetRepository timesheetRepository;

    @Override
    public List<TimesheetDto> getlisttimesheet() {
        logger.info("get list timesheet");
        return timesheetRepository.getlisttimesheet();
    }

    @Override
    public TimesheetDto getinfotimesheet(TimesheetDto timesheetDto) {
        logger.info("get info timesheet");
        return timesheetRepository.getinfotilesheet(timesheetDto.getId_timesheet());
    }

    @Override
    public List<TimesheetDto> getlistbydatetime(String datetime) {
        logger.info("get list timesheet by datetime");
        return timesheetRepository.getlistbydatetime(datetime);
    }

    @Override
    public boolean edittimesheet(TimesheetDto timesheetDto) {
        logger.info("edit timesheet");
        return timesheetRepository.edittimesheet(timesheetDto);
    }

    @Override
    public boolean deletetimesheet(TimesheetDto timesheetDto) {
        logger.info("delete timesheet");
        return timesheetRepository.deletetimesheet(timesheetDto.getId_timesheet());
    }

    @Override
    public boolean addinfotimesheet(TimesheetDto timesheetDto) {
        logger.info("add timesheet");
        return timesheetRepository.addinfotimesheet(timesheetDto);
    }

    @Override
    public List<TimesheetDto> getlisttimesheetm(String user_name) {
        logger.info("get list timesheet m");
        return timesheetRepository.getlisttimesheetm(user_name);
    }

    @Override
    public TimesheetDto getinfotimesheetm(TimesheetDto timesheetDto) {
        logger.info("get info timesheet m");
        return timesheetRepository.getinfotilesheetm(timesheetDto.getId_timesheet());
    }

    @Override
    public List<TimesheetDto> getlistbydatetimem(String user_name, String datetime) {
        logger.info("get list by datetime m");
        return timesheetRepository.getlistbydatetimem(user_name, datetime);
    }
}
