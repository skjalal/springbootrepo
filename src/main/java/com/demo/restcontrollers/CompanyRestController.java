package com.demo.restcontrollers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.demo.common.DataTableResponse;
import com.demo.dto.CompanyDTO;
import com.demo.entities.Company;
import com.demo.repositories.CompanyRepository;

@RestController
@RequestMapping("/superadminrest")
public class CompanyRestController {

	private final Logger logger = LoggerFactory.getLogger(CompanyRestController.class);

	@Autowired
	private CompanyRepository companyRepository;

	private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	
	@GetMapping("/companies")
	public DataTableResponse getDataTableResponse(@RequestParam("draw") Integer draw, @RequestParam("start") Integer start, @RequestParam("length") Integer length, @RequestParam("searchFilter") String search) {
		logger.info("Enter into DataTable Response");
		DataTableResponse dataTableResponse = null;
		try {
			Pageable pageable = PageRequest.of(start / length, length, Direction.DESC, "companyId");
			Page<Company> page = null;
			if(search.isEmpty()) {
				page = companyRepository.findAll(pageable);
			} else {
				page = companyRepository.findByCompanyNameIgnoreCaseContaining(pageable, search);
			}
			List<Company> Company = page.getContent();
			List<CompanyDTO> companies = new ArrayList<>();
			for(Company company : Company) {
				CompanyDTO companyDTO = new CompanyDTO(company.getCode(), company.getName(), sdf.format(company.getCreatedDate()));
				companies.add(companyDTO);
			}
			int count = page.getNumberOfElements();
			long total = page.getTotalElements();
			dataTableResponse = new DataTableResponse(draw, count, total, companies);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.info("End of DataTable Response");
		return dataTableResponse;
	}
}