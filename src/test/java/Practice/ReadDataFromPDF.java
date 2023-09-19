package Practice;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/*program for read the data from PDF*/
public class ReadDataFromPDF {

	public static void main(String[] args) throws Throwable {
		File file = new File("./src/test/resources/DOC-20230410-WA0001_230411_152356.pdf");
		/*loading to the pdf documents*/
		PDDocument doc = PDDocument.load(file );
		
		//pagecount
		int pages = doc.getNumberOfPages();
		System.out.println(pages);
		
		//read the content
		PDFTextStripper pdfData = new PDFTextStripper();
		/*String Data = pdfData.getText(doc);
		System.out.println(Data);*/
		
		//read the data from particular(individual) page
		/*pdfData.setStartPage(3);
		String pagedata = pdfData.getText(doc);
		System.out.println(pagedata);*/
		
		//read the data perticular page
		pdfData.setStartPage(2);
		pdfData.setEndPage(3);
		String pagedata = pdfData.getText(doc);
		System.out.println(pagedata);

	}

}
