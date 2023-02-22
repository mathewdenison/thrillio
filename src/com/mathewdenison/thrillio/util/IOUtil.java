package com.mathewdenison.thrillio.util;

import java.io.*;

public class IOUtil {

  public static void read(String[] data, String filename) {
    try (BufferedReader br = new BufferedReader(
        new InputStreamReader(new FileInputStream(filename), "UTF-8"))) {
      String line;
      int count = 0;
      while ((line = br.readLine()) != null) {
        data[count] = line;
        count++;
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static String read(InputStream in) {
    StringBuilder text = new StringBuilder();

    try (BufferedReader br = new BufferedReader(
        new InputStreamReader(in, "UTF-8"))) {
      String line;
      while ((line = br.readLine()) != null) {
        text.append(line + "\n");
      }
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return text.toString();
  }

  public static void write(String webpage, long id) {
    try (BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream(
            "/Users/Mat/Intellij Projects/thrillio/pages/" + String.valueOf(id) +
                ".html"),
            "UTF-8"))) {
      writer.write(webpage);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
