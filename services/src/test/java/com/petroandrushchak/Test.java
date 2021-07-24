package com.petroandrushchak;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.body.AnnotationDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.google.common.base.Strings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {

    //Get All TestRails testcases links in the TAF
    public static void main(String[] args) {

        File projectDir = new File("/Users/pandr/Workspace/RealtyNext-Infra/automation/realty-austin-tests");

        new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
            System.out.println(path);
            System.out.println(Strings.repeat("=", path.length()));

            try {
                new VoidVisitorAdapter<>() {
                    @Override
                    public void visit(AnnotationDeclaration annotationDeclaration, Object arg) {
                        super.visit(annotationDeclaration, arg);
                        System.out.println("Object: " +  arg);
                        System.out.println("Annotation name * " + annotationDeclaration.getName());
                    }
                }.visit(StaticJavaParser.parse(file), null);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

//            try {
//                new VoidVisitorAdapter<>() {
//                    @Override
//                    public void visit(ClassOrInterfaceDeclaration n, Object arg) {
//                        super.visit(n, arg);
//                        System.out.println(" * " + n.getName());
//                    }
//                }.visit(StaticJavaParser.parse(file), null);
//                System.out.println();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
        }).explore(projectDir);

    }
}

