package main.java.FileIO;

import java.io.*;

class Main<K, V> {
    public static void main(String []args){
        try{
            BufferedWriter bc = new BufferedWriter(
                    new FileWriter("C:\\Users\\raisa\\IdeaProjects\\GenericsPractice\\src\\main\\resources\\BasicFileIO"));
            bc.write("hello\n");
            bc.write("hello\n");
            bc.write("hello\n");
            bc.close();

        } catch (Exception ex){
            return;
        }

        try{
            BufferedReader br = new BufferedReader(
                    new FileReader("C:\\Users\\raisa\\IdeaProjects\\GenericsPractice\\src\\main\\resources\\BasicFileIO")
            );
            String s;
            while ((s = br.readLine()) != null){
                System.out.println(s);
            }
            br.close();
        } catch (Exception ex){
            return;
        }


        try{
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("C:\\Users\\raisa\\IdeaProjects\\GenericsPractice\\src\\main\\resources\\FileCopy")
            );
            BufferedReader br = new BufferedReader(
                    new FileReader("C:\\Users\\raisa\\IdeaProjects\\GenericsPractice\\src\\main\\resources\\BasicFileIO")
            );
            String s;
            while ((s = br.readLine()) != null){
                bw.write(s + "\n");
            }
            bw.close();
            br.close();
        } catch (Exception ex){
            return;
        }
    }
}
