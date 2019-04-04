package com.yurtcan.astronaut.utils;

import java.util.ArrayList;
import java.util.List;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EnumUtils {

  /**
   * @param enumType The enumType must have a getName() method. Otherwise a NoSuchMethodException will ne thrown
   * @param name Name attribute of the enum
   * @param <T> Type of the enum
   * @return the enum instance with the given name
   * @throws NoSuchMethodException See {@link Class#getMethod}
   * @throws InvocationTargetException See {@link Method#invoke(Object, Object...)}
   * @throws IllegalAccessException See {@link Method#invoke(Object, Object...)}
   */
  public static <T extends Enum<T>> T byName(Class<T> enumType, String name) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    if (enumType == null) {
      throw new IllegalArgumentException("enumType cannot be null");
    }
    if (name == null) {
      throw new IllegalArgumentException("name cannot be null");
    }

    T result = null;

    for (T enumConstant : enumType.getEnumConstants()) {
      Method getName = enumType.getMethod("getName");
      Object nameOfEnum = getName.invoke(enumConstant);
      if (name.equals(nameOfEnum)) {
        result = enumConstant;
        break;
      }
    }
    return result;
  }

  /**
   * @param enumType The enumType must have a getCode() method. Otherwise a NoSuchMethodException will ne thrown
   * @param code Code attribute of the enum
   * @param <T> Type of the enum
   * @return the enum instance with the given code
   * @throws NoSuchMethodException See {@link Class#getMethod}
   * @throws InvocationTargetException See {@link Method#invoke(Object, Object...)}
   * @throws IllegalAccessException See {@link Method#invoke(Object, Object...)}
   */
  public static <T extends Enum<T>> T byCode(Class<T> enumType, String code) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    if (enumType == null) {
      throw new IllegalArgumentException("enumType cannot be null");
    }
    if (code == null) {
      throw new IllegalArgumentException("code cannot be null");
    }

    T result = null;

    for (T enumConstant : enumType.getEnumConstants()) {
      Method getCode = enumType.getMethod("getCode");
      Object codeOfEnum = getCode.invoke(enumConstant);
      if (code.equals(codeOfEnum)) {
        result = enumConstant;
        break;
      }
    }
    return result;
  }

  /**
   *
   * @param enumType The enumType must have a getId() method. Otherwise a NoSuchMethodException will ne thrown
   * @param id id attribute of the enum
   * @param <T> Type of the enum
   * @return the enum instance with the given id
   * @throws NoSuchMethodException See {@link Class#getMethod}
   * @throws InvocationTargetException See {@link Method#invoke(Object, Object...)}
   * @throws IllegalAccessException See {@link Method#invoke(Object, Object...)}
   */
  public static <T extends Enum<T>> T byId(Class<T> enumType, Long id) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    if (enumType == null) {
      throw new IllegalArgumentException("enumType cannot be null");
    }
    if (id == null) {
      throw new IllegalArgumentException("id cannot be null");
    }

    T result = null;

    for (T enumConstant : enumType.getEnumConstants()) {
      Method getId = enumType.getMethod("getId");
      Object idOfEnum = getId.invoke(enumConstant);
      if (id.equals(idOfEnum)) {
        result = enumConstant;
        break;
      }
    }
    return result;
  }

  /**
   * This method returns the ID of a constant enum with type <code>enumType</code> and name <code>name</code>
   *
   * @param enumType Type of the enum class
   * @param name name of the enum
   * @param <T> Type
   * @throws NoSuchMethodException See {@link Class#getMethod}
   * @throws InvocationTargetException See {@link Method#invoke(Object, Object...)}
   * @throws IllegalAccessException See {@link Method#invoke(Object, Object...)}
   */
  public static <T extends Enum<T>> Long idByName(Class<T> enumType, String name) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    T enumConstant = byName(enumType, name);
    if (enumConstant == null) {
      throw new RuntimeException("Could not find an enum constant in class " + enumType + " with the name field " + name);
    }
    return (Long) enumConstant.getClass().getMethod("getId").invoke(enumConstant);
  }

  public static <T extends Enum<T>> String convertFromNameListToIdList(Class<T> enumType, String csvWithNames, String delimiter)
          throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
    if (delimiter == null) {
      throw new IllegalArgumentException("Cannot convert csv names since the delimiter is null");
    }

    if (csvWithNames == null) {
      return null;
    }

    String[] names = csvWithNames.split(delimiter);
    StringBuilder ids = new StringBuilder();
    for (String name : names) {
      if (ids.length() > 0) {
        ids.append(delimiter);
      }
      T enumConstant = byName(enumType, name);
      ids.append(enumType.getMethod("getId").invoke(enumConstant));
    }

    return ids.toString();
  }

  /**
   * This method takes a csvNames String and returns a list of all enum constants which have those names
   * @param enumType enumType
   * @param csvNames csvNames
   * @param delimiter delimiter
   * @param <T> Type of enum class
   * @return A list of all enum constants which have those names
   */
  public static <T extends Enum> List<T> convertFromNameCsvString(Class<T> enumType, String csvNames, String delimiter)
          throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
    if (delimiter == null) {
      throw new IllegalArgumentException("Cannot convert csv names since the delimiter is null");
    }

    if (csvNames == null) {
      return null;
    }

    List<T> resultList = null;

    String[] names = csvNames.split(delimiter);
    if (names.length > 0) {
      resultList = new ArrayList<>();
      for (String name : names) {
        resultList.add((T) byName(enumType, name));
      }
    }
    return resultList;
  }
}
