package com.ivyps.pslib;

import com.ivyps.pslib.doit.Problem;

public class MainClass {
    /**
     * 'Do it! 알고리즘 코딩 테스트' 저서 내 문제 번호
     */
    public static int problemNo = 13;

    public static void main(String[] args) {
        System.out.println("Hello PS");
        executeProblem(problemNo, "com.ivyps.pslib.doit");
    }

    /**
     * 해당 문제번호의 문제클래스를 실행
     * @param problemNo : 문제번호
     * @param packageName : 문제클래스의 패키지명
     */
    private static void executeProblem(int problemNo, String packageName) {
        String className = packageName+".Problem"+problemNo;
        System.out.println("Build " + className);
        Problem problemObj;

        try {
            Class problemClass = Class.forName(className);
            problemObj = (Problem) problemClass.newInstance();
            problemObj.problemSolving();
        } catch (ClassNotFoundException e) {
            System.out.println(className + " ClassNotFoundException");
            e.printStackTrace();
        } catch (InstantiationError e) {
            System.out.println(className + " InstantiationError");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}