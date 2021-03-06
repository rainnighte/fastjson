package com.alibaba.json.bvt;

import java.io.StringWriter;

import org.junit.Assert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import junit.framework.TestCase;

public class StringFieldTest_special_singquote extends TestCase {
    public void test_special() throws Exception {
        Model model = new Model();
        StringBuilder buf = new StringBuilder();
        for (int i = Character.MIN_VALUE; i < Character.MAX_VALUE; ++i) {
            buf.append((char) i);
        }
        model.name = buf.toString();
        
        StringWriter writer = new StringWriter();
        JSON.writeJSONString(writer, model);

        Model model2 = JSON.parseObject(writer.toString(), Model.class);
        Assert.assertEquals(model.name, model2.name);
    }
    
    public void test_special_browsecue() throws Exception {
        Model model = new Model();
        StringBuilder buf = new StringBuilder();
        for (int i = Character.MIN_VALUE; i < Character.MAX_VALUE; ++i) {
            buf.append((char) i);
        }
        model.name = buf.toString();
        
        StringWriter writer = new StringWriter();
        JSON.writeJSONString(writer, model, SerializerFeature.UseSingleQuotes);

        Model model2 = JSON.parseObject(writer.toString(), Model.class);
        Assert.assertEquals(model.name, model2.name);
    }
    
    public void test_special_browsecompatible() throws Exception {
        Model model = new Model();
        StringBuilder buf = new StringBuilder();
        for (int i = Character.MIN_VALUE; i < Character.MAX_VALUE; ++i) {
            buf.append((char) i);
        }
        model.name = buf.toString();
        
        StringWriter writer = new StringWriter();
        JSON.writeJSONString(writer, model, SerializerFeature.UseSingleQuotes);

        Model model2 = JSON.parseObject(writer.toString(), Model.class);
        Assert.assertEquals(model.name, model2.name);
    }

    private static class Model {

        public String name;

    }
}
