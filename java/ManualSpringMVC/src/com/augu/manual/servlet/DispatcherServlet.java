package com.augu.manual.servlet;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.augu.manual.annotation.Controller;
import com.augu.manual.annotation.Quatifier;
import com.augu.manual.annotation.RequestMapping;
import com.augu.manual.annotation.Service;
import com.augu.manual.controller.SpringmvcController;

@WebServlet("/DispatcherServlet/*")
public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String BASE_PACKAGE = "com.augu.manual";

    List<String> classNames = new ArrayList<String>();
    // 所有类的实例，key是注解的'value',value是所有类的实例
    Map<String, Object> instanceMap = new HashMap<String, Object>();
    // 映射关系
    Map<String, Object> handerMap = new HashMap<String, Object>();

    public DispatcherServlet() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
        // 第一步： 包扫描,获取包中的文件
        scanPackage(BASE_PACKAGE);
        // 第二步： 过滤和实例化
        try {
            filterAndInstance();
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found error:\n" + e);
        } catch (InstantiationException | IllegalAccessException e1) {
            System.err.println("Instantiation error:\n" + e1);
        }
        // 第三步： 建立映射关系,（地址映射，不同的地址映射到不同Controller method）
        handerMap();
        // 第四步： 实现注入
        try {
            ioc();
        } catch (IllegalArgumentException | IllegalAccessException e) {
            System.err.println("IllegalArgument error:\n" + e);
        }
    }

    private void ioc() throws IllegalArgumentException, IllegalAccessException {
        if (instanceMap.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : instanceMap.entrySet()) {
            Field[] instanceFields = entry.getValue().getClass().getDeclaredFields();
            for (Field f : instanceFields){
                f.setAccessible(true);
                if (f.isAnnotationPresent(Quatifier.class)){
                    Quatifier fieldAnnotation = f.getAnnotation(Quatifier.class);
                    String fieldAnnotationValue = fieldAnnotation.value();
                    f.set(entry.getValue(), instanceMap.get(fieldAnnotationValue));
                }
            }
        }
    }

    private void handerMap() {
        if (instanceMap.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : instanceMap.entrySet()) {
            Class<?> instanceClass = entry.getValue().getClass();
            if (instanceClass.isAnnotationPresent(Controller.class)) {
                Controller instanceControllerAnnotation = instanceClass.getAnnotation(Controller.class);
                String instanceControllerAnnotationValue = instanceControllerAnnotation.value();
                Method[] methods = instanceClass.getMethods();
                for (Method m : methods) {
                    if (m.isAnnotationPresent(RequestMapping.class)) {
                        RequestMapping methodAnnotation = m.getAnnotation(RequestMapping.class);
                        String methodAnnotationValue = methodAnnotation.value();
                        handerMap.put("/" + instanceControllerAnnotationValue + "/" + methodAnnotationValue, m);
                    } else {
                        continue;
                    }
                }
            } else {
                continue;
            }
        }
    }

    private void filterAndInstance() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        if (classNames.size() <= 0) {
            return;
        }
        for (String className : classNames) {
            Class<?> classObj = Class.forName(className.replace(".class", "").trim());
            if (classObj.isAnnotationPresent(Controller.class)) {
                Object instance = classObj.newInstance();
                Controller controllerAnnotation = (Controller) classObj.getAnnotation(Controller.class);
                String controllerAnnotationValue = controllerAnnotation.value();
                instanceMap.put(controllerAnnotationValue, instance);
            } else if (classObj.isAnnotationPresent(Service.class)) {
                Object instance = classObj.newInstance();
                Service serviceAnnotation = (Service) classObj.getAnnotation(Service.class);
                String serviceAnnotationValue = serviceAnnotation.value();
                instanceMap.put(serviceAnnotationValue, instance);
            } else {
                continue;
            }
        }
    }

    /**
     * 扫描包下的所有文件
     */
    private void scanPackage(String basePackage) {
        // System.out.println("scanPackage 1: " +  "/" + replaceAllString(basePackage));
        URL url = this.getClass().getClassLoader().getResource("/" + replaceAllString(basePackage));
        String basePackagePath = url.getFile();
        File basePackageFile = new File(basePackagePath);
        File[] filesUnderBasePackage = basePackageFile.listFiles();
        for (File f : filesUnderBasePackage) {
            if (f.isDirectory()) {
                scanPackage(basePackage + "." + f.getName());
            } else {
                classNames.add(basePackage + "." + f.getName());
            }
        }
    }

    private String replaceAllString(String origString) {
        return origString.replaceAll("\\.", "/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Request URL: http://localhost:8080/ManualSpringMVC/DispatcherServlet/test/delete
        String methodPath  = request.getPathInfo(); // /test/delete
        Method method = (Method) handerMap.get(methodPath);
        String controllerPath = methodPath.split("/")[1]; // test
        SpringmvcController controller = (SpringmvcController) instanceMap.get(controllerPath);
        try {
            method.invoke(controller, new Object[]{request, response, null});
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
