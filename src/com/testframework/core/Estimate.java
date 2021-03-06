package com.testframework.core;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wsdevotion on 15/11/21.
 */
public class Estimate {

    //Response对象
    private Response response = null;
    //返回的json对象
    private JSONObject jsonObject = null;
    //获取数组对象时json对象保存
    private JSONObject saveAllJsonObject = null;
    //json数组
    private JSONArray jsonArray = null;

    //错误信息
    private String errormes = "";

    public Estimate(Response response, JSONObject jsonObject) {
        this.jsonObject = jsonObject;
        this.response = response;
    }

    public Estimate equalInt(String name, Integer val) {
        this.addErrorMes("equalInt", name, val + "");
        Integer v = null;
        try {
            v = jsonObject.getInteger(name);
        } catch (Exception ignored) {

        }
        enterData(name, val);
        if (v == null || !v.equals(val)) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String s = ste.getFileName() + ": Line " + ste.getLineNumber();
            this.printMes("equalInt", val + "", s, v + "", name);
        }

        return this;
    }

    public Estimate equalInt(String name, Integer val, String meg) {
        this.addErrorMes("equalInt", name, val + "");
        Integer v = null;
        try {
            v = jsonObject.getInteger(name);
        } catch (Exception ignored) {

        }
        TestFrameWork.getMap().put(name, meg);
        enterData(name, val);
        if (v == null || !v.equals(val)) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String s = ste.getFileName() + ": Line " + ste.getLineNumber();
            this.printMes("equalInt", val + "", s, v + "", name);
        }

        return this;
    }

    public Estimate equalDouble(String name, Double val) {
        this.addErrorMes("equalDouble", name, val + "");
        Double v = null;
        try {
            v = jsonObject.getDouble(name);
        } catch (Exception ignored) {

        }
        enterData(name, val);
        if (v == null || !v.equals(val)) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String s = ste.getFileName() + ": Line " + ste.getLineNumber();
            this.printMes("equalDouble", val + "", s, v + "", name);
        }

        return this;
    }

    public Estimate equalDouble(String name, Double val, String meg) {
        this.addErrorMes("equalDouble", name, val + "");
        Double v = null;
        try {
            v = jsonObject.getDouble(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        TestFrameWork.getMap().put(name, meg);
        enterData(name, val);
        if (v == null || !v.equals(val)) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String s = ste.getFileName() + ": Line " + ste.getLineNumber();
            this.printMes("equalDouble", val + "", s, v + "", name);
        }

        return this;
    }

    public Estimate equalStr(String name, String val) {
        this.addErrorMes("equalStr", name, val + "");
        String v = null;
        try {
            v = jsonObject.getString(name);
        } catch (Exception ignored) {

        }
        enterData(name, val);
        if (v == null || !v.equals(val)) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String s = ste.getFileName() + ": Line " + ste.getLineNumber();
            this.printMes("equalStr", val + "", s, v + "", name);
        }

        return this;
    }

    public Estimate equalStr(String name, String val, String meg) {
        this.addErrorMes("equalStr", name, val + "");
        String v = null;
        try {
            v = jsonObject.getString(name);
        } catch (Exception ignored) {

        }
        TestFrameWork.getMap().put(name, meg);
        enterData(name, val);
        if (v == null || !v.equals(val)) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String s = ste.getFileName() + ": Line " + ste.getLineNumber();
            this.printMes("equalStr", val + "", s, v + "", name);
        }

        return this;
    }

    public Estimate isInt(String name) {
        this.addErrorMes("isInt", name);
        Object v = null;
        try {
            v = jsonObject.get(name);
        } catch (Exception ignored) {

        }
        enterData(name, "Integer.class");
        try {
            Integer.parseInt(v == null ? "" : v.toString());
        } catch (Exception e) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String s = ste.getFileName() + ": Line " + ste.getLineNumber();
            this.printMes("isInt", "Integer", s, "String", name);
        }


        return this;
    }

    public Estimate isInt(String name, String meg) {
        this.addErrorMes("isInt", name);
        Object v = null;
        try {
            v = jsonObject.get(name);
        } catch (Exception ignored) {

        }
        TestFrameWork.getMap().put(name, meg);
        enterData(name, "Integer.class");
        try {
            Integer.parseInt(v == null ? "" : v.toString());
        } catch (Exception e) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String s = ste.getFileName() + ": Line " + ste.getLineNumber();
            this.printMes("isInt", "Integer", s, "String", name);

        }


        return this;
    }

    public Estimate isDouble(String name) throws Exception {
        this.addErrorMes("isDouble", name);
        Object v = null;
        try {
            v = jsonObject.get(name);
        } catch (Exception ignored) {

        }
        enterData(name, "Double.class");
        try {
            Double.parseDouble(v == null ? "" : v.toString());
        } catch (Exception e) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String s = ste.getFileName() + ": Line " + ste.getLineNumber();
            this.printMes("isDouble", "Double", s, "String", name);
        }
        return this;
    }

    public Estimate isDouble(String name, String meg) throws Exception {
        this.addErrorMes("isDouble", name);
        Object v = null;
        try {
            v = jsonObject.get(name);
        } catch (Exception ignored) {

        }
        TestFrameWork.getMap().put(name, meg);
        enterData(name, "Double.class");
        try {
            Double.parseDouble(v == null ? "" : v.toString());
        } catch (Exception e) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String s = ste.getFileName() + ": Line " + ste.getLineNumber();
            this.printMes("isDouble", "Double", s, "String", name);
            e.printStackTrace();
        }
        return this;
    }

    public Estimate isRegex(String name, String regex) {
        this.addErrorMes("isRegex", name, regex);
        String v = null;
        try {
            v = jsonObject.getString(name);
        } catch (Exception e) {
            v = "";
        }
        enterData(name, "正则:" + regex);

        StackTraceElement ste = new Throwable().getStackTrace()[1];
        String s = ste.getFileName() + ": Line " + ste.getLineNumber();

        String s1 = "";
        for (int i = 0; i < errormes.indexOf(name) + 16; i++) {
            s1 += " ";
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(v);
        if (!matcher.matches()) {
            System.out.println("---------------------------------------");
            System.out.println(s);
            System.out.println("===============>" + errormes);
            System.out.println(s1 + "^");
            System.out.println("Actual => " + v);
            System.out.println("正则表达式匹配错误");
            System.out.println("---------------------------------------");
        }

        return this;

    }

    public Estimate isRegex(String name, String regex, String meg) {
        this.addErrorMes("isRegex", name, regex);
        String v = null;
        try {
            v = jsonObject.getString(name);
        } catch (Exception e) {
            v = "";
        }
        TestFrameWork.getMap().put(name, meg);
        enterData(name, "正则:" + regex);

        StackTraceElement ste = new Throwable().getStackTrace()[1];
        String s = ste.getFileName() + ": Line " + ste.getLineNumber();


        String s1 = "";
        for (int i = 0; i < errormes.indexOf(name) + 16; i++) {
            s1 += " ";
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(v);
        if (!matcher.matches()) {
            System.out.println("---------------------------------------");
            System.out.println(s);
            System.out.println("===============>" + errormes);
            System.out.println(s1 + "^");
            System.out.println("Actual => " + v);
            System.out.println("正则表达式匹配错误");
            System.out.println("---------------------------------------");
        }

        return this;

    }


    public Estimate equalCode(int code) {
        this.addErrorMes("equalCode", code + "");
        TestFrameWork.setCode(code);
        if (response.getCode() != code) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String s = ste.getFileName() + ": Line " + ste.getLineNumber();
            this.printMes("equalCode", code + "", s, response.getCode() + "", code + "");
        }

        return this;
    }

    public Estimate getJsonArray(String except) {
        this.addErrorMes("getJsonArray", except);
        JSONArray jsonArray = null;
        try {
            jsonArray = jsonObject.getJSONArray(except);
        } catch (Exception ignored) {

        }
        TestFrameWork.setArraydata(except);
        if (jsonArray == null) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String s = ste.getFileName() + ": Line " + ste.getLineNumber();
            printMes("getJsonArray", "Array", s, "NULL", except);
        } else {
            this.jsonArray = jsonArray;

        }

        return this;
    }

    public Estimate isArrayNum(int num) {
        this.addErrorMes("isArrayNum", num + "");
        TestFrameWork.setArraynum(num);
        if (jsonArray == null) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String s = ste.getFileName() + ": Line " + ste.getLineNumber();
            printMes("isArrayNum", num + "", s, "NULL", num + "");
        } else {
            if (jsonArray.size() != num) {
                StackTraceElement ste = new Throwable().getStackTrace()[1];
                String s = ste.getFileName() + ": Line " + ste.getLineNumber();
                printMes("isArrayNum", num + "", s, jsonArray.size() + "", num + "");
            }
        }

        return this;

    }

    public Estimate isArrayKey() {
        this.addErrorMes("isArrayKey");
        if (jsonArray == null) {
            TestFrameWork.setIsenterArray(1);//json进入数组
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String s = ste.getFileName() + ": Line " + ste.getLineNumber();
            printMes("isArrayKey", ">=1", s, "NULL", "Key");
            return this;
        } else {
            if (jsonArray.size() == 0) {
                StackTraceElement ste = new Throwable().getStackTrace()[1];
                String s = ste.getFileName() + ": Line " + ste.getLineNumber();
                printMes("isArrayKey", ">=1", s, jsonArray.size() + "", "Key");
                return this;
            } else {
                TestFrameWork.setIsenterArray(1);//json进入数组
                this.saveAllJsonObject = this.jsonObject;
                this.jsonObject = jsonArray.getJSONObject(0);
                return this;
            }
        }
    }

    private static void enterData(String key, Object val) {
        if (TestFrameWork.getIsenterArray() == 0) {
            TestFrameWork.getResponseJson().put(key, val);
        } else {
            TestFrameWork.getResponseArray().put(key, val);
        }
    }

    public Estimate isArrayEnd() {
        this.addErrorMes("isArrayEnd");
        String arraydata = TestFrameWork.getArraydata();
        JSONObject arrayjson = TestFrameWork.getResponseArray();
        JSONArray array = new JSONArray();
        if (TestFrameWork.getArraynum() != -1) {
            for (int i = 0; i < 1; i++) {
                array.add(i, arrayjson.toString());
            }
        } else {
            array.add(arrayjson.toString());
            array.add("{...}");
        }

        this.jsonObject = this.saveAllJsonObject;
        TestFrameWork.getResponseJson().put(arraydata, array);
        TestFrameWork.setArraydata("");
        TestFrameWork.getResponseArray().clear();
        TestFrameWork.setIsenterArray(0);

        return this;
    }

    public Estimate printJsonObject() {
        System.out.println(this.jsonObject.toString());
        return this;
    }

    public void addErrorMes(String method, String mes1, String mes2) {
        errormes = errormes + "." + method + "(\"" + mes1 + "\"," + mes2 + ")";
    }

    public void addErrorMes(String method, String mes1) {
        errormes = errormes + "." + method + "(\"" + mes1 + "\")";
    }

    public void addErrorMes(String method) {
        errormes = errormes + "." + method + "()";
    }

    private void printMes(String method, String except, String meg, String actual, String key) {
        String s = "";
        for (int i = 0; i < errormes.indexOf(key) + 16; i++) {
            s += " ";
        }

        System.out.println("---------------------------------------");
        System.out.println(meg);
        System.out.println("===============>" + errormes);
        System.out.println(s + "^");
        System.out.println("error => " + method);
        System.out.println("Except => " + except);
        System.out.println("Actual => " + actual);
        System.out.println("---------------------------------------");
    }


}
