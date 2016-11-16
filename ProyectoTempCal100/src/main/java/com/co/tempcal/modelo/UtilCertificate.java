package com.co.tempcal.modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Iterator;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class UtilCertificate {
	
	public final String FILE_PATH_SRC = "resources/CertificateTemplate.docx";
	public final String FILE_PATH_DIR = "temp/";
	public final String FILE_PATH_PDF = "certificates/";
	
	public void createCertitificate(CertificateDTO dto){

		FileInputStream fs = null;
		XWPFDocument doc = null;
		try {
			fs = new FileInputStream(FILE_PATH_SRC);
			doc = new XWPFDocument(fs);
			
			doc = replaceText(doc);
			
			saveWord(FILE_PATH_DIR+"Certificate"+dto.getOwner()+".docx", doc);
			
			// createPDF(fileDIR, filePDF);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private XWPFDocument replaceText(XWPFDocument doc) {

		List<XWPFParagraph> listaParrafos = doc.getParagraphs();

		for (Iterator iterator = listaParrafos.iterator(); iterator.hasNext();) {
			XWPFParagraph xwpfParagraph = (XWPFParagraph) iterator.next();

			for (XWPFRun run : xwpfParagraph.getRuns()) {
				if (run != null) {
					String texto = run.getText(0);
					if (texto != null && texto.contains("$ownerName")) {
						texto = texto.replace("$ownerName", "HERNAN LAMPREA");
						run.setText(texto, 0);
					}
					if (texto != null && texto.contains("$typeCertificate")) {
						texto = texto.replace("$typeCertificate", "OPEN");
						run.setText(texto, 0);
					}
				}

			}

		}

		return doc;
	}

	private void saveWord(String filePath, XWPFDocument doc) throws FileNotFoundException, IOException {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(filePath);
			doc.write(out);
		} finally {
			out.close();
		}
	}
	
	private void createPDF(String fileSource, String fileDir) {

		PdfWriter writer;
		try {
			writer = new PdfWriter(fileDir);
			PdfDocument pdf = new PdfDocument(writer);
			Document document = new Document(pdf);
			document.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void createPDF2(String fileSource, String fileDir) {

		String filePath = fileSource;
		FileInputStream fInputStream = new FileInputStream(new File(filePath));
		// XWPFDocument document = new XWPFDocument(Data.class.getResourceAsStream(filePath));
		XWPFDocument document = new XWPFDocument(fInputStream);

		File outFile = new File(fileDir);
		outFile.getParentFile().mkdirs();

		OutputStream out = new FileOutputStream(outFile);
		PdfOptions options = PdfOptions.create().fontEncoding("windows-1250");
		PdfConverter.getInstance().convert(document, out, options);

		System.out.println("Sucess");

	}
}

}
