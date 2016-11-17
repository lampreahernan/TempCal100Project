package com.co.tempcal.modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class UtilCertificate {
	
//	public final String FILE_PATH_SRC = "resources/CertificateTemplate.docx";
//	public final String FILE_PATH_DIR = "temp/";
//	public final String FILE_PATH_PDF = "certificates/";
	

	
	public static void main(String[] args) {
		
		CertificateDTO certificate = new CertificateDTO();
		certificate.setCalibratedDate(new Date().toString());
		certificate.setCalibrationType("C");
		certificate.setCertificateNumber("1111");
		certificate.setMachineModel("2222");
		certificate.setOwner("HERNAN");
		certificate.setSerialLength("3333");
		certificate.setTypeMachine("N");
		
		CalibrationInformationDTO calibration = new CalibrationInformationDTO();
		calibration.setTemperatureType("C");
		calibration.setSerial("1234");
		
		
		createCertitificate(certificate, calibration);
		
		
	}
	
	public static void createCertitificate(CertificateDTO certificate, CalibrationInformationDTO calibration){

		String FILE_PATH_SRC = "C:/Users/hlamprea/Desktop/Certificate.docx";
		String FILE_PATH_DIR = "C:/Users/hlamprea/Desktop/temp/";
		String FILE_PATH_PDF = "C:/Users/hlamprea/Desktop/certificates/";
		
		FileInputStream fs = null;
		XWPFDocument doc = null;
		try {
			fs = new FileInputStream(FILE_PATH_SRC);
			doc = new XWPFDocument(fs);
			
			doc = replaceText(doc, certificate, calibration);
			
			saveWord(FILE_PATH_DIR+"Certificate"+certificate.getOwner()+".docx", doc);
			
			// createPDF(fileDIR, filePDF);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static XWPFDocument replaceText(XWPFDocument doc, CertificateDTO certificate, CalibrationInformationDTO calibration) {

		List<XWPFParagraph> listaParrafos = doc.getParagraphs();

		for (Iterator iterator = listaParrafos.iterator(); iterator.hasNext();) {
			XWPFParagraph xwpfParagraph = (XWPFParagraph) iterator.next();

			for (XWPFRun run : xwpfParagraph.getRuns()) {
				if (run != null) {
					String texto = run.getText(0);
					if (texto != null && texto.contains("$ownerName")) {
						texto = texto.replace("$ownerName", certificate.getOwner());
						run.setText(texto, 0);
					}
					if (texto != null && texto.contains("$certificateNumber")) {
						texto = texto.replace("$certificateNumber", certificate.getCertificateNumber());
						run.setText(texto, 0);
					}
					if (texto != null && texto.contains("$typeTemp")) {
						texto = texto.replace("$typeTemp", calibration.getTemperatureType());
						run.setText(texto, 0);
					}
					if (texto != null && texto.contains("$dateCalibrated")) {
						texto = texto.replace("$dateCalibrated", certificate.getCalibratedDate());
						run.setText(texto, 0);
					}
					if (texto != null && texto.contains("$modelMachine")) {
						texto = texto.replace("$modelMachine", certificate.getMachineModel());
						run.setText(texto, 0);
					}
					if (texto != null && texto.contains("$serial")) {
						texto = texto.replace("$serial", calibration.getSerial());
						run.setText(texto, 0);
					}
					if (texto != null && texto.contains("$length")) {
						texto = texto.replace("$length", certificate.getSerialLength());
						run.setText(texto, 0);
					}
					if (texto != null && texto.contains("$typeCertificate")) {
						texto = texto.replace("$typeCertificate", certificate.getCalibrationType());
						run.setText(texto, 0);
					}
				}

			}

		}

		return doc;
	}

	private static void saveWord(String filePath, XWPFDocument doc) throws FileNotFoundException, IOException {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(filePath);
			doc.write(out);
		} finally {
			out.close();
		}
	}
	
//	private void createPDF(String fileSource, String fileDir) {
//
//		PdfWriter writer;
//		try {
//			writer = new PdfWriter(fileDir);
//			PdfDocument pdf = new PdfDocument(writer);
//			Document document = new Document(pdf);
//			document.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	private static void createPDF2(String fileSource, String fileDir) {
//
//		String filePath = fileSource;
//		FileInputStream fInputStream = new FileInputStream(new File(filePath));
//		// XWPFDocument document = new XWPFDocument(Data.class.getResourceAsStream(filePath));
//		XWPFDocument document = new XWPFDocument(fInputStream);
//
//		File outFile = new File(fileDir);
//		outFile.getParentFile().mkdirs();
//
//		OutputStream out = new FileOutputStream(outFile);
//		PdfOptions options = PdfOptions.create().fontEncoding("windows-1250");
//		PdfConverter.getInstance().convert(document, out, options);
//
//		System.out.println("Sucess");
//
//	}
}

