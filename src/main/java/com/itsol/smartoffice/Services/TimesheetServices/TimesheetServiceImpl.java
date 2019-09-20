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
    public boolean edittimesheet(TimesheetDto timesheetDto) {
        logger.info("edit timesheet");
        return timesheetRepository.edittimesheet(timesheetDto);
    }

    @Override
    public boolean deletetimesheet(TimesheetDto timesheetDto) {
        logger.info("delete timesheet");
        return timesheetRepository.deletetimesheet(timesheetDto.getId_timesheet());
    }
}
