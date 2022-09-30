package org.choicehotels.springrest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.SoapFaultDetailElement;
import org.springframework.ws.soap.client.SoapFaultClientException;
import org.w3c.dom.Node;

import javax.xml.transform.dom.DOMResult;
import java.util.Iterator;

public class GlobalExceptionResolver {


    public GlobalExceptionResolver() {
    }

    public SoapClientException parseSoapException(SoapFaultClientException ex) {
        String message = null;
        HttpStatus status = null;
        SoapFaultDetail soapFaultDetail = ex.getSoapFault().getFaultDetail();
        if (soapFaultDetail == null) {
            return new SoapClientException(null, null);
        }

        Iterator<SoapFaultDetailElement> detailEntries = soapFaultDetail.getDetailEntries();
        while (detailEntries.hasNext()) {
            SoapFaultDetailElement detailElement = detailEntries.next();
            Node node = ((DOMResult) detailElement.getResult()).getNode();
            try {
                int statusCode = Integer.parseInt(node.getChildNodes().item(0).getNodeValue());
                status = HttpStatus.valueOf(statusCode);
            } catch (NumberFormatException numberFormatException){
                message = node.getChildNodes().item(0).getNodeValue();
            }
        }
        return new SoapClientException(message, status);
    }
}
