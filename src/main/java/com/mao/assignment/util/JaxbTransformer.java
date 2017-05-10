package com.mao.assignment.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class JaxbTransformer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4459240007562693691L;
	
	public static final JaxbTransformer INSTANCE = new JaxbTransformer();

	/** */
	Class c;
	
	private JaxbTransformer() {
		
	}
	
	/**
	 * 
	 * @param c
	 * @param generateProlog
	 * @return XML String
	 * @throws JAXBException
	 */
	public String marshall(Object o) throws JAXBException {
		this.c = o.getClass();
		StringWriter sw = new StringWriter();
		try {
			getMarshaller().marshal(o, sw);
		} catch (JAXBException e) {			
			throw e;
		}
        return sw.toString();
	}
	
	/**
	 * 
	 * @param xml
	 * @param c
	 * @return Object
	 * @throws HubSystemException
	 */
	public Object unmarshall(Class c, InputStream inputStream) throws JAXBException {
		this.c = c;
		try {
			int ch;
		    StringBuilder sb = new StringBuilder();
			while ((ch = inputStream.read()) != -1) {
				sb.append((char) ch);
			}
			return unmarshall(c, sb.toString());
		} catch (JAXBException e) {			
			throw e;
		} catch (IOException e) {
			throw new JAXBException(e);
		}
    }
	
	/**
	 * 
	 * @param xml
	 * @param c
	 * @return Object
	 * @throws HubSystemException
	 */
	public Object unmarshall(Class c, String xml) throws JAXBException {
		this.c = c;
		try {
			return JAXBIntrospector.getValue(getUnmarshaller().unmarshal(new StringReader(xml)));
		} catch (JAXBException e) {			
			throw e;
		}
    }
	
	/**
	 * 
	 * @return Unmarshaller
	 * @throws JAXBException
	 */
	private Unmarshaller getUnmarshaller() throws JAXBException { 
        return getJAXBContext().createUnmarshaller();
    }
    
	/**
	 * 
	 * @return Marshaller
	 * @throws JAXBException 
	 */
    private Marshaller getMarshaller() throws JAXBException { 
        return getJAXBContext().createMarshaller();
    }

	/**
	 * 
	 * @return JAXBContext
	 * @throws JAXBException
	 */
	private JAXBContext getJAXBContext() throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(this.c);
        return jc;
    }
}