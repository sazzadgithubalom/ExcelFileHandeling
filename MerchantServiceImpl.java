
package com.mosambee.configuration.service.impl;

import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mosambee.configuration.service.MerchantService;

@Service
public class MerchantServiceImpl implements MerchantService {

	@Override
	public String uploadMerchant(MultipartFile multipartFile) {
		try (InputStream inputStream = multipartFile.getInputStream()) {
			try(Workbook workbook = WorkbookFactory.create(inputStream)){
				Sheet sheet = workbook.getSheetAt(0);

				for (Row row : sheet) {
					for (Cell cell : row) {
						System.out.println(cell.getStringCellValue());
					}
				}
			}
			
			return "success";
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "failed";
	}
}
