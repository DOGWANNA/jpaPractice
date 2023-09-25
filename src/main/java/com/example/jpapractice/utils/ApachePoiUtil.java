package com.example.jpapractice.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class ApachePoiUtil {

    public void addPasswordToExcelFile() {
        final String password = "1234";
        final String savePath = "C:\\Users\\DOKWAN NA\\Desktop\\excel.xlsx";

        List<String> tmpData = Arrays.asList("Java", "JavaScript", "Python", "GoLang");

        try (Workbook wb2 = new XSSFWorkbook();
             ByteArrayOutputStream fileOut = new ByteArrayOutputStream();
             FileOutputStream fos = new FileOutputStream(savePath)) {

            Sheet sheet1 = wb2.createSheet("Sheet1");

            //Write Excel File
            for (int i = 0; i < tmpData.size(); i++) {
                String data = tmpData.get(i);

                Row row = sheet1.createRow(i);
                Cell cell = row.createCell(0);

                cell.setCellValue(data);

            }
//
            wb2.write(fileOut);

            InputStream filein = new ByteArrayInputStream(fileOut.toByteArray());
            OPCPackage opc = OPCPackage.open(filein);

            POIFSFileSystem fileSystem = new POIFSFileSystem();

            EncryptionInfo encryptionInfo = new EncryptionInfo(EncryptionMode.agile);
            Encryptor encryptor = encryptionInfo.getEncryptor();
            encryptor.confirmPassword(password);

            opc.save(encryptor.getDataStream(fileSystem));
            fileSystem.writeFilesystem(fos);

            log.info("Create Excel File!!");

        } catch (IOException e) {
            log.error(e.getMessage(), e);

        } catch (GeneralSecurityException e) {
            log.error(e.getMessage(), e);
        } catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
            throw new RuntimeException(e);
        }

    }
}
