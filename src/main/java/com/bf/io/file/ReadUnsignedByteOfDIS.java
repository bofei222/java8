package com.bf.io.file;

import java.io.*;

/**
 * @description:
 * @author: bofei
 * @date: 2020-09-02 16:30
 **/
public class ReadUnsignedByteOfDIS {

    public static void main(String[] args) throws IOException {
        InputStream is_stm = null;
        DataInputStream dis_stm = null;
        FileOutputStream fos_stm = null;
        DataOutputStream dos_stm = null;
        byte[] b_arr = {
                125,
                111,
                -121,
                -112
        };
        try {
            // Instantiate FileInputStream,
            // DataInputStream, FileOutputStream
            // and DataOutputStream

            fos_stm = new FileOutputStream("D:\\includehelp.txt");
            dos_stm = new DataOutputStream(fos_stm);

            // Loop to write each byte till end
            for (byte val : b_arr) {
                // By using writeByte() method isto
                // write a byte value to the
                // DataOutputStream dos_stm
                dos_stm.writeByte(val);
            }

         /*   is_stm = new FileInputStream("D:\\includehelp.txt");
            dis_stm = new DataInputStream(is_stm);

            // Loop To Read Available Data till end
            while (dis_stm.available() > 0) {
                // By using readUnsignedByte() method isto read
                // unsigned byte at a time from dis_stm
                int in = dis_stm.readUnsignedByte();
                System.out.println("dis_stm.readUnsignedByte(): " + in);
            }*/
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            // To free system resources linked
            // with these streams
            if (is_stm != null)
                is_stm.close();

            if (dis_stm != null)
                dis_stm.close();

            if (dos_stm != null)
                dos_stm.close();

            if (fos_stm != null)
                fos_stm.close();
        }
    }
}
