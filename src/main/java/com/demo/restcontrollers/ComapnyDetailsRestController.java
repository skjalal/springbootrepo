package com.demo.restcontrollers;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.demo.common.DataTableResponse;
import com.demo.entities.CompanyDetails;
import com.demo.repositories.CompanyDetailsRepository;

@RestController
public class ComapnyDetailsRestController {

	private final Logger logger = LoggerFactory.getLogger(CompanyDetailsRepository.class);

	@Autowired
	private CompanyDetailsRepository companyDetailsRepository;

	@GetMapping("/companyDetails")
	public DataTableResponse getDataTableResponse(@RequestParam("draw") Integer draw, @RequestParam("start") Integer start, @RequestParam("length") Integer length, @RequestParam("searchFilter") String search) {
		logger.info("Enter into DataTable Response");
		DataTableResponse dataTableResponse = null;
		try {
			Pageable pageable = PageRequest.of(start / length, length, Direction.DESC, "companyId");
			Page<CompanyDetails> page = null;
			if(search.isEmpty()) {
				page = companyDetailsRepository.findAll(pageable);
			} else {
				page = companyDetailsRepository.findByCompanyNameIgnoreCaseContaining(pageable, search);
			}
			List<CompanyDetails> companyDetails = page.getContent();
			int count = page.getNumberOfElements();
			long total = page.getTotalElements();
			dataTableResponse = new DataTableResponse(draw, count, total, companyDetails);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.info("End of DataTable Response");
		return dataTableResponse;
	}
}