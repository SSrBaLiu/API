package org.liuep.APIDemo.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class JaxbXmlUtil {

    /**
     * 把对象转换成String类型的XML输出
     * @param object
     * @return
     */
    public static String convertObjToXml(Object object){
        //创建输出流
        StringWriter stringWriter = new StringWriter();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            //配置格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
            marshaller.marshal(object,stringWriter);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return stringWriter.toString();
    }

    /**
     * 把字符串形式的xml转化为对象
     * @param string
     * @param clazz
     * @return
     */
    public static Object convertXmlToObj(String string,Class clazz){
        Object object = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            StringReader stringReader = new StringReader(string);
            object = unmarshaller.unmarshal(stringReader);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return object;
    }
}
