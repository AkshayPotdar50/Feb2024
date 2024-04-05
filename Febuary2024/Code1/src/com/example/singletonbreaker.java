package com.example;


import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class singletonbreaker {
    public static void main(String[] args) throws
            ClassNotFoundException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException,
            IOException {
        Singleton originalInstance = Singleton.getInstance();
        Singleton duplicateInstance = Singleton.getInstance();

        System.out.println("hashcode for originalInstance "+ originalInstance.hashCode());
        System.out.println("hashcode for DuplicateInstance " +duplicateInstance.hashCode());



        //reflection

        Class<?> singleTonClass = Class.forName("com.example.Singleton");
        Constructor<Singleton> constructor = (Constructor<Singleton>) singleTonClass.getDeclaredConstructor();
        constructor.setAccessible(true);

        Singleton brokenSington =constructor.newInstance();

        System.out.println("*//BROKEN SINGLETON//*");
        System.out.println("hashcode for originalInstance "+ originalInstance.hashCode());
        System.out.println("hashcode for brokenSington " +brokenSington.hashCode());


        //WAY THREE SERIALIZATION
        System.out.println("/*using serialization*/");

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("E:\\Serialization.ser"));
            objectOutputStream.writeObject(originalInstance);
            objectOutputStream.close();

            //deserialization
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("E:\\Serialization.ser"));
        Singleton brokenSingletonSerialization = (Singleton) inputStream.readObject();

        System.out.println("hashcode for originalInstance "+ originalInstance.hashCode());
        System.out.println("after serialization "+brokenSingletonSerialization.hashCode());

        //by using clonning
        System.out.println("by using clonning");
        Singleton brokenSingletonUsingClone =originalInstance.clone();
        System.out.println("hashcode for originalInstance "+ originalInstance.hashCode());
        System.out.println("after clonning "+brokenSingletonUsingClone.hashCode());

    }

}
