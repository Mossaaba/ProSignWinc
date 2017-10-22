package com.ProSign.Cryptage;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;

public class ReadXMLFile
{
	
	public static void main(String args[])
	{

	}

	public static String ReadXml(String path)
	{ 
		String codeFinale ="";
		try {
			

		File fXmlFile = new File(path);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);

		//optional, but recommended
		//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		doc.getDocumentElement().normalize();


		NodeList nList = doc.getElementsByTagName("general");

		

		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);

			

			if (nNode.getNodeType() == Node.ELEMENT_NODE) 
			{

				Element eElement = (Element) nNode;
				
				codeFinale=eElement.getElementsByTagName("licence").item(0).getTextContent();
				
			}
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	
	return codeFinale;
	  }

}
   