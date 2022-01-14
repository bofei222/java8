package com.bf;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

/**
 * @description:
 * @author: bofei
 * @date: 2020-11-19 11:44
 **/
public class DOM4JTest {

    //Read file content into string with - Files.readAllBytes(Path path)

    private static String readAllBytesJava7(String filePath) {
        String content = "";

        try {
            content = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }

    public static void main(String[] args) throws FileNotFoundException {

        String s = readAllBytesJava7("D:\\bofeiProjects\\mycode\\java8\\src\\main\\resources\\pub111.json");
        JSONObject jsonObject = JSON.parseObject(s);
        SAXReader reader = new SAXReader();
        try {
            Document read = reader.read("D:\\bofeiProjects\\mycode\\java8\\src\\main\\resources\\iec-pubs.xml");
            // 获取根节点
            Element root = read.getRootElement();
            // 通过elementIterator方法获取迭代器
            Iterator books = root.elementIterator();
            // 遍历迭代器
            while (books.hasNext()) {
                Element b = (Element) books.next();

                Iterator childBook = b.elementIterator();
                while (childBook.hasNext()) {
                    Element c = (Element) childBook.next();

                    Iterator items = c.elementIterator();
                    while (items.hasNext()) {
                        Element d = (Element) items.next();
                        // 获取属性
                        List<Attribute> ddList = d.attributes();
                        for (Attribute attribute : ddList) {
                            if ("key".equalsIgnoreCase(attribute.getName())) {
                                String oldValue = attribute.getValue();
                                System.out.println(attribute.getName() + ":" + oldValue);
                                String newValue = jsonObject.getString(oldValue);
                                attribute.setValue(newValue);
                            }
                        }
                    }
                }
            }
            writeToFile(read);

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToFile(Document document) throws IOException {
        OutputFormat format = OutputFormat.createPrettyPrint();
        File f = new File("iec-pubs-new.xml");
        XMLWriter writer = new XMLWriter(new FileOutputStream(f), format);
        //设置是否转义。默认true，代表转义
        writer.setEscapeText(false);
        writer.write(document);
        writer.close();
    }
}