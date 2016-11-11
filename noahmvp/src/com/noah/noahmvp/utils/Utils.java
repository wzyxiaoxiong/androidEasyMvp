package com.noah.noahmvp.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import android.annotation.SuppressLint;

public class Utils {

	@SuppressLint("DefaultLocale")
	public static void bean2Entity(Class<?> clazzSet, Object entity,  Class<?>clazzGet, Object bean){
		Field[] fields1 = clazzSet.getDeclaredFields();
		Field[] fields2 = clazzGet.getDeclaredFields();
		ArrayList<Field> list= getShare(fields1, fields2); 
		Field[] commFields = new Field[list.size()];
		for (int i = 0; i < commFields.length; i++) {
			commFields[i] = list.get(i);
		}
		
		for (int i = 0; i < commFields.length; i++) {
			Field field = commFields[i];
			String fieldName = field.getName();
			String methodNameGet ="get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
			String methodNameSet = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
			Method setMethod = null;
			Method getMethod = null;
			try {
				setMethod = clazzSet.getDeclaredMethod(methodNameSet, field.getType());
				getMethod = clazzGet.getDeclaredMethod(methodNameGet);
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
			try {
				Object obj = getMethod.invoke(bean);
				setMethod.invoke(entity, obj);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			
		}
	 
	}
	
	//获取两个数组都有的元素
	//java不支持泛型数组创建
	public static <T>ArrayList<T> getShare(T[] arr1, T[]arr2){
		if(arr1==null || arr2==null || arr1.length<=0 || arr2.length<=0){
			return null;
		}
		
		ArrayList<T> list = new ArrayList<T>();
		for (int i = 0; i < arr1.length; i++) {
			T t1 = arr1[i];
			for (int j = 0; j < arr2.length; j++) {
				T t2 = arr2[j];
				if(t1 instanceof Field){
					if(((Field)t1).getName().equals(((Field)t2).getName())){
						list.add(t1);
					}
				}
				else if(t1.equals(t2)){
					list.add(t1);
				}
			}
		}
		
		if(list==null || list.size()<=0){
			return null;
		}
		 
		return list;
	}
}
