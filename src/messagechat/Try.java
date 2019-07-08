/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messagechat;

import java.io.File;

/**
 *
 * @author SHABAAN
 */
public class Try {

    public static void main(String[] args) {
        File file = new File("src/database/MessageChat.db");

        if (file.renameTo(new File("src/database/MessageChat.db.cr"))) {
            // if file copied successfully then delete the original file 
            file.delete();
            System.out.println("File moved successfully");
        } else {
            System.out.println("Failed to move the file");
        }
    }
}
